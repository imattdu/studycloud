package com.matt.springcloud.service;

import com.matt.springcloud.entities.CommonResult;
import com.matt.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author matt
 * @create 2021-05-12 11:30
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable(value = "id") Long id);


    @GetMapping(value = "/payment/feign/timeout")
    public String getPaymentFeignTimeout();
}
