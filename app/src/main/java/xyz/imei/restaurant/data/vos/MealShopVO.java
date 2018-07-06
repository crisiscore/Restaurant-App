package xyz.imei.restaurant.data.vos;

import com.google.gson.annotations.SerializedName;

public class MealShopVO {

    @SerializedName("mealShopId")
    private String mealShopId;

    public String getMealShopId() {
        return mealShopId;
    }
}
