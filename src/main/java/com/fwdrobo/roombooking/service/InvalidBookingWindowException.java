package com.fwdrobo.roombooking.service;

import com.fwdrobo.roombooking.domain.BookingWindowResult;

public class InvalidBookingWindowException extends RuntimeException {

    public InvalidBookingWindowException(BookingWindowResult result) {
        super("Booking window is invalid: " + result.name());
    }
}
