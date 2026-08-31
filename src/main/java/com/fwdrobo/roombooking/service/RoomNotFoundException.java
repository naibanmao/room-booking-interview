package com.fwdrobo.roombooking.service;

public class RoomNotFoundException extends RuntimeException {

    public RoomNotFoundException(String roomId) {
        super("Room " + roomId + " was not found");
    }
}
