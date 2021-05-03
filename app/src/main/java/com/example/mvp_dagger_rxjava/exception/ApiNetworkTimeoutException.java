package com.example.mvp_dagger_rxjava.exception;

public class ApiNetworkTimeoutException extends ApiNetworkException {

    public ApiNetworkTimeoutException(Throwable cause) {
        super(cause);
    }
}
