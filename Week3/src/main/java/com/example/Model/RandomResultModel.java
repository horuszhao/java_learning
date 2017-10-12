package com.example.Model;

import java.util.Date;

/**
 * Created by Beyondhost on 10/10/2017.
 */
public class RandomResultModel {
    private long startDate;
    private long endDate;
    private long elapse;
    private int[] randomArray;

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public int[] getRandomArray() {
        return randomArray;
    }

    public void setRandomArray(int[] randomArray) {
        this.randomArray = randomArray;
    }

    public long getElapse() {
        return elapse;
    }

    public void setElapse(long elapse) {
        this.elapse = elapse;
    }
}
