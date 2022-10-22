package controller;

import model.Team;
import repository.TeamRepository;

import java.sql.SQLException;
import java.util.List;

public class TeamController {

    private TeamRepository teamRepository = new TeamRepository();

    public List<Team> getAllTeams() throws SQLException, ClassNotFoundException {
        return teamRepository.getAll();
    }

}
