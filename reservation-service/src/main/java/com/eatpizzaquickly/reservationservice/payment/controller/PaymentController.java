package com.eatpizzaquickly.reservationservice.payment.controller;

import com.eatpizzaquickly.reservationservice.common.advice.ApiResponse;
import com.eatpizzaquickly.reservationservice.common.enums.PayStatus;
import com.eatpizzaquickly.reservationservice.common.enums.SettlementStatus;
import com.eatpizzaquickly.reservationservice.payment.dto.request.PaymentCancelRequest;
import com.eatpizzaquickly.reservationservice.payment.dto.request.PaymentRequestDto;
import com.eatpizzaquickly.reservationservice.payment.dto.request.PostPaymentRequest;
import com.eatpizzaquickly.reservationservice.payment.dto.response.GetPaymentResponse;
import com.eatpizzaquickly.reservationservice.payment.dto.response.PaymentResponseDto;
import com.eatpizzaquickly.reservationservice.payment.dto.response.PaymentResponses;
import com.eatpizzaquickly.reservationservice.payment.dto.response.PaymentSimpleResponse;
import com.eatpizzaquickly.reservationservice.payment.exception.PaymentCancelException;
import com.eatpizzaquickly.reservationservice.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
@Slf4j
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/toss")
    public ResponseEntity<PaymentResponses> requestPayment(
            @RequestBody PostPaymentRequest request,
            @RequestParam(name = "couponId", required = false) Long couponId
    ) {
        PaymentResponses paymentResponse = paymentService.requestTossPayment(request, couponId);
        return ResponseEntity.ok(paymentResponse);
    }

    @GetMapping("/toss/success")
    public ResponseEntity<String> handlePaymentSuccess(
            @RequestParam(name = "orderId") String orderId,
            @RequestParam(name = "paymentKey") String paymentKey,
            @RequestParam(name = "amount") Long amount,
            RedirectAttributes redirectAttributes
    ) {
            System.out.println("orderId: " + orderId);
            System.out.println("paymentKey: " + paymentKey);
            System.out.println("amount: " + amount);
            paymentService.TossPaymentSuccess(paymentKey, orderId, amount);
            return ResponseEntity.status(HttpStatus.OK)
                    .header(HttpHeaders.LOCATION, "/payment/success")
                    .build();
    }
    /* 결제 실패 처리 */
    @GetMapping("/toss/fail")
    public ResponseEntity<GetPaymentResponse> tossPaymentFail(
            @RequestParam String code,
            @RequestParam String message,
            @RequestParam String orderId
    ) {
        return ResponseEntity.ok(paymentService.tossPaymentFail(code, message, orderId));
    }

    @PostMapping("/{paymentKey}/cancel")
    public ResponseEntity<GetPaymentResponse> cancelPayment(
            @PathVariable String paymentKey,
            @RequestBody PaymentCancelRequest request
    ) {
        try {
            GetPaymentResponse response = paymentService.cancelPayment(paymentKey, request.getCancelReason());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw new PaymentCancelException("결제 취소 처리 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    @GetMapping
    public List<PaymentResponseDto> getPaymentsByStatusAfterId(
            @RequestParam(name = "settlementStatus") SettlementStatus settlementStatus,
            @RequestParam(name = "payStatus") PayStatus payStatus,
            @RequestParam(name = "size") int chunk,
            @RequestParam(name = "offset") Long currentOffset
    ) {
        return paymentService.getPaymentsByStatusAfterId(settlementStatus, payStatus, chunk, currentOffset);
    }

    @PutMapping
    public ResponseEntity<String> updatePayments(@RequestBody List<PaymentRequestDto> payments) {
        paymentService.updatePayments(payments);
        return ResponseEntity.ok().body("update successfully");
    }

    @GetMapping("/my-payment")
    public ResponseEntity<ApiResponse<Page<PaymentSimpleResponse>>> getPayments(
            @RequestHeader("X-Authenticated-User") Long userId,
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "size", defaultValue = "5") int size
    ) {

        return ResponseEntity.ok(ApiResponse.success("결제 내역 조회 성공", paymentService.getPayments(userId, page, size)));
    }

}
