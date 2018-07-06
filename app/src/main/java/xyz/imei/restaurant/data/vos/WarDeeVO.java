package xyz.imei.restaurant.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class WarDeeVO {

    @SerializedName("warDeeId")
    private String warDeeId;
    @SerializedName("name")
    private String name;
    @SerializedName("images")
    private List<String> images = null;
    @SerializedName("generalTaste")
    private List<GeneralTasteVO> generalTaste = null;
    @SerializedName("suitedFor")
    private List<SuitedForVO> suitedFor = null;
    @SerializedName("priceRangeMin")
    private Integer priceRangeMin;
    @SerializedName("priceRangeMax")
    private Integer priceRangeMax;
    @SerializedName("matchWarDeeList")
    private List<MatchWarDeeListVO> matchWarDeeList = null;
    @SerializedName("shopByDistance")
    private List<ShopByDistanceVO> shopByDistance = null;
    @SerializedName("shopByPopularity")
    private List<ShopByPopularityVO> shopByPopularity = null;

    public String getWarDeeId() {
        return warDeeId;
    }

    public String getName() {
        return name;
    }

    public List<String> getImages() {
        return images == null ? new ArrayList<String>() : images;
    }

    public List<GeneralTasteVO> getGeneralTaste() {
        return generalTaste == null ? new ArrayList<GeneralTasteVO>() : generalTaste;
    }

    public List<SuitedForVO> getSuitedFor() {
        return suitedFor;
    }

    public Integer getPriceRangeMin() {
        return priceRangeMin;
    }

    public Integer getPriceRangeMax() {
        return priceRangeMax;
    }

    public List<MatchWarDeeListVO> getMatchWarDeeList() {
        return matchWarDeeList;
    }

    public List<ShopByDistanceVO> getShopByDistance() {
        return shopByDistance;
    }

    public List<ShopByPopularityVO> getShopByPopularity() {
        return shopByPopularity;
    }
}
