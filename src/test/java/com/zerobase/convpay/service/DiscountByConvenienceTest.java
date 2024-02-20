package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DiscountByConvenienceTest {
    DiscountByConvenience discountByConvenience = new DiscountByConvenience();

    @Test
    void discountTest() {
        //given
        PayRequest payRequestG25 = new PayRequest(PayMethodType.MONEY, ConvenienceType.GS25, 1000);
        PayRequest payRequestCU = new PayRequest(PayMethodType.MONEY, ConvenienceType.CU, 1000);
        PayRequest payRequestSeven = new PayRequest(PayMethodType.MONEY, ConvenienceType.SEVEN, 1000);
        //when
        Integer discountedAmountG25 = discountByConvenience.getDiscountedAmount(payRequestG25);
        Integer discountedAmountCU = discountByConvenience.getDiscountedAmount(payRequestCU);
        Integer discountedAmountSeven = discountByConvenience.getDiscountedAmount(payRequestSeven);
        //then
        Assertions.assertEquals(800, discountedAmountG25);
        Assertions.assertEquals(900, discountedAmountCU);
        Assertions.assertEquals(1000, discountedAmountSeven);
    }

}