package com.fwdrobo.roombooking.api;

public record ApiError(
        int status,
        String error,
        String code,
        String message,
        String path
) {
}
