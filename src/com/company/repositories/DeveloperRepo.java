package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Developer;
import com.company.entities.User;
import com.company.repositories.interfaces.IDeveloperRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeveloperRepo implements IDeveloperRepo {
    private final IDB db;

    public DeveloperRepo(IDB db) {
        this.db = db;
    }

    /**
     *overriding of each interface
     */
    @Override
    public boolean createDeveloper(Developer developer) { //creating developer
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO developers(name,surname,gender,salary) VALUES (?,?,?,?)"; //inserting data to developers table
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, developer.getName());
            st.setString(2, developer.getSurname());
            st.setBoolean(3, developer.getGender());
            st.setInt(4, developer.getSalary());

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
        return true;
    }

    @Override
    public Developer getDeveloperById(int id) { //getting developer by id
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,gender,salary FROM developers WHERE id=?"; // outputting data from developers by id
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Developer developer = new Developer(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getBoolean("gender"),
                        rs.getInt("salary"));

                return developer;
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
    public List<Developer> getAllDevelopers() { //getting all developers
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,gender,salary FROM developers"; //outputting all developers
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Developer> developers = new ArrayList<>();
            while (rs.next()) {
                Developer developer = new Developer(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getBoolean("gender"),
                        rs.getInt("salary"));

                developers.add(developer);
            }

            return developers;
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