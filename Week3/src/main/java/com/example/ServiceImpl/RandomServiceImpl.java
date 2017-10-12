package com.example.ServiceImpl;

import com.example.Model.RandomResultModel;
import com.example.Service.RandomService;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by Beyondhost on 10/10/2017.
 */
@Service
public class RandomServiceImpl implements RandomService{

    @Override
    public RandomResultModel getRandomArray() {
        RandomResultModel resultModel = new RandomResultModel();

        long startTime = System.nanoTime();
        int[] randomData = new int[1000];
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            randomData[i] = random.nextInt(9) + i * 10;
        }
        long endTime = System.nanoTime();

        resultModel.setRandomArray(randomData);
        resultModel.setStartDate(startTime);
        resultModel.setEndDate(endTime);
        resultModel.setElapse(endTime-startTime);
        return resultModel;
    }
}
