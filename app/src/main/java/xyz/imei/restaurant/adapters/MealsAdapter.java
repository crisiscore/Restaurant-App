package xyz.imei.restaurant.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

import xyz.imei.restaurant.R;
import xyz.imei.restaurant.data.vos.WarDeeVO;
import xyz.imei.restaurant.delegates.MealDelegate;
import xyz.imei.restaurant.viewholders.BaseViewHolder;
import xyz.imei.restaurant.viewholders.CategoryViewHolder;
import xyz.imei.restaurant.viewholders.MealsViewHolder;

public class MealsAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private MealDelegate mDelegate;
    private List<WarDeeVO> mItemsList;
    private static final int VIEW_TYPE_HEADER = 100;
    private static final int VIEW_TYPE_MEAL = 200;

    public MealsAdapter(MealDelegate mDelegate) {
        this.mDelegate = mDelegate;
        mItemsList = new ArrayList<>();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_category, parent, false);
            return new CategoryViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_meal, parent, false);
            return new MealsViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        if (mItemsList.get(position) != null)
            holder.bind(mDelegate, mItemsList.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_HEADER;
        } else {
            return VIEW_TYPE_MEAL;
        }
    }

    @Override
    public int getItemCount() {
        return mItemsList.size();
    }

    public void setWarDees(List<WarDeeVO> warDeeVOList) {

        mItemsList.clear();
        notifyDataSetChanged();

        mItemsList.add(null);
        mItemsList.addAll(warDeeVOList);
        notifyDataSetChanged();
    }
}
