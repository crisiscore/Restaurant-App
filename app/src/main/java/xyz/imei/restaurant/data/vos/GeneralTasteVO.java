package xyz.imei.restaurant.data.vos;

import com.google.gson.annotations.SerializedName;

public class GeneralTasteVO {

    @SerializedName("tasteId")
    private String tasteId;
    @SerializedName("taste")
    private String taste;
    @SerializedName("tasteDesc")
    private String tasteDesc;

    public String getTasteId() {
        return tasteId;
    }

    public String getTaste() {
        return taste;
    }

    public String getTasteDesc() {
        return tasteDesc;
    }
}
