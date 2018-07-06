package xyz.imei.restaurant.events;

import java.util.List;

import xyz.imei.restaurant.data.vos.WarDeeVO;

public class GetWarDeeSuccessEvent {

    private List<WarDeeVO> warDeeVOList;

    public GetWarDeeSuccessEvent(List<WarDeeVO> warDeeVOList) {
        this.warDeeVOList = warDeeVOList;
    }

    public List<WarDeeVO> getWarDeeVOList() {
        return warDeeVOList;
    }
}
