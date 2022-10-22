package repository;

import model.Team;
import repository.conn.Constants;
import repository.conn.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamRepository implements GenericRepository<Team, Integer> {

    @Override
    public List<Team> getAll() throws SQLException, ClassNotFoundException {
        List<Team> teams = new ArrayList<>();
        Connection conn = JDBCConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(Constants.GET_ALL_TEAMS);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Team team = new Team();
            Integer id = resultSet.getInt("Id");
            String name = resultSet.getString("Name");

            team.setId(id);
            team.setName(name);

            teams.add(team);
        }

        return teams;
    }

    @Override
    public Team getById(Integer id) throws SQLException, ClassNotFoundException {
        Connection connection = JDBCConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(Constants.GET_TEAM_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        Team team = new Team();
        while (resultSet.next()) {
            Integer teamId = resultSet.getInt("Id");
            String name = resultSet.getString("Name");

            team.setId(teamId);
            team.setName(name);
        }

        return team;
    }
    @Override
    public void add(Team model) {
    }

    @Override
    public void update(Team model) {
    }

    @Override
    public void delete(Team model) {
    }

    public Team getByName(String teamName) throws SQLException, ClassNotFoundException {
        Connection connection = JDBCConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(Constants.GET_TEAM_BY_NAME);
        statement.setString(1, teamName);
        ResultSet resultSet = statement.executeQuery();

        Team team = new Team();
        while (resultSet.next()) {
            Integer id = resultSet.getInt("Id");
            String name = resultSet.getString("Name");

            team.setId(id);
            team.setName(name);
        }

        return team;
    }
}
