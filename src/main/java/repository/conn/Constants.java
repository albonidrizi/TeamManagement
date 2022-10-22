package repository.conn;

public class Constants {

    public static final String GET_ALL_TEAMS = "select * from teams";
    public static final String GET_TEAM_BY_NAME = "select * from teams where name = ?";
    public static final String GET_TEAM_BY_ID = "select * from teams where id = ?";

    public static final String GET_ALL_PROJECTS = "select * from projects";
    public static final String GET_PROJECT_BY_ID = "select * from projects where id = ?";
    public static final String GET_PROJECTS_BY_COST = "select * from projects where cost = ?";
    public static final String GET_PROJECTS_BY_TEAM = "select * from projects where teamid = ?";
    public static final String ADD_PROJECT = "insert into Projects (Name, Cost, ProjectStatus, TeamId) values (?, ?, ?, ?)";
    public static final String PROJECT_UPDATE_SQL = "update projects set name = ?, cost = ?, projectstatus = ? where id = ?";
}
