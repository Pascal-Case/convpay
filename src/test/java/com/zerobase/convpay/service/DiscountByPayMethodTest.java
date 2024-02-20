package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DiscountByPayMethodTest {
    DiscountByPayMethod discountByPayMethod = new DiscountByPayMethod();

    @Test
    void discountTest() {
        PayRequest payRequestMoney = new PayRequest(PayMethodType.MONEY,
                ConvenienceType.GS25, 1000);
        PayRequest payRequestCard = new PayRequest(PayMethodType.CARD,
                ConvenienceType.GS25, 1000);

        Integer discountedAmountMoney =
                discountByPayMethod.getDiscountedAmount(payRequestMoney);
        Integer discountedAmountCard =
                discountByPayMethod.getDiscountedAmount(payRequestCard);

        Assertions.assertEquals(700, discountedAmountMoney);
        Assertions.assertEquals(1000, discountedAmountCard);

    }
}