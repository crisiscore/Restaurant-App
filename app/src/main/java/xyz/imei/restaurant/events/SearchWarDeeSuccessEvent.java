package xyz.imei.restaurant.events;

import java.util.List;

import xyz.imei.restaurant.data.vos.WarDeeVO;

public class SearchWarDeeSuccessEvent {

    private List<WarDeeVO> warDeeVOList;

    public SearchWarDeeSuccessEvent(List<WarDeeVO> warDeeVOList) {
        this.warDeeVOList = warDeeVOList;
    }

    public List<WarDeeVO> getSearchWarDeeVOList() {
        return warDeeVOList;
    }

}
