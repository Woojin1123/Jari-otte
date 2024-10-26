package com.eatpizzaquickly.jariotte.domain.payment.dto.response;

import com.eatpizzaquickly.jariotte.domain.payment.entity.PayMethod;
import com.eatpizzaquickly.jariotte.domain.payment.entity.PayStatus;
import com.eatpizzaquickly.jariotte.domain.payment.entity.Payment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GetPaymentResponse {

    private String payUid;

    private String paymentKey;

    private Long amount;

    private String payInfo;

    private PayMethod payMethod;

    private PayStatus payStatus;

    @JsonIgnore
    private String message;

    @JsonIgnore
    private String code;

    public GetPaymentResponse(Payment payment) {
        this.payUid = payment.getPayUid();
        this.amount = payment.getAmount();
        this.payInfo = payment.getPayInfo();
        this.paymentKey = payment.getPaymentKey();
        this.payMethod = payment.getPayMethod();
        this.payStatus = payment.getPayStatus();
    }

    @Builder
    public GetPaymentResponse(String paymentKey, Long amount, String payInfo, PayMethod payMethod, PayStatus payStatus, String message, String code) {
        this.paymentKey = paymentKey;
        this.amount = amount;
        this.payInfo = payInfo;
        this.payMethod = payMethod;
        this.payStatus = payStatus;
        this.message = message;
        this.code = code;
    }
    // 정적 팩토리 메서드
    public static GetPaymentResponse from(Payment payment) {
        return new GetPaymentResponse(payment);
    }
}
