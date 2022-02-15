package fr.sorbonne.paris.nord.university.api.factory;

import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;
import fr.sorbonne.paris.nord.university.api.entity.TeamEntity;
import org.springframework.stereotype.Component;

@Component
public class TeamFactory implements EntityFactory<TeamEntity, TeamDTO>{

    @Override
    public TeamEntity toEntity(TeamDTO teamDTO)
    {
        final TeamEntity team = new TeamEntity();
        team.setId(teamDTO.getId());
        team.setName(teamDTO.getName());
        team.setSlogan(teamDTO.getSlogan());
        return team;
    }

    @Override
    public TeamDTO toDto(TeamEntity team)
    {
        final TeamDTO teamDTO = getTeamDTO(team);
        teamDTO.setPlayers(team.getPlayers().stream().map(PlayerFactory::getPlayerDTO).toList());
        return teamDTO;
    }

    public static TeamDTO getTeamDTO(TeamEntity entity){

        final TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(entity.getId());
        teamDTO.setName(entity.getName());
        teamDTO.setSlogan((entity.getSlogan()));
        return teamDTO;

    }

}

