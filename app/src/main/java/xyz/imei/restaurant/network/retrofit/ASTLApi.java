package xyz.imei.restaurant.network.retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import xyz.imei.restaurant.network.responses.GetWarDeeResponse;
import xyz.imei.restaurant.utils.ASTLConstants;

public interface ASTLApi {

    @FormUrlEncoded
    @POST(ASTLConstants.GET_WAR_DEE)
    Call<GetWarDeeResponse> getWarDeeList(@Field(ASTLConstants.PARAM_ACCESS_TOKEN) String accessToken);

}
