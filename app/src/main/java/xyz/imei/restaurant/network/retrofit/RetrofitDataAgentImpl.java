package xyz.imei.restaurant.network.retrofit;

import android.support.annotation.NonNull;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.imei.restaurant.agents.MealsDataAgent;
import xyz.imei.restaurant.events.ApiErrorEvent;
import xyz.imei.restaurant.events.GetWarDeeEmptyEvent;
import xyz.imei.restaurant.events.GetWarDeeSuccessEvent;
import xyz.imei.restaurant.events.SearchWarDeeSuccessEvent;
import xyz.imei.restaurant.network.responses.GetWarDeeResponse;
import xyz.imei.restaurant.network.responses.SearchWarDeeResponse;
import xyz.imei.restaurant.utils.ASTLConstants;
import xyz.imei.restaurant.viewpods.EmptyViewPod;

public class RetrofitDataAgentImpl implements MealsDataAgent {
    
    private static RetrofitDataAgentImpl mInstance;
    
    private ASTLApi mApi;

    private RetrofitDataAgentImpl() {
        
        OkHttpClient okHttpClient = new  OkHttpClient.Builder()
                .connectTimeout(15 , TimeUnit.SECONDS)
                .writeTimeout(15 , TimeUnit.SECONDS)
                .readTimeout(60 , TimeUnit.SECONDS)
                .build();
        
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ASTLConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        
        mApi = retrofit.create(ASTLApi.class);
        
    }

    public static RetrofitDataAgentImpl getmInstance() {
        if (mInstance == null) mInstance = new RetrofitDataAgentImpl();
        return mInstance;
    }

    @Override
    public void loadWarDees(String accessToken) {
        Call<GetWarDeeResponse> call = mApi.getWarDeeList(accessToken);
        call.enqueue(new Callback<GetWarDeeResponse>() {
            @Override
            public void onResponse(@NonNull Call<GetWarDeeResponse> call, @NonNull Response<GetWarDeeResponse> response) {
                GetWarDeeResponse warDeeResponse = response.body();
                if (warDeeResponse != null && warDeeResponse.isResponseOK()){
                    GetWarDeeSuccessEvent event = new GetWarDeeSuccessEvent(warDeeResponse.getWarDeeVOList());
                    EventBus.getDefault().post(event);
                }else if (warDeeResponse != null && warDeeResponse.getWarDeeVOList().size() == 0){
                    GetWarDeeEmptyEvent event = new GetWarDeeEmptyEvent(warDeeResponse.getMessage());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(@NonNull Call<GetWarDeeResponse> call, @NonNull Throwable t) {
                ApiErrorEvent event = new ApiErrorEvent(t.getMessage());
                EventBus.getDefault().post(event);
            }
        });
    }

    @Override
    public void searchWarDee(String accessToken, String tasteType, String suited, int minPrice, int maxPrice, boolean isNearBy, String currentTsp, double currentLat, double currentLng) {
        Call<SearchWarDeeResponse> call = mApi.searchWarDee(accessToken , tasteType , suited , minPrice , maxPrice , isNearBy , currentTsp , currentLat , currentLng);
        call.enqueue(new Callback<SearchWarDeeResponse>() {
            @Override
            public void onResponse(@NonNull Call<SearchWarDeeResponse> call, @NonNull Response<SearchWarDeeResponse> response) {
                SearchWarDeeResponse searchWarDeeResponse = response.body();
                if (searchWarDeeResponse != null && searchWarDeeResponse.isResponseOk()){
                    SearchWarDeeSuccessEvent event = new SearchWarDeeSuccessEvent(searchWarDeeResponse.getWarDeeVOList());
                    EventBus.getDefault().post(event);
                }else if (searchWarDeeResponse != null && searchWarDeeResponse.getWarDeeVOList().size() == 0){
                    GetWarDeeEmptyEvent event = new GetWarDeeEmptyEvent(searchWarDeeResponse.getMessage());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(@NonNull Call<SearchWarDeeResponse> call, @NonNull Throwable t) {
                EventBus.getDefault().post(new ApiErrorEvent(t.getMessage()));
            }
        });
    }
}
