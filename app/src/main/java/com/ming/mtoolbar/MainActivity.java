package com.ming.mtoolbar;

import android.view.View;
import com.ming.mtoolbar.base.BaseToolBarActivity;
import butterknife.OnClick;

public class MainActivity extends BaseToolBarActivity {

    @Override
    protected View getContentView() {
        return initRId(R.layout.activity_main);
    }

    @Override
    protected void initWidget() {
        setBackEnable(false);
        setTitle("封装ToolBar");
    }

    @OnClick({R.id.btn_tactics_one, R.id.btn_tactics_two})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_tactics_one:
                TacticsOneActivity.start(this,"1");
                break;
            case R.id.btn_tactics_two:
                TacticsTwoActivity.start(this,"2");
                break;
        }
    }
}
