package xyz.imei.restaurant.data.vos;

import com.google.gson.annotations.SerializedName;

public class SuitedForVO {

    @SerializedName("suitedForId")
    private String suitedForId;
    @SerializedName("suitedFor")
    private String suitedFor;
    @SerializedName("suitedForDesc")
    private String suitedForDesc;


    public String getSuitedForId() {
        return suitedForId;
    }

    public String getSuitedFor() {
        return suitedFor;
    }

    public String getSuitedForDesc() {
        return suitedForDesc;
    }
}
