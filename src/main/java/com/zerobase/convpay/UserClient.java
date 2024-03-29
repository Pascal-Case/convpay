package com.zerobase.convpay;

import com.zerobase.convpay.config.ApplicationConfig;
import com.zerobase.convpay.dto.PayCancelRequest;
import com.zerobase.convpay.dto.PayCancelResponse;
import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.service.ConveniencePayService;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserClient {
    public static void main(String[] args) {
        // '사용자' -> 편결이 -> 머니
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                ApplicationConfig.class);
        ConveniencePayService conveniencePayService = applicationContext.getBean(
                "conveniencePayService", ConveniencePayService.class);

        // SEVEN 결제 1000원
        PayRequest payRequest = new PayRequest(PayMethodType.CARD,
                ConvenienceType.SEVEN, 50);
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        System.out.println(payResponse);

        System.out.println("-----------------");

        PayCancelRequest payCancelRequest = new PayCancelRequest(
                PayMethodType.MONEY, ConvenienceType.SEVEN, 500);
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(
                payCancelRequest);

        System.out.println(payCancelResponse);

        // SEVEN 취소 500원

    }
}
