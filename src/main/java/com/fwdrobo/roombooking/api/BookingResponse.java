package com.fwdrobo.roombooking.api;

import java.time.LocalDateTime;

import com.fwdrobo.roombooking.domain.Booking;

public record BookingResponse(
        String id,
        String roomId,
        LocalDateTime start,
        LocalDateTime end
) {
    public static BookingResponse from(Booking booking) {
        return new BookingResponse(
                booking.id(),
                booking.roomId(),
                booking.start(),
                booking.end());
    }
}
