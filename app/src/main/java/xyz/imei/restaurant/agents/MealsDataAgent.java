package xyz.imei.restaurant.agents;

public interface MealsDataAgent {

    void loadWarDees(String accessToken);

    void searchWarDee(String accessToken,
                      String tasteType,
                      String suited,
                      int minPrice,
                      int maxPrice,
                      boolean isNearBy,
                      String currentTsp,
                      double currentLat,
                      double currentLng);

}
