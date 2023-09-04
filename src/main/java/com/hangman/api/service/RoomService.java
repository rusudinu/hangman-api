package com.hangman.api.service;

import com.hangman.api.helper.InMemoryGame;
import com.hangman.api.model.CreateRoom;
import com.hangman.api.model.GameInstance;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    public GameInstance createRoom(CreateRoom createRoom) {
        return InMemoryGame.saveGameInstance(createRoom);
    }
}
