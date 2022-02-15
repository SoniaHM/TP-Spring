package fr.sorbonne.paris.nord.university.api.service;

import fr.sorbonne.paris.nord.university.api.annotations.Loggable;

import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;
import fr.sorbonne.paris.nord.university.api.entity.TeamEntity;
import fr.sorbonne.paris.nord.university.api.factory.TeamFactory;
import fr.sorbonne.paris.nord.university.api.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService{

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamFactory teamFactory;

    @Override
    @Loggable
    @Transactional(readOnly = true)
    public List<TeamDTO> getAllTeams() {
        return teamRepository.findAll().stream().map(teamFactory::toDto).collect(Collectors.toList());
    }

    @Override
    @Loggable
    @Transactional
    public Optional<TeamDTO> getTeamById(long id) {
        return teamRepository.findById(id).map(teamFactory::toDto);
    }

    @Override
    @Loggable
    @Transactional
    public void addTeam(TeamDTO team) {
        teamRepository.save(teamFactory.toEntity(team));
    }

    @Override
    @Loggable
    @Transactional
    public void updateTeam(TeamDTO team) {

        Optional<TeamEntity> newteamEntity  = teamRepository.findById(team.getId());
        if (!newteamEntity.isPresent())
        {
            addTeam(team);
        }

        else {
            newteamEntity.get().setName(team.getName());
            newteamEntity.get().setSlogan(team.getSlogan());

        }

    }

    @Override
    @Loggable
    @Transactional
    public void deleteTeamById(long id) {
        teamRepository.deleteById(id);
    }
}
