package view;

import controller.TeamController;
import model.Team;

import java.sql.SQLException;
import java.util.List;

public class TeamView {

    private TeamController teamController = new TeamController();

    public void showTeams() {
        try {
            showTeams(teamController.getAllTeams());
        } catch (SQLException e) {
            System.out.println("Incorrect query results");
        } catch (ClassNotFoundException e) {
            System.out.println("Connection failed.");
        }
    }

    private void showTeams(List<Team> teams) {
        System.out.println("Id\t\tName");
        for (Team team : teams) {
            System.out.println(team.getId() + "\t\t" + team.getName());
        }
    }
}
