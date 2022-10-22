package repository;

import model.Project;
import model.ProjectStatus;
import model.Team;
import repository.conn.Constants;
import repository.conn.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository implements GenericRepository<Project, Integer> {

    TeamRepository teamRepository = new TeamRepository();

    @Override
    public List<Project> getAll() throws SQLException, ClassNotFoundException{
        Connection conn = JDBCConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(Constants.GET_ALL_PROJECTS);
        ResultSet resultSet = statement.executeQuery();

        List<Project> projects = new ArrayList<>();

        while (resultSet.next()) {
            Project project = new Project();
            Integer id = resultSet.getInt("Id");
            String name = resultSet.getString("Name");
            Integer cost = resultSet.getInt("Cost");
            String projectStatus = resultSet.getString("ProjectStatus");
            Integer teamId = resultSet.getInt("TeamId");

            ProjectStatus status = ProjectStatus.valueOf(projectStatus);
            Team team = teamRepository.getById(teamId);

            project.setId(id);
            project.setName(name);
            project.setCost(cost);
            project.setProjectStatus(status);
            project.setTeam(team);

            projects.add(project);
        }

        return projects;
    }

    @Override
    public Project getById(Integer id) throws SQLException, ClassNotFoundException {
        Connection conn = JDBCConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(Constants.GET_PROJECT_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        Project project = null;

        while (resultSet.next()) {
            project = new Project();
            String name = resultSet.getString("Name");
            Integer cost = resultSet.getInt("Cost");
            String projectStatus = resultSet.getString("ProjectStatus");
            Integer teamId = resultSet.getInt("TeamId");

            ProjectStatus status = ProjectStatus.valueOf(projectStatus);
            Team team = teamRepository.getById(teamId);

            project.setId(id);
            project.setName(name);
            project.setCost(cost);
            project.setProjectStatus(status);
            project.setTeam(team);
        }

        return project;
    }

    @Override
    public void add(Project model) throws SQLException, ClassNotFoundException {
        Connection conn = JDBCConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(Constants.ADD_PROJECT);
        statement.setString(1, model.getName());
        statement.setInt(2, model.getCost());
        statement.setString(3, model.getProjectStatus().toString());
        statement.setInt(4, model.getTeam().getId());

        statement.execute();
        statement.close();
    }

    @Override
    public void update(Project model) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(Constants.PROJECT_UPDATE_SQL);
        statement.setString(1, model.getName());
        statement.setInt(2, model.getCost());
        statement.setString(3, String.valueOf(model.getProjectStatus()));
        statement.setInt(4, model.getId());

        statement.executeUpdate();
        statement.close();
    }

    @Override
    public void delete(Project model) {

    }

    public List<Project> getByCost(Integer cost) throws SQLException, ClassNotFoundException {
        Connection conn = JDBCConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(Constants.GET_PROJECTS_BY_COST);
        statement.setInt(1, cost);
        ResultSet resultSet = statement.executeQuery();

        List<Project> projects = new ArrayList<>();

        while (resultSet.next()) {
            Project project = new Project();
            Integer id = resultSet.getInt("Id");
            String name = resultSet.getString("Name");
            String projectStatus = resultSet.getString("ProjectStatus");
            Integer teamId = resultSet.getInt("TeamId");

            ProjectStatus status = ProjectStatus.valueOf(projectStatus);
            Team team = teamRepository.getById(teamId);

            project.setId(id);
            project.setName(name);
            project.setCost(cost);
            project.setProjectStatus(status);
            project.setTeam(team);

            projects.add(project);
        }

        return projects;
    }

    public List<Project> getByTeam(Team team) throws SQLException, ClassNotFoundException {
        Connection conn = JDBCConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(Constants.GET_PROJECTS_BY_TEAM);
        statement.setInt(1, team.getId());
        ResultSet resultSet = statement.executeQuery();

        List<Project> projects = new ArrayList<>();

        while (resultSet.next()) {
            Project project = new Project();
            Integer id = resultSet.getInt("Id");
            String name = resultSet.getString("Name");
            Integer cost = resultSet.getInt("Cost");
            String projectStatus = resultSet.getString("ProjectStatus");

            ProjectStatus status = ProjectStatus.valueOf(projectStatus);

            project.setId(id);
            project.setName(name);
            project.setCost(cost);
            project.setProjectStatus(status);
            project.setTeam(team);

            projects.add(project);
        }

        return projects;
    }
}
