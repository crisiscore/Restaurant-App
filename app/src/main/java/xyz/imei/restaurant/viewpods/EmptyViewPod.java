package xyz.imei.restaurant.viewpods;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.imei.restaurant.R;

public class EmptyViewPod extends RelativeLayout {

    @BindView(R.id.iv_empty_image)
    ImageView ivEmpty;
    @BindView(R.id.tv_empty)
    TextView tvEmpty;

    public EmptyViewPod(Context context) {
        super(context);
    }

    public EmptyViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EmptyViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);
    }

    public void setNetworkError() {
        ivEmpty.setImageResource(R.drawable.ic_poor_connection);
        tvEmpty.setText(getResources().getString(R.string.network_error));
    }

    public void setEmptyState() {
        ivEmpty.setImageResource(R.drawable.ic_no_food);
        tvEmpty.setText(getResources().getString(R.string.empty_text));
    }
}
