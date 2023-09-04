package com.hangman.api.service;

import com.hangman.api.dto.GameInstanceDTO;
import com.hangman.api.helper.InMemoryGame;
import com.hangman.api.mapper.GameInstanceMapper;
import com.hangman.api.model.GameInstance;
import com.hangman.api.model.GuessRequest;
import com.hangman.api.model.GuessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameInstanceMapper gameInstanceMapper;

    public GameInstanceDTO findById(String roomId) {
        GameInstance gameInstance = InMemoryGame.findById(roomId);
        return gameInstanceMapper.toGameInstanceDto(gameInstance);
    }

    public GuessResponse guess(GuessRequest guessRequest, String roomId) {
        GameInstance gameInstance = InMemoryGame.findById(roomId);
        return gameInstance.makeGuess(guessRequest);
    }
}
