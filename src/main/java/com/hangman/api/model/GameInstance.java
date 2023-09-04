package com.hangman.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameInstance {
    private String id;
    private Long allowedGuesses;
    private Long madeGuesses;
    private String word;
    private String guessedWord; // original: "ANA" -> "___"

    public GuessResponse makeGuess(GuessRequest guessRequest) {
        String letter = guessRequest.getLetter();
        if (guessedWord.contains(letter)) {
            madeGuesses++;
            return new GuessResponse(false, checkGameEnd(), allowedGuesses - madeGuesses);
        }

        String wordCopy = String.valueOf(word);
        if (!wordCopy.contains(letter)) {
            madeGuesses++;
            return new GuessResponse(false, checkGameEnd(), allowedGuesses - madeGuesses);
        }

        while (wordCopy.contains(letter)) {
            int index = wordCopy.indexOf(letter);
            wordCopy = wordCopy.replaceFirst(letter, "_");
            guessedWord = guessedWord.substring(0, index) + letter + guessedWord.substring(index + 1);
        }
        return new GuessResponse(true, checkGameEnd(), allowedGuesses - madeGuesses);
    }

    public boolean checkGameEnd() {
        if (madeGuesses > allowedGuesses)
            return false;
        return word.equals(guessedWord);
    }
}
