package com.matt.springcloud.service.impl;

import com.matt.springcloud.dao.PaymentDao;
import com.matt.springcloud.entities.Payment;
import com.matt.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author matt
 * @create 2021-05-07 17:45
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    // @Resouce:java自带
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public Integer create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
