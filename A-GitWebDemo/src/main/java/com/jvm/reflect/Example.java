package com.jvm.reflect;

public class Example {

    private String mFiledOne = null;
    private int mCount = 0;
    private double mNum = 6;

    public int mPub = 4;

    public Example() {
    }

    public Example(String filedOne, int count, double num) {
        super();
        this.mFiledOne = filedOne;
        this.mCount = count;
        this.mNum = num;
    }

    public String getFiledOne() {
        return mFiledOne;
    }

    public void setFiledOne(String filedOne) {
        this.mFiledOne = filedOne;
    }

    public int getCount() {
        return mCount;
    }

    public void setCount(int count) {
        this.mCount = count;
    }

    public double getNum() {
        return mNum;
    }

    public void setNum(double num) {
        this.mNum = num;
    }

    public static void printSomething(String line) {
        System.out.println(line);
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static double getPi() {
        return 3.14159d;
    }

    @Override
    public String toString() {
        return "Example [mFiledOne=" + mFiledOne + ", mCount=" + mCount + "]";
    }

    private String tellSecret(String name, int num) {
        String result = name + num + toString();
        return result;
    }

}

