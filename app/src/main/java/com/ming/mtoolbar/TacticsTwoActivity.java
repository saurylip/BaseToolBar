package com.ming.mtoolbar;

import android.content.Context;
import android.content.Intent;
import com.ming.mtoolbar.base.BaseAppBarActivity;
import com.ming.mtoolbar.utils.ToastUtil;

/**
 * 策略2
 * Created by mrming on 2018/3/31.
 */

public class TacticsTwoActivity extends BaseAppBarActivity {

    public static void start(Context context, String id) {
        Intent starter = new Intent(context, TacticsTwoActivity.class);
        starter.putExtra("id", id);
        context.startActivity(starter);
    }

    @Override
    protected String setAppBarTitle() {
        return "Tactics2";
    }

    @Override
    protected String setAppBarRightTitle() {
        return "更多";
    }

    @Override
    protected void onAppBarRightClick() {
        ToastUtil.showToast("更多");
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_tactiestwo;
    }

    @Override
    protected void initWidget() {
        //一定要放在setContentView之后(里面空间获取需要先加载layout resource)
        initAppBar(true,true);
    }
}