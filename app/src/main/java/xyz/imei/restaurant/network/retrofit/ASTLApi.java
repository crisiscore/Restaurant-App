package xyz.imei.restaurant.network.retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import xyz.imei.restaurant.network.responses.GetWarDeeResponse;
import xyz.imei.restaurant.network.responses.SearchWarDeeResponse;
import xyz.imei.restaurant.utils.ASTLConstants;

public interface ASTLApi {

    @FormUrlEncoded
    @POST(ASTLConstants.GET_WAR_DEE)
    Call<GetWarDeeResponse> getWarDeeList(@Field(ASTLConstants.PARAM_ACCESS_TOKEN) String accessToken);


    @FormUrlEncoded
    @POST(ASTLConstants.SEARCH_WAR_DEE)
    Call<SearchWarDeeResponse> searchWarDee(@Field(ASTLConstants.PARAM_ACCESS_TOKEN)String accessToken,
                                            @Field(ASTLConstants.PARAM_TASTE_TYPE)String tasteType,
                                            @Field(ASTLConstants.PARAM_SUITED) String suited,
                                            @Field(ASTLConstants.PARAM_MIN_PRICE)int minPrice,
                                            @Field(ASTLConstants.PARAM_MAX_PRICE)int maxPrice,
                                            @Field(ASTLConstants.PARAM_IS_NEARBY)boolean isNearBy,
                                            @Field(ASTLConstants.PARAM_CURRENT_TOWNSHIP)String currentTsp,
                                            @Field(ASTLConstants.PARAM_CURRENT_LAT)double currentLat,
                                            @Field(ASTLConstants.PARAM_CURRENT_LNG)double currentLng);
}
