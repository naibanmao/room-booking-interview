package com.fwdrobo.roombooking.domain;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class BookingWindowPolicy {

    public BookingWindowResult evaluate(LocalDateTime start, LocalDateTime end) {
        throw new UnsupportedOperationException("Booking window policy is not implemented");
    }
}
