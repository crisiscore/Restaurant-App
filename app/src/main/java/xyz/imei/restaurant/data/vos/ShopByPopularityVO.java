package xyz.imei.restaurant.data.vos;

import com.google.gson.annotations.SerializedName;

public class ShopByPopularityVO {

    @SerializedName("shopByPopularityId")
    private String shopByPopularityId;
    @SerializedName("mealShop")
    private MealShopVO mealShop;

    public String getShopByPopularityId() {
        return shopByPopularityId;
    }

    public MealShopVO getMealShop() {
        return mealShop;
    }
}
