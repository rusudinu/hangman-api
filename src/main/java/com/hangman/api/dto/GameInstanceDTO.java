package com.hangman.api.dto;

import lombok.Data;

@Data
public class GameInstanceDTO {
    private Long allowedGuesses;
    private Long madeGuesses;
    private String word;
    private String guessedWord; // original: "ANA" -> "___"
}
