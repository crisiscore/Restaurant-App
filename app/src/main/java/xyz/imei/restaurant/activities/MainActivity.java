package xyz.imei.restaurant.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.mmtextview.MMFontUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.imei.restaurant.R;
import xyz.imei.restaurant.adapters.MealsAdapter;
import xyz.imei.restaurant.data.models.ASTLModel;
import xyz.imei.restaurant.delegates.MealDelegate;
import xyz.imei.restaurant.events.ApiErrorEvent;
import xyz.imei.restaurant.events.GetWarDeeEmptyEvent;
import xyz.imei.restaurant.events.GetWarDeeSuccessEvent;
import xyz.imei.restaurant.utils.ASTLConstants;

public class MainActivity extends BaseActivity implements MealDelegate {

    @BindView(R.id.rv_meals)
    RecyclerView rvMeals;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    private MealsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        MMFontUtils.initMMTextView(this);

        rvMeals.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        adapter = new MealsAdapter(this);
        rvMeals.setAdapter(adapter);

        swipeRefreshLayout.setRefreshing(true);

        ASTLModel.getmInstance().loadWarDees(ASTLConstants.ACCESS_TOKEN);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                ASTLModel.getmInstance().loadWarDees(ASTLConstants.ACCESS_TOKEN);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClickMeal() {
        Intent intent = new Intent(getApplicationContext(), MealDetailsActivity.class);
        startActivity(intent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSuccessGetWarDee(GetWarDeeSuccessEvent event) {
        adapter.setWarDees(event.getWarDeeVOList());
        swipeRefreshLayout.setRefreshing(false);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEmptyGetWarDee(GetWarDeeEmptyEvent event) {
        Toast.makeText(getApplicationContext(), event.getMessage() , Toast.LENGTH_SHORT).show();
        swipeRefreshLayout.setRefreshing(false);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFailGetWarDee(ApiErrorEvent event) {
        Toast.makeText(getApplicationContext(), event.getErrMessage() , Toast.LENGTH_SHORT).show();
        swipeRefreshLayout.setRefreshing(false);
    }
}
