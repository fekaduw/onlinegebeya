package com.fekadu.onlinegebeya.service;

import com.fekadu.onlinegebeya.domain.PaymentDetail;
import com.oracle.javafx.jmx.json.JSONException;

public interface PaymentService {

    public PaymentDetail logTransaction(String transactionId, String token, String payerId) throws JSONException, org.json.JSONException;
    public String makePayment(Double amnt, String products);
}
