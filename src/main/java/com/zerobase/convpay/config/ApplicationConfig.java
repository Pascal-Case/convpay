package com.zerobase.convpay.config;

import com.zerobase.convpay.service.CardAdapter;
import com.zerobase.convpay.service.ConveniencePayService;
import com.zerobase.convpay.service.DiscountByConvenience;
import com.zerobase.convpay.service.MoneyAdapter;
import java.util.Arrays;
import java.util.HashSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public ConveniencePayService conveniencePayService() {
        return new ConveniencePayService(
                new HashSet<>(
                        Arrays.asList(moneyAdapter(), cardAdapter())
                ),
                discountInterface()
        );
    }

    @Bean
    public static CardAdapter cardAdapter() {
        return new CardAdapter();
    }

    @Bean
    public static MoneyAdapter moneyAdapter() {
        return new MoneyAdapter();
    }

    @Bean
    public static DiscountByConvenience discountInterface() {
        return new DiscountByConvenience();
    }
}
