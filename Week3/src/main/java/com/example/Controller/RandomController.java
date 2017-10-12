package com.example.Controller;

import com.example.Model.RandomResultModel;
import com.example.Service.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Beyondhost on 10/10/2017.
 */
@RestController
@RequestMapping("/random")
public class RandomController {

    @Autowired
    private RandomService randomService;

    @RequestMapping(value = "/get",method = RequestMethod.GET )
    public RandomResultModel getRandomData()
    {
        RandomResultModel resultModel = randomService.getRandomArray();
        return resultModel;
    }

}
