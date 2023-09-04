package com.hangman.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GuessResponse {
    private Boolean correctGuessed;
    private Boolean gameEnded;
    private Long guessesLeft;
}
