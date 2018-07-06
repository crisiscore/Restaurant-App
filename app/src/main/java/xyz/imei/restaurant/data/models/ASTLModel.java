package xyz.imei.restaurant.data.models;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;

import xyz.imei.restaurant.data.vos.WarDeeVO;
import xyz.imei.restaurant.events.GetWarDeeSuccessEvent;
import xyz.imei.restaurant.events.SearchWarDeeSuccessEvent;
import xyz.imei.restaurant.network.retrofit.RetrofitDataAgentImpl;

public class ASTLModel {

    private static ASTLModel mInstance;

    private RetrofitDataAgentImpl dataAgent;

    private HashMap<String , WarDeeVO> mWarDeeMap;

    private ASTLModel() {

        dataAgent = RetrofitDataAgentImpl.getmInstance();

        mWarDeeMap = new HashMap<>();

        EventBus.getDefault().register(this);
    }

    public static ASTLModel getmInstance() {
        if (mInstance == null) mInstance = new ASTLModel();
        return mInstance;
    }

    public void loadWarDees(String accessToken) {
        dataAgent.loadWarDees(accessToken);
    }

    public void searchWarDees(String accessToken,
                              String tasteType,
                              String suited,
                              int minPrice,
                              int maxPrice,
                              boolean isNearBy,
                              String currentTsp,
                              double currentLat,
                              double currentLng) {
        dataAgent.searchWarDee(accessToken,
                tasteType,
                suited,
                minPrice,
                maxPrice,
                isNearBy,
                currentTsp,
                currentLat,
                currentLng);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSuccessGetWarDee(GetWarDeeSuccessEvent event) {
        for (WarDeeVO warDeeVO : event.getWarDeeVOList()){
            mWarDeeMap.put(warDeeVO.getWarDeeId() , warDeeVO);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSuccessSearchWarDee(SearchWarDeeSuccessEvent event) {
        for (WarDeeVO warDeeVO : event.getSearchWarDeeVOList()){
            mWarDeeMap.put(warDeeVO.getWarDeeId() , warDeeVO);
        }
    }

    public WarDeeVO getWarDeeById(String id){
        return mWarDeeMap.get(id);
    }
}
