package view;

import controller.ProjectController;
import model.Project;

import java.sql.SQLException;
import java.util.List;

public class ProjectView {

    private final ProjectController projectController = new ProjectController();

    void createProject(String name, Integer cost, String teamName) {
        try {
            projectController.createProject(name, cost, teamName);
        } catch (SQLException e) {
            System.out.println("Incorrect query results");
        } catch (ClassNotFoundException e) {
            System.out.println("Connection failed.");
        }
    }

    void startProject(Integer id) {
        try {
            projectController.startProject(id);
        } catch (SQLException e) {
            System.out.println("Incorrect query results");
        } catch (ClassNotFoundException e) {
            System.out.println("Connection failed.");
        }
    }

    void completeProject(String id) {
        try {
            projectController.completeProject(Integer.parseInt(id));
        } catch (SQLException e) {
            System.out.println("Incorrect query results");
        } catch (ClassNotFoundException e) {
            System.out.println("Connection failed.");
        }
    }

    void showProjectsByCost(Integer cost) {
        List<Project> projects;
        try {
            projects = projectController.getProjectsByCost(cost);
            showProjects(projects);
        } catch (SQLException e) {
            System.out.println("Incorrect query results");
        } catch (ClassNotFoundException e) {
            System.out.println("Connection failed.");
        }
    }

    void showProjectsByTeam(String teamName) {
        List<Project> projects;
        try {
            projects = projectController.getProjectsByTeam(teamName);
            showProjects(projects);
        } catch (SQLException e) {
            System.out.println("Incorrect query results");
        } catch (ClassNotFoundException e) {
            System.out.println("Connection failed.");
        }
    }

    public void showProjects() {
        try {
            showProjects(projectController.getAllProjects());
        } catch (SQLException e) {
            System.out.println("Incorrect query results");
        } catch (ClassNotFoundException e) {
            System.out.println("Connection failed.");
        }
    }

    private void showProjects(List<Project> projects) {
        System.out.println("Id\t\tName\t\tCost\t\tStatus\t\tTeam");
        for (Project project : projects) {
            System.out.println(project.getId() + "\t\t" +
                    project.getName() + "\t\t" +
                    project.getCost() + "\t\t" +
                    project.getProjectStatus() + "\t\t" +
                    project.getTeam().getName());
        }
    }

}
