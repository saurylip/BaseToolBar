package com.ming.mtoolbar.utils;

import android.text.TextUtils;

public class TypeUtil {

    public static boolean isInt(double d) {
        if (((int) d) == d) {
            return true;
        }
        return false;
    }

    public static boolean isInt(float f) {
        if (((int) f) == f) {
            return true;
        }
        return false;
    }
    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public static boolean isFloat(String s) {
        try {
            Float.parseFloat(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public static String bytes2Hex(byte[] resultBytes) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < resultBytes.length; i++) {
            if (Integer.toHexString(0xFF & resultBytes[i]).length() == 1) {
                builder.append("0").append(
                        Integer.toHexString(0xFF & resultBytes[i]));
            } else {
                builder.append(Integer.toHexString(0xFF & resultBytes[i]));
            }
        }
        return builder.toString();
    }
    public static boolean isBlank(String s) {
        return s == null || TextUtils.isEmpty(s.trim());
    }


}
