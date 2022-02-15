package fr.sorbonne.paris.nord.university.api.service;

import fr.sorbonne.paris.nord.university.api.dto.PlayerDTO;
import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;

import java.util.List;
import java.util.Optional;

public interface PlayerService {

    List<PlayerDTO> getAllPlayers();
    Optional<PlayerDTO> getPlayerById(long id);
    void addPlayer(PlayerDTO player);
    void updatePlayer(PlayerDTO player);
    void deletePlayerById(long id);

}
