package com.fwdrobo.roombooking.repository;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import com.fwdrobo.roombooking.domain.Room;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryRoomRepository {

    private final Map<String, Room> rooms = new LinkedHashMap<>();

    public InMemoryRoomRepository() {
        rooms.put("room-101", new Room("room-101", "Quiet Room"));
        rooms.put("room-202", new Room("room-202", "Focus Room"));
    }

    public Optional<Room> findById(String roomId) {
        return Optional.ofNullable(rooms.get(roomId));
    }
}
