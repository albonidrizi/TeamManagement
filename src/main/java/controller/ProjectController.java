package controller;

import model.Project;
import model.ProjectStatus;
import model.Team;
import repository.ProjectRepository;
import repository.TeamRepository;

import java.sql.SQLException;
import java.util.List;

public class ProjectController {

    ProjectRepository projectRepository = new ProjectRepository();
    TeamRepository teamRepository = new TeamRepository();

    public void createProject(String name, Integer cost, String teamName) throws SQLException, ClassNotFoundException {
        Project project = new Project();
        project.setName(name);
        project.setCost(cost);

        Team team = teamRepository.getByName(teamName);
        project.setTeam(team);

        projectRepository.add(project);
    }

    public void startProject(Integer id) throws SQLException, ClassNotFoundException {
        Project project = projectRepository.getById(id);
        project.setProjectStatus(ProjectStatus.IN_PROGRESS);
        projectRepository.update(project);
    }

    public void completeProject(Integer id) throws SQLException, ClassNotFoundException {
        Project project = projectRepository.getById(id);
        project.setProjectStatus(ProjectStatus.COMPLETED);
        projectRepository.update(project);
    }

    public List<Project> getProjectsByCost(Integer cost) throws SQLException, ClassNotFoundException {
        return projectRepository.getByCost(cost);
    }

    public List<Project> getProjectsByTeam(String teamName) throws SQLException, ClassNotFoundException {
        return projectRepository.getByTeam(teamRepository.getByName(teamName));
    }

    public List<Project> getAllProjects() throws SQLException, ClassNotFoundException {
        return projectRepository.getAll();
    }

}
