package fr.sorbonne.paris.nord.university.api;
import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;
import fr.sorbonne.paris.nord.university.api.entity.TeamEntity;
import fr.sorbonne.paris.nord.university.api.factory.TeamFactory;
import fr.sorbonne.paris.nord.university.api.repository.TeamRepository;
import fr.sorbonne.paris.nord.university.api.service.TeamServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class TeamServiceImplTest {


    @Mock
    private TeamRepository teamRepository;

    @Mock
    private TeamFactory teamFactory;

    @InjectMocks
    private TeamServiceImpl service;



    @Test
    public void getAllTeams()

    {
        // Given.
        final ArrayList<TeamEntity> teamEntities = new ArrayList<>();
        teamEntities.add(new TeamEntity());
        when(teamRepository.findAll()).thenReturn(teamEntities);

        doCallRealMethod().when(teamFactory).toDto(any());

        // When.
        final List<TeamDTO> allTeams = service.getAllTeams();
        // Then.
        assertEquals(1, allTeams.size());


    }

    @Test
    public void updateTeam()
    {
        //GIVEN
        final TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(1L);
        teamDTO.setName("NAME");
        teamDTO.setSlogan("SLOGAN");

        final TeamEntity entity = new TeamEntity();
        entity.setName("XXX");

        when(teamRepository.findById(anyLong())).thenReturn(Optional.of(entity));

        //WHEN
        service.updateTeam(teamDTO);

        //THEN
        assertEquals("NAME", entity.getName());
        assertEquals("SLOGAN", entity.getSlogan());


    }


    @Test
    public void getTeamById(){

        //GIVEN

        final TeamEntity entity = new TeamEntity();
        entity.setId(1L);
        entity.setName("NAME");
        entity.setSlogan("SLOGAN");

        when(teamRepository.findById(anyLong())).thenReturn(Optional.of(entity));
        doCallRealMethod().when(teamFactory).toDto(any());

        //WHEN
        Optional<TeamDTO> dto = service.getTeamById(1L);

        //THEN
        assertEquals(true, dto.isPresent());
        assertEquals("NAME", dto.get().getName());
        assertEquals( 1L, dto.get().getId());
        assertEquals("SLOGAN", dto.get().getSlogan());

        verify(teamRepository).findById(1L);
        verify(teamFactory).toDto(entity);

    }

    @Test
    public void addTeam(){

        //GIVEN
        final TeamDTO teamDTO = new TeamDTO();
        TeamEntity entity = new TeamEntity();

        when(teamFactory.toEntity(any())).thenReturn(entity);
        when(teamRepository.save(any(TeamEntity.class))).thenAnswer(i-> i.getArgument(0));

        //WHEN
        service.addTeam(teamDTO);

        //THEN
        verify(teamFactory).toEntity(teamDTO);
        verify(teamRepository).save(entity);

    }

    @Test
    public void deleteTeam(){

        //GIVEN
        doNothing().when(teamRepository).deleteById(anyLong());

        //WHEN
        service.deleteTeamById(1L);

        //THEN
        verify(teamRepository, times(1)).deleteById(1L);

    }
}
