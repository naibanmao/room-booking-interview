package com.fwdrobo.roombooking.service;

public class BookingNotFoundException extends RuntimeException {

    public BookingNotFoundException(String roomId, String bookingId) {
        super("Booking " + bookingId + " was not found in room " + roomId);
    }
}
