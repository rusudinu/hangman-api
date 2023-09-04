package com.hangman.api.helper;

import com.hangman.api.model.CreateRoom;
import com.hangman.api.model.GameInstance;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class InMemoryGame {
    public static List<GameInstance> games = new ArrayList<>();

    public static GameInstance findById(String id) {
        Optional<GameInstance> gameInstanceOptional =
                games.stream()
                .filter(g -> g.getId().equals(id))
                .findFirst();

        return gameInstanceOptional.orElse(null);
    }

    public static GameInstance saveGameInstance(CreateRoom createRoom) {
        GameInstance gameInstance = new GameInstance(String.valueOf(games.size()),
                createRoom.getAllowedGuesses(),
                0L,
                createRoom.getWord(),
                "_".repeat(createRoom.getWord().length()));
        games.add(gameInstance);
        return gameInstance;
    }
}
