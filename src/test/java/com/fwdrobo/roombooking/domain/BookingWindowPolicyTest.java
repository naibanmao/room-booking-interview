package com.fwdrobo.roombooking.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BookingWindowPolicyTest {
    public final BookingWindowPolicy policy = new BookingWindowPolicy();

    @Test
    void NoStart() {
        assertEquals(
                BookingWindowResult.MISSING_BOUNDARY,
                policy.evaluate(
                        null,
                        LocalDateTime.of(2026,9,3,11,30)
                        )
        );
    }
    @Test
    void NoEnd() {
        assertEquals(
                BookingWindowResult.MISSING_BOUNDARY,
                policy.evaluate(
                        LocalDateTime.of(2026,9,3,11,30),
                        null
                )
        );
    }
    @Test
    void NoStartAndEnd() {
        assertEquals(
                BookingWindowResult.MISSING_BOUNDARY,
                policy.evaluate(
                        null,
                        null
                )
        );
    }
    @Test
    void StartAfterEnd() {
        assertEquals(
                BookingWindowResult.END_NOT_AFTER_START,
                policy.evaluate(
                        LocalDateTime.of(2026,9,3,11,30),
                        LocalDateTime.of(2026,9,3,11,0)
                )
        );
    }
    @Test
    void StartEqualEnd() {
        assertEquals(
                BookingWindowResult.END_NOT_AFTER_START,
                policy.evaluate(
                        LocalDateTime.of(2026,9,3,11,30),
                        LocalDateTime.of(2026,9,3,11,30)
                )
        );
    }

    @Test
    void NoOutTwentyMin() {
        assertEquals(
                BookingWindowResult.DURATION_OUT_OF_RANGE,
                policy.evaluate(
                        LocalDateTime.of(2026,9,3,11,30),
                        LocalDateTime.of(2026,9,3,11,59)
                )
        );
    }
    @Test
    void OutTwoHour() {
        assertEquals(
                BookingWindowResult.DURATION_OUT_OF_RANGE,
                policy.evaluate(
                        LocalDateTime.of(2026,9,3,11,30),
                        LocalDateTime.of(2026,9,3,13,31)
                )
        );
    }

    @Test
    void TwoHour() {
        assertEquals(
                BookingWindowResult.VALID,
                policy.evaluate(
                        LocalDateTime.of(2026,9,3,11,30),
                        LocalDateTime.of(2026,9,3,13,30)
                )
        );
    }
    @Test
    void TwentyMin() {
        assertEquals(
                BookingWindowResult.VALID,
                policy.evaluate(
                        LocalDateTime.of(2026,9,3,11,30),
                        LocalDateTime.of(2026,9,3,12,0)
                )
        );
    }

    @Test
    void TwentyOneMin() {
        assertEquals(
                BookingWindowResult.VALID,
                policy.evaluate(
                        LocalDateTime.of(2026,9,3,11,30),
                        LocalDateTime.of(2026,9,3,12,1)
                )
        );
    }



}