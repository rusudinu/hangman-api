package com.hangman.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameInstance {
    private String id;
    private Long allowedGuesses;
    private Long leftGuesses;
    private String word;
    private String guessedWord; // original: "ANA" -> "___"
}
