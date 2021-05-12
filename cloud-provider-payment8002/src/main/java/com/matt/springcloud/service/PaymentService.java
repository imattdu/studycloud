package com.matt.springcloud.service;

import com.matt.springcloud.entities.Payment;

/**
 * @author matt
 * @create 2021-05-07 17:44
 */
public interface PaymentService {

    public Integer create(Payment payment);

    public Payment getPaymentById(Long id);
}
