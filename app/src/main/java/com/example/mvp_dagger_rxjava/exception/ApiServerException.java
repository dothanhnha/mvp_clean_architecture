package com.example.mvp_dagger_rxjava.exception;

import androidx.annotation.Nullable;

public class ApiServerException extends AbstractAppException {

    private APIError serverError = null;

    public ApiServerException(Throwable cause) {
        super(cause);
        this.serverError = APIError.from(cause);
    }

    @Nullable
    public APIError getServerError() {
        return serverError;
    }

    @Nullable
    public String getServerErrorMessage() {
        return serverError!= null ? serverError.getMessage() : null;
    }

    public int getServerErrorCode() {
        return serverError!= null ? serverError.getCode() : APIError.CODE_UNKNOWN;
    }
}
