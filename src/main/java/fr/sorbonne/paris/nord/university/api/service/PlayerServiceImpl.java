package fr.sorbonne.paris.nord.university.api.service;

import fr.sorbonne.paris.nord.university.api.dto.PlayerDTO;
import fr.sorbonne.paris.nord.university.api.factory.PlayerFactory;
import fr.sorbonne.paris.nord.university.api.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService{
    @Autowired
    private PlayerFactory playerFactory;

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<PlayerDTO> getAllPlayers() {
        return playerRepository.findAll().stream().map(playerFactory::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<PlayerDTO> getPlayerById(long id) {
        return Optional.empty();
    }

    @Override
    public void addPlayer(PlayerDTO player) {

    }

    @Override
    public void updatePlayer(PlayerDTO player) {

    }

    @Override
    public void deletePlayerById(long id) {

    }
}
