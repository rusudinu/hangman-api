package com.hangman.api.mapper;

import com.hangman.api.dto.GameInstanceDTO;
import com.hangman.api.model.GameInstance;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GameInstanceMapper {
    GameInstanceDTO toGameInstanceDto(GameInstance gameInstance);
}
