package fr.sorbonne.paris.nord.university.api.factory;

import fr.sorbonne.paris.nord.university.api.dto.PlayerDTO;
import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;
import fr.sorbonne.paris.nord.university.api.entity.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerFactory implements EntityFactory<Player, PlayerDTO>{
    @Override
    public Player toEntity(PlayerDTO dto) {
        final Player player = new Player();
        player.setId(dto.getId());
        player.setName(dto.getName());
        player.setNumber(dto.getNumber());
        player.setPosition(dto.getPosition());
        return player;
    }

    public static PlayerDTO getPlayerDTO (Player entity)
    {
        final PlayerDTO dto = new PlayerDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setNumber((entity.getNumber()));
        dto.setPosition((entity.getPosition()));
        return dto;
    }

    @Override
    public PlayerDTO toDto(Player entity) {
        final PlayerDTO dto = getPlayerDTO(entity);
        dto.setTeam(TeamFactory.getTeamDTO(entity.getTeam()));
        return dto;
    }
}
