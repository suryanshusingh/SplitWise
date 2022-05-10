package com.splitwise.util;

public class Util {
    public static boolean isApproxEqual(double a, double b) {
        return (long)(a*100) == (long)(b*100);
    }
}
