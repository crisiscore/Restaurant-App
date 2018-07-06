package xyz.imei.restaurant.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import xyz.imei.restaurant.data.vos.WarDeeVO;

public class GetWarDeeResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("astlWarDee")
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

    public List<WarDeeVO> getWarDeeVOList() {
        return warDeeVOList;
    }

    public boolean isResponseOK() {
        return code == 200 && warDeeVOList.size() > 0;
    }
}
