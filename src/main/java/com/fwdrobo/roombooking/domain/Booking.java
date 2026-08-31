package com.fwdrobo.roombooking.domain;

import java.time.LocalDateTime;

public record Booking(
        String id,
        String roomId,
        LocalDateTime start,
        LocalDateTime end
) {
}
