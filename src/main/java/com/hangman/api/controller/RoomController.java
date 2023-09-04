package com.hangman.api.controller;

import com.hangman.api.model.CreateRoom;
import com.hangman.api.model.GameInstance;
import com.hangman.api.service.RoomService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @PostMapping("create")
    public GameInstance createRoom(@RequestBody CreateRoom createRoom) {
        return roomService.createRoom(createRoom);
    }
}
