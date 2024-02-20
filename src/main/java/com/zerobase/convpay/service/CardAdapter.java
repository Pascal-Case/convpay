package com.zerobase.convpay.service;

import com.zerobase.convpay.type.CancelPaymentResult;
import com.zerobase.convpay.type.CardUseCancelResult;
import com.zerobase.convpay.type.CardUseResult;
import com.zerobase.convpay.type.PayMethodType;
import com.zerobase.convpay.type.PaymentResult;

public class CardAdapter implements PaymentInterface {
    // 1. 인증
    public void authorization() {
        System.out.println("CardAdapter.authorization");
    }

    // 2. 승인
    public void approval() {
        System.out.println("CardAdapter.approval");
    }

    // 3. 매입
    public CardUseResult capture(Integer patAmount) {
        System.out.println("CardAdapter.capture : " + patAmount);
        if (patAmount > 100) {
            return CardUseResult.USE_FAIL;
        }
        return CardUseResult.USE_SUCCESS;
    }

    // 4. 매입 취소
    public CardUseCancelResult cancelCapture(Integer cancelAmount) {
        System.out.println("CardAdapter.cancelCapture : " + cancelAmount);
        if (cancelAmount < 1000) {
            return CardUseCancelResult.CANCEL_FAIL;
        }
        return CardUseCancelResult.CANCEL_SUCCESS;
    }

    @Override
    public PayMethodType getPayMethodType() {
        return PayMethodType.CARD;
    }

    @Override
    public PaymentResult payment(Integer payAmount) {
        authorization();
        approval();
        CardUseResult cardUseResult = capture(payAmount);

        if (cardUseResult == CardUseResult.USE_FAIL) {
            return PaymentResult.PAYMENT_FAIL;
        }

        return PaymentResult.PAYMENT_SUCCESS;
    }

    @Override
    public CancelPaymentResult cancelPayment(Integer cancelAmount) {
        CardUseCancelResult cardUseCancelResult = cancelCapture(cancelAmount);
        if (cardUseCancelResult == CardUseCancelResult.CANCEL_FAIL) {
            return CancelPaymentResult.CANCEL_PAYMENT_FAIL;
        }
        return CancelPaymentResult.CANCEL_PAYMENT_SUCCESS;
    }
}
