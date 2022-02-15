package fr.sorbonne.paris.nord.university.api.controller;

import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;
import fr.sorbonne.paris.nord.university.api.entity.TeamEntity;
import fr.sorbonne.paris.nord.university.api.service.TeamService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController (TeamService teamService)
    {
        this.teamService = teamService;
    }

    /*
    @GetMapping("/hello")
    public String getTeams() {
        return "Hello World";
    } */

    @RequestMapping(method = RequestMethod.GET, path = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TeamEntity> get() {
        final TeamEntity body = new TeamEntity();
        body.setName("HELLO");
        return ResponseEntity.ok(body);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<TeamDTO>> getAllTeams(){
        return ResponseEntity.ok(teamService.getAllTeams());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TeamDTO> getTeamById(@PathVariable long id){
        return ResponseEntity.of(teamService.getTeamById(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TeamDTO> addTeam(@RequestBody @Validated TeamDTO team)
    {
        try {
            teamService.addTeam(team);
            return ResponseEntity.ok().build();
        } catch (Exception e)
        {
            return ResponseEntity.internalServerError().build();

        }
    }

    @PutMapping
    public ResponseEntity<TeamDTO> updateTeam(@RequestBody @Validated TeamDTO team)
    {
        try {
            teamService.updateTeam(team);
            return ResponseEntity.ok().build();
        } catch (Exception e)
        {
            return ResponseEntity.internalServerError().build();

        }
    }

    @DeleteMapping("/get/{id}")
    public ResponseEntity<TeamDTO> deleteTeam(@PathVariable long id)
    {
        try {
            teamService.deleteTeamById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e)
        {
            return ResponseEntity.internalServerError().build();

        }
    }

}