package com.fwdrobo.roombooking.domain;

public enum BookingWindowResult {
    VALID,
    MISSING_BOUNDARY,
    END_NOT_AFTER_START,
    DURATION_OUT_OF_RANGE
}
