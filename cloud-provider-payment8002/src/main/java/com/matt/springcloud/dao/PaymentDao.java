package com.matt.springcloud.dao;

import com.matt.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @author matt
 * @create 2021-05-07 17:29
 */
@Mapper
public interface PaymentDao {

    public Integer create(Payment payment);

    public Payment getPaymentById(@Param(value = "id") Long id);
}
