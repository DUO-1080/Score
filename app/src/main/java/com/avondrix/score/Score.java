package com.avondrix.score;

public class Score {
    private int a;
    private int b;

    public Score(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Score{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
