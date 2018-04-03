# BaseToolBar
ToolBar
掘金文章分析链接：https://juejin.im/post/5abf2615f265da2374111a31

一个小技巧:
* Activity跳转时候,可以这么写,更舒服:
```
    //只需要在目标Activity敲下start 就会出现自带的方法,可以传递一些数据:
    public static void start(Context context, String id) {
        Intent starter = new Intent(context, TacticsOneActivity.class);
        starter.putExtra("id", id);
        context.startActivity(starter);
    }

    //在执行跳转的某按钮处,只需简短一句:
    XxxActivity.start(this,"1");
```
* 同理Fragment:
```
    //只需要在目标Fragment敲下newI :
    public static ChargeRecordFragment newInstance(int type,String coinName,String coinDetailName) {
        Bundle args = new Bundle();
        args.putInt("type",type);
        args.putString("coinName",coinName);
        args.putString("coinDetailName",coinDetailName);
        ChargeRecordFragment fragment = new ChargeRecordFragment();
        fragment.setArguments(args);
        return fragment;
    }
    //Activity的某处拿到实例并传递数据:
    ChargeRecordFragment.newInstance(0,mCoinName,mCoinDetailName);
```