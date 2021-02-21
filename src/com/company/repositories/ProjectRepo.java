package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Project;
import com.company.entities.Train;
import com.company.entities.User;
import com.company.repositories.interfaces.IProjectRepo;
import com.company.repositories.interfaces.IUserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProjectRepo implements IProjectRepo {
    private final IDB db;

    public ProjectRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createProject(Project project) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO projects(name) VALUES (?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, project.getName());

            boolean executed = st.execute();
            return executed;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public int getTotalCostOfProject() {
        updateTotalCostOfProject();
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT SUM(salary) FROM developers";
            PreparedStatement st = con.prepareStatement(sql);


            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int totalCost = rs.getInt(1);

                return totalCost;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public boolean updateTotalCostOfProject() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "update projects set totalcost=(SELECT SUM(salary) FROM developers) where id=1";
            PreparedStatement st = con.prepareStatement(sql);


            return st.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public Project getProjectById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,totalCost FROM projects WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Project project = new Project(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("totalCost"));

                return project;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Project> getAllProjects() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,totalCost FROM projects";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Project> projects = new ArrayList<>();
            while (rs.next()) {
                Project project = new Project(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("totalCost"));

                projects.add(project);
            }

            return projects;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }


}
