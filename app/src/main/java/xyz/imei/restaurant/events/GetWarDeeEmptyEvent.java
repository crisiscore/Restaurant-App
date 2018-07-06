package xyz.imei.restaurant.events;

public class GetWarDeeEmptyEvent {

    private String message;

    public GetWarDeeEmptyEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
