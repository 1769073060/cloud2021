package com.rzk.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rzk.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface PaymentDao extends BaseMapper<Payment> {
    int create(Payment payment);


    Payment getPaymentById(@Param("id") Long id);
}
