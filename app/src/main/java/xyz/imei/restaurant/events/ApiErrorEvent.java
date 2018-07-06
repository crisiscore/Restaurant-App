package xyz.imei.restaurant.events;

public class ApiErrorEvent {

    private String errMessage;

    public ApiErrorEvent(String errMessage) {
        this.errMessage = errMessage;
    }

    public String getErrMessage() {
        return errMessage;
    }
}
