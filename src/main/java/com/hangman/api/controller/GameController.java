package com.hangman.api.controller;

import com.hangman.api.dto.GameInstanceDTO;
import com.hangman.api.model.GuessRequest;
import com.hangman.api.model.GuessResponse;
import com.hangman.api.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/game")
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;

    @PostMapping("{roomId}")
    public GuessResponse guess(@RequestBody GuessRequest guessRequest, @PathVariable String roomId) {
        return gameService.guess(guessRequest, roomId);
    }

    @GetMapping("{roomId}")
    public GameInstanceDTO getGame(@PathVariable String roomId) {
        return gameService.findById(roomId);
    }
}
