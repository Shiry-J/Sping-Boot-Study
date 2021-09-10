package com.example.utils;

/**
 *  提示语工具类
 */
public class AssertUtil {

    public static void isTrue(boolean flag, Integer code, String message)  {
        if (flag) {
            throw new ParamsException(code, message);
        }
        System.out.println("Method has been used");
    }

}
