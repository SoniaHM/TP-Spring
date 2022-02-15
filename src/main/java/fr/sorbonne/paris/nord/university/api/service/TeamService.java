package fr.sorbonne.paris.nord.university.api.service;

import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;
import fr.sorbonne.paris.nord.university.api.entity.TeamEntity;

import java.util.List;
import java.util.Optional;

public interface TeamService {

    List<TeamDTO> getAllTeams();
    Optional<TeamDTO> getTeamById(long id);
    void addTeam(TeamDTO team);
    void updateTeam(TeamDTO team);
    void deleteTeamById(long id);



}
