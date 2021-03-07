package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Connector;
import com.company.repositories.interfaces.IConnectorRepo;
import com.company.repositories.interfaces.IConnectorRepo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectorRepo implements IConnectorRepo {
    private final IDB db;
    public ConnectorRepo(IDB db){this.db = db;};//link with database

    @Override
    public boolean createConnector(Connector connector) {
        Connection con = null;//object
        try {//checking for troubles
            con = db.getConnection();
            String sql = "INSERT INTO connector(necklace_id,stone_id) VALUES (?,?)"; //insert data to database
            PreparedStatement st = con.prepareStatement(sql);
            //input
            st.setInt(1, connector.getNecklace_id());
            st.setInt(2, connector.getStone_id());



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
}