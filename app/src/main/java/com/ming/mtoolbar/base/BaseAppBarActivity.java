package com.ming.mtoolbar.base;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ming.mtoolbar.R;
import com.ming.mtoolbar.utils.DensityUtil;
import com.ming.mtoolbar.utils.TypeUtil;

/**
 * 封装toolbar 策略2 正在调整
 */
public abstract class BaseAppBarActivity extends AppCompatActivity {

    protected void initAppBar() {
        initAppBar(true, false, -1, -1);
    }

    protected void initAppBar(boolean isBack) {
        initAppBar(isBack, false, -1, -1);
    }

    protected void initAppBar(boolean isBack, boolean isRightText) {
        initAppBar(isBack, isRightText, -1, -1);
    }

    protected void initAppBar(boolean isBack, boolean isRightText, @ColorRes int bgColor, @ColorRes int textColor) {
        //动态添加appbar
//        ViewGroup view = getWindow().getDecorView().findViewById(android.R.id.content);
//        ViewGroup inflate = (ViewGroup) view.getChildAt(0);
//        View barView = getLayoutInflater().inflate(R.layout.common_appbar, null);
//        inflate.addView(barView,0);

        getSupportActionBar().setDisplayShowCustomEnabled(true);
       getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.common_appbar);
        View view=getSupportActionBar().getCustomView();
//        RelativeLayout layout = findViewById(R.id.common_appbar_rl);
//        LinearLayout linearLayout = findViewById(R.id.common_appbar_ll);
//        if (layout == null) {
//            return;
//        }
//        invadeStatusBar();
//        if (bgColor != -1) {
//            linearLayout.setBackgroundResource(bgColor);
//        }
//        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layout.getLayoutParams();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            layoutParams.setMargins(0, getStatusBarHeight(), 0, 0);
//        } else {
//            layoutParams.setMargins(0, 0, 0, 0);
//        }
//        layout.setLayoutParams(layoutParams);
//        ImageView iconIV = findViewById(R.id.common_appbar_iv);
//        if (!isBack) {
//            iconIV.setVisibility(View.GONE);
//        } else {
//            iconIV.setVisibility(View.VISIBLE);
//            iconIV.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    onAppBarBackClick();
//
//                }
//            });
//        }
//        TextView centerTV = findViewById(R.id.common_appbar_center_tv);
//        if (textColor != -1) {
//            centerTV.setTextColor(getResources().getColor(textColor));
//        }
//        centerTV.setText(TypeUtil.isBlank(setAppBarTitle()) ? "" : setAppBarTitle());
//        TextView rightTV = findViewById(R.id.common_appbar_right_tv);
//        if (!isRightText) {
//            rightTV.setVisibility(View.GONE);
//        } else {
//            rightTV.setVisibility(View.VISIBLE);
//            if (textColor != -1) {
//                centerTV.setTextColor(getResources().getColor(textColor));
//            }
//            rightTV.setText(TypeUtil.isBlank(setAppBarRightTitle()) ? "" : setAppBarRightTitle());
//            rightTV.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    onAppBarRightClick();
//                }
//            });
//        }
    }


    protected abstract String setAppBarTitle();

    protected abstract String setAppBarRightTitle();

    protected abstract void onAppBarBackClick();

    protected abstract void onAppBarRightClick();

    protected abstract int getContentView();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        initWidget();
        initData();
    }

    protected void initWidget() {}

    protected void initData() {}

    protected void invadeStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    protected int getStatusBarHeight() {
        Resources resources = getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        int height = resources.getDimensionPixelSize(resourceId);
        Log.i("theHeight", height + "");
        if (height <= 10) {
            height = DensityUtil.dp2px(this, 16);
        }
        return height;
    }
}

