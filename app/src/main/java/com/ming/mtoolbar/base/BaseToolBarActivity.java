package com.ming.mtoolbar.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.ming.mtoolbar.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 带toolbar 的activity 策略1
 * Created by mrming on 2018/3/31.
 */

public abstract class BaseToolBarActivity extends AppCompatActivity {

    FrameLayout mContent_frame;
    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindView(R.id.toolbar_tv_title) TextView mToolbar_tv_title;
    @BindView(R.id.tv_title_right) TextView mTv_title_right;
    @BindView(R.id.iv_title_right) ImageView mIv_title_right;
    @BindView(R.id.toolbar_rg) RadioGroup mRadioGroup;
    @BindView(R.id.toolbar_rb_left) RadioButton mRadioBtnLeft;
    @BindView(R.id.toolbar_rb_right) RadioButton mRadioBtnRight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = LayoutInflater.from(this).inflate(R.layout.layout_toolbar, (ViewGroup) getWindow().getDecorView().getRootView(), false);
        mContent_frame = view.findViewById(R.id.content_frame);
        if(getContentView() != null){
            mContent_frame.addView(getContentView());
        }
        setContentView(view);

        ButterKnife.bind(this);
        steepTitle();
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle(getTitle());

        initWidget();
        initData();
    }

    protected abstract View getContentView();

    protected View initRId(@LayoutRes int rid) {
        return LayoutInflater.from(this).inflate(rid, mContent_frame, false);
    }

    protected void initWidget() {}

    protected void initData() {}


    //默认的返回按钮
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    //bar 中间标题
    @Override
    public void setTitle(CharSequence title) {
        mToolbar_tv_title.setText(title);
        mRadioGroup.setVisibility(View.GONE);
    }

    @Override
    public void setTitle(@StringRes int titleId) {
        mToolbar_tv_title.setText(titleId);
    }

    protected void setBackEnable(boolean isEnable){
        getSupportActionBar().setDisplayHomeAsUpEnabled(isEnable);
        getSupportActionBar().setDisplayShowHomeEnabled(isEnable);
    }

    //bar右侧是文字
    protected void setRightTextButtonEnable(@StringRes int rid, View.OnClickListener onClickListener) {
        mTv_title_right.setText(rid);
        mTv_title_right.setOnClickListener(onClickListener);
        mTv_title_right.setVisibility(View.VISIBLE);
    }

    protected void setRightTextButtonEnable(String rid, View.OnClickListener onClickListener) {
        mTv_title_right.setText(rid);
        mTv_title_right.setOnClickListener(onClickListener);
        mTv_title_right.setVisibility(View.VISIBLE);
        mIv_title_right.setVisibility(View.GONE);
    }

    //bar右侧是图标
    protected void setRightImageButtonEnable(@DrawableRes int rid, View.OnClickListener onClickListener) {
        mIv_title_right.setImageResource(rid);
        mIv_title_right.setOnClickListener(onClickListener);
        mIv_title_right.setVisibility(View.VISIBLE);
        mTv_title_right.setVisibility(View.GONE);

    }

    //bar中间是多按钮
    protected void setCenterRadioGroupEnable(String btnLefttext,String btnRighttext, RadioGroup.OnCheckedChangeListener onClickListener) {
        mRadioBtnLeft.setText(btnLefttext);
        mRadioBtnRight.setText(btnRighttext);
        mRadioGroup.setOnCheckedChangeListener(onClickListener);
        mRadioGroup.setVisibility(View.VISIBLE);
        mToolbar_tv_title.setVisibility(View.GONE);
    }

    //加载沉浸式状态栏
    public void steepTitle() {
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //注意要清除 FLAG_TRANSLUCENT_STATUS flag
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.maincolor));
        }
    }
}
