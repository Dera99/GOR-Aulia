package com.app.service;

import com.app.chart.ModelChart;
import com.app.configurations.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServiceReport {
    ResultSet rs = null;
    Connection CC = new DatabaseConnection().connect();;
    PreparedStatement pst = null;
    Statement stt;
    String sql;
    public List<ModelChart> getData() throws SQLException {
        List<ModelChart> list = new ArrayList<>();
        sql = "select DATE_FORMAT(Date,'%M') as M, SUM(Total) as Total, SUM(Cost) as Cost, SUM(Profit) as Profit from invoice GROUP BY DATE_FORMAT(Date,'%Y-%M') order by Date DESC limit 6";
        pst = CC.prepareStatement(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
            String month = rs.getString(1);
            double total = rs.getDouble(2);
            double cost = rs.getDouble(3);
            double profit = rs.getDouble(4);
            list.add(new ModelChart(month, new double[]{total, cost, profit}));
        }
        rs.close();
        pst.close();
        return list;
    }
}
