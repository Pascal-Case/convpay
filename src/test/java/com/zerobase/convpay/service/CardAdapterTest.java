package com.zerobase.convpay.service;

import com.zerobase.convpay.type.CardUseCancelResult;
import com.zerobase.convpay.type.CardUseResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CardAdapterTest {

    private final CardAdapter cardAdapter = new CardAdapter();

    @Test
    void capture_success() {
        //given
        Integer payAmount = 99;
        //when
        CardUseResult cardUseResult = cardAdapter.capture(payAmount);
        //then
        Assertions.assertEquals(CardUseResult.USE_SUCCESS, cardUseResult);
    }

    @Test
    void capture_fail() {
        //given
        Integer payAmount = 101;
        //when
        CardUseResult cardUseResult = cardAdapter.capture(payAmount);
        //then
        Assertions.assertEquals(CardUseResult.USE_FAIL, cardUseResult);
    }

    @Test
    void capture_cancel_success() {
        //given
        Integer cancelAmount = 1001;
        //when
        CardUseCancelResult cardUseCancelResult = cardAdapter.cancelCapture(cancelAmount);
        //then
        Assertions.assertEquals(CardUseCancelResult.CANCEL_SUCCESS, cardUseCancelResult);
    }

    @Test
    void capture_cancel_fail() {
        //given
        Integer cancelAmount = 999;
        //when
        CardUseCancelResult cardUseCancelResult = cardAdapter.cancelCapture(cancelAmount);
        //then
        Assertions.assertEquals(CardUseCancelResult.CANCEL_FAIL, cardUseCancelResult);
    }

}