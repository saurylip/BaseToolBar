package com.ming.mtoolbar.utils;

import android.app.Application;
import android.support.annotation.StringRes;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;

/*
 *Created by Hao on 2016/9/11.
 *单例吐司
*/
public class ToastUtil {
    public static Toast toast;

    public static void showToast(String text) {
        try {
            Application application = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication").invoke(null, (Object[]) null);
            if (toast == null) {
                //如果为空 则创建
                toast = Toast.makeText(application, text, Toast.LENGTH_SHORT);
                toast.show();
            } else {
                //如果吐司不为空 则直接更改吐司的文本
                toast.setText(text);
                //显示 吐司
                toast.show();
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}









