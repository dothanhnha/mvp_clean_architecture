package com.example.mvp_dagger_rxjava.exception;

import androidx.annotation.Nullable;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.HttpException;

public class APIError extends Throwable {

    public static final String ERROR_UNKNOWN = "오류가 발생하였습니다. 다시 한번 시도해 주세요";
    public static final int CODE_UNKNOWN = -99;

    private final String message;
    private final int code;

    public APIError(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public boolean isCodeUnknown() {
        return code == CODE_UNKNOWN;
    }

    public static APIError from(@Nullable Throwable throwable) {
        try {
            if (throwable != null) {
                if (throwable instanceof HttpException) {
                    HttpException errorException = (HttpException) throwable;
                    if (errorException.response() != null) {
                        ResponseBody errorBody = errorException.response().errorBody();
                        if (errorBody != null) {
                            return APIError.from(errorBody);
                        }
                    }
                    int http_status = errorException.code();
                    String http_error = errorException.message();
                    return new APIError(http_error, http_status);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new APIError(ERROR_UNKNOWN, CODE_UNKNOWN);
    }

    public static APIError from(@Nullable ResponseBody errorBody) {
        try {
            if(errorBody != null) {
                JSONObject joError = new JSONObject(errorBody.string());
                String msg = joError.optString("message", "");
                int code = joError.optInt("errorCode", -1);
                return new APIError(msg, code);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new APIError(ERROR_UNKNOWN, CODE_UNKNOWN);
    }
}
