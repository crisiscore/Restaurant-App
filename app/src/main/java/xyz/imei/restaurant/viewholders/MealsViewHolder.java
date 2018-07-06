package xyz.imei.restaurant.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.imei.restaurant.R;
import xyz.imei.restaurant.data.vos.WarDeeVO;
import xyz.imei.restaurant.delegates.MealDelegate;

public class MealsViewHolder extends BaseViewHolder implements View.OnClickListener {

    private MealDelegate mDelegate;

    @BindView(R.id.iv_meal)ImageView ivMealImage;
    @BindView(R.id.tv_meal_name)TextView tvMealName;
    @BindView(R.id.tv_meal_category)TextView tvMealCategory;
    @BindView(R.id.tv_meal_price)TextView tvMealPrice;
    @BindView(R.id.tv_meal_details)TextView tvMealDetails;
    @BindView(R.id.tv_meal_rating)TextView tvMealRating;

    public MealsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }

    @Override
    public void bind(MealDelegate mealDelegate, WarDeeVO warDeeVO) {
        mDelegate = mealDelegate;
        Glide.with(ivMealImage.getContext()).load(warDeeVO.getImages().get(0)).into(ivMealImage);
        tvMealName.setText(warDeeVO.getName());
        tvMealPrice.setText(String.valueOf(warDeeVO.getPriceRangeMin()));
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == itemView.getId()) {
            mDelegate.onClickMeal();
        }
    }
}
