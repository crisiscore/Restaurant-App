package xyz.imei.restaurant.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import xyz.imei.restaurant.data.vos.WarDeeVO;
import xyz.imei.restaurant.delegates.MealDelegate;

public class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public void bind(MealDelegate delegate, WarDeeVO warDeeVO){}
}
