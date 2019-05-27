package com.util;

public class CheckUtils {
	
	/**
     * ArrayBlockingQueue源代碼解析（base jdk 1.8）
     * @param v the element
     */
    public static void checkNotNull(Object v) {
        if (v == null)
            throw new NullPointerException();
    }
}
