package com.matt.springcloud.controller;

import com.matt.springcloud.entities.CommonResult;
import com.matt.springcloud.entities.Payment;
import com.matt.springcloud.service.PaymentFeignService;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author matt
 * @create 2021-05-12 11:35
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }


    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String getPaymentFeignTimeout(){
        // openFeign默认等待1s
        return paymentFeignService.getPaymentFeignTimeout();
    }



}
