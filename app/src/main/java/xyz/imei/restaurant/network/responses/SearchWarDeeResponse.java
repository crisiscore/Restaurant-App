package xyz.imei.restaurant.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import xyz.imei.restaurant.data.vos.WarDeeVO;

public class SearchWarDeeResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("tasteType")
    private String tasteType;

    @SerializedName("suited")
    private String suited;

    @SerializedName("minPrice")
    private String minPrice;

    @SerializedName("maxPrice")
    private String maxPrice;

    @SerializedName("isNearBy")
    private boolean isNearBy;

    @SerializedName("currentTownship")
    private String currentTownship;

    @SerializedName("currentTLat")
    private String currentLat;

    @SerializedName("currentLng")
    private String currentLng;

    @SerializedName("searchResults")
    private List<WarDeeVO> warDeeVOList;


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getTasteType() {
        return tasteType;
    }

    public String getSuited() {
        return suited;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public boolean isNearBy() {
        return isNearBy;
    }

    public String getCurrentTownship() {
        return currentTownship;
    }

    public String getCurrentLat() {
        return currentLat;
    }

    public String getCurrentLng() {
        return currentLng;
    }

    public List<WarDeeVO> getWarDeeVOList() {
        return warDeeVOList;
    }

    public boolean isResponseOk() {
        return code == 200 && warDeeVOList.size() > 0;
    }
}
