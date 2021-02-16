package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Locomotive;
import com.company.entities.User;
import com.company.repositories.interfaces.ILocomotiveRepo;
import com.company.repositories.interfaces.IUserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LocomotiveRepo implements ILocomotiveRepo {
    private final IDB db;

    public LocomotiveRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createLocomotive(Locomotive locomotive) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO locomotives(name) VALUES (?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, locomotive.getName());

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
    public Locomotive getLocomotiveById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name FROM locomotives WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Locomotive locomotive = new Locomotive(rs.getInt("id"),
                        rs.getString("name"));

                return locomotive;
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
    public List<Locomotive> getAllLocomotives() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name FROM locomotives";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Locomotive> locomotives = new ArrayList<>();
            while (rs.next()) {
                Locomotive locomotive = new Locomotive(rs.getInt("id"),
                        rs.getString("name"));

                locomotives.add(locomotive);
            }

            return locomotives;
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
