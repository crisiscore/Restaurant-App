package xyz.imei.restaurant.data.vos;

import com.google.gson.annotations.SerializedName;

public class ShopByDistanceVO {

    @SerializedName("shopByDistanceId")
    private String shopByDistanceId;
    @SerializedName("mealShop")
    private MealShopVO mealShop;
    @SerializedName("distanceInFeet")
    private Double distanceInFeet;

    public String getShopByDistanceId() {
        return shopByDistanceId;
    }

    public MealShopVO getMealShop() {
        return mealShop;
    }

    public Double getDistanceInFeet() {
        return distanceInFeet;
    }
}
