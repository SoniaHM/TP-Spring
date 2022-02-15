package fr.sorbonne.paris.nord.university.api;

import fr.sorbonne.paris.nord.university.api.entity.TeamEntity;
import fr.sorbonne.paris.nord.university.api.service.TeamService;
import fr.sorbonne.paris.nord.university.api.service.TeamServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TpTeamsHandlingApiApplication {

	public static void main(String[] args) {


		final ConfigurableApplicationContext context = SpringApplication.run(TpTeamsHandlingApiApplication.class, args);
		final TeamServiceImpl bean = context.getBean(TeamServiceImpl.class);
		/*
		TeamEntity team = new TeamEntity();
		team.setName("Equipe test");
		team.setSlogan("Slogan test");

		TeamEntity team2 = new TeamEntity();
		team2.setId(3);
		team2.setName("Barcelone2");
		team2.setSlogan("Slogan2");

		bean.addTeam(team);
		System.out.println(bean.getTeamById(1));
		bean.updateTeam(team2);
		bean.deleteTeamById(4); */

	}


}
