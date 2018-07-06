package xyz.imei.restaurant.data.models;

import xyz.imei.restaurant.network.retrofit.RetrofitDataAgentImpl;

public class ASTLModel {

    private static ASTLModel mInstance;

    private RetrofitDataAgentImpl dataAgent;

    private ASTLModel() {
            dataAgent = RetrofitDataAgentImpl.getmInstance();
    }

    public static ASTLModel getmInstance() {
        if (mInstance == null) mInstance = new ASTLModel();
        return mInstance;
    }

    public void loadWarDees(String accessToken){
        dataAgent.loadMeals(accessToken);
    }

}
