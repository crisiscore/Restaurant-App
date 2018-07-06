package xyz.imei.restaurant.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.imei.restaurant.R;
import xyz.imei.restaurant.data.models.ASTLModel;
import xyz.imei.restaurant.data.vos.WarDeeVO;
import xyz.imei.restaurant.utils.ASTLConstants;

public class MealDetailsActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_meal_name)
    TextView tvMealName;
    @BindView(R.id.tv_meal_price)
    TextView tvMealPrice;
    @BindView(R.id.tv_meal_description)
    TextView tvMealDescription;
    @BindView(R.id.iv_meal)
    ImageView ivMealImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_details);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(null);
        }

        String warDeeId = getIntent().getStringExtra(ASTLConstants.WAR_DEE_ID);

        if (warDeeId != null && !warDeeId.equals("")) {
            WarDeeVO warDeeVO = ASTLModel.getmInstance().getWarDeeById(warDeeId);
            bindData(warDeeVO);
        }
    }

    private void bindData(WarDeeVO warDeeVO) {
        Glide.with(ivMealImage.getContext()).load(warDeeVO.getImages().get(0)).into(ivMealImage);
        tvMealName.setText(warDeeVO.getName());
        tvMealPrice.setText(String.valueOf(warDeeVO.getPriceRangeMin()).concat(" ").concat("ကျပ်"));
        tvMealDescription.setText(warDeeVO.getGeneralTaste().get(0).getTasteDesc());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) super.onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
