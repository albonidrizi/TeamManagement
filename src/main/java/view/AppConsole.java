package view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AppConsole {

    private Scanner scanner;
    private ProjectView projectView;
    private EmployeeView employeeView;
    private TeamView teamView;

    public AppConsole() {
        scanner = new Scanner(System.in);
        projectView = new ProjectView();
        employeeView = new EmployeeView();
        teamView = new TeamView();
    }

    public void run() {
        printGeneralMenu();
        String choice = scanner.nextLine();

        switch (choice) {
            default:
                System.out.println("Oops, it's a wrong value.\n");
                break;
            case "1": {
                Map<String, String> params = requireInputParams("name", "cost", "teamName");
                projectView.createProject(params.get("name"),
                        Integer.parseInt(params.get("cost")),
                        params.get("teamName"));
                break;
            } case "2": {
                Map<String, String> params = requireInputParams("id");
                projectView.startProject(Integer.parseInt(params.get("id")));
                break;
            } case "3": {
                Map<String, String> params = requireInputParams("id");
                projectView.completeProject(params.get("id"));
                break;
            } case "4": {
                Map<String, String> params = requireInputParams("cost");
                projectView.showProjectsByCost(Integer.parseInt(params.get("cost")));
                break;
            } case "5": {
                Map<String, String> params = requireInputParams("teamName");
                projectView.showProjectsByTeam(params.get("teamName"));
                break;
            } case "6": {
                employeeView.showEmployees();
                break;
            } case "7": {
                projectView.showProjects();
                break;
            } case "8": {
                teamView.showTeams();
                break;
            } case "0": {
                return;
            }
        }

        run();
    }

    private Map<String, String> requireInputParams(String... params) {
        Map<String, String> values = new HashMap<>();
        for (String param : params) {
            System.out.println("Enter " + param + " :");
            String value = scanner.nextLine();
            values.put(param, value);
        }
        return values;
    }

    private void printGeneralMenu() {
        System.out.println("\n1. Create project");
        System.out.println("2. Start project");
        System.out.println("3. Complete project");
        System.out.println("4. Find project by cost");
        System.out.println("5. Find project by team");
        System.out.println("6. Show employees");
        System.out.println("7. Show projects");
        System.out.println("8. Show teams");
        System.out.println("0. Exit \n");
    }

}
