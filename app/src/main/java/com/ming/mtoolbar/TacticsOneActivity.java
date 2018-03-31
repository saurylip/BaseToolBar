package com.ming.mtoolbar;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.RadioGroup;

import com.ming.mtoolbar.base.BaseToolBarActivity;
import com.ming.mtoolbar.utils.ToastUtil;
import butterknife.OnClick;

/**
 * 策略1
 * Created by mrming on 2018/3/31.
 */

public class TacticsOneActivity extends BaseToolBarActivity {

    public static void start(Context context, String id) {
        Intent starter = new Intent(context, TacticsOneActivity.class);
        starter.putExtra("id", id);
        context.startActivity(starter);
    }

    @Override
    protected View getContentView() {
        return initRId(R.layout.activity_tactiesone);
    }

    @Override
    protected void initWidget() {

    }

    @OnClick({R.id.tv_styleone, R.id.tv_styletwo, R.id.tv_stylethree,R.id.tv_stylefour})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_styleone:
                setTitle("Tactics1");
                break;
            case R.id.tv_styletwo:
                setRightTextButtonEnable("更多", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.showToast("更多");
                    }
                });
                break;
            case R.id.tv_stylethree:
                setRightImageButtonEnable(R.mipmap.add_white, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.showToast("add");
                    }
                });
                break;
            case R.id.tv_stylefour:
                setCenterRadioGroupEnable("进行中", "已结束", new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        ToastUtil.showToast(group.toString());
                    }
                });
                break;
        }
    }
}
