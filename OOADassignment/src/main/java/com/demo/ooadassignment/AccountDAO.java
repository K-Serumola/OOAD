package com.demo.ooadassignment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {

    public static List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT a.account_id, a.customer_id, a.account_no, a.balance, a.branch, a.accounttype, " +
                "c.name, c.surname, c.password, c.address, c.cell, c.email " +
                "FROM Accounts a " +
                "JOIN Customer c ON a.customer_id = c.customer_id";

        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                // Build Customer object first
                Customer customer = new Customer(
                        rs.getInt("customer_id"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getString("surname"),
                        rs.getString("adress"),
                        rs.getString("cell"),
                        rs.getString("email")
                );

                // Decide which subclass to instantiate
                String type = rs.getString("accounttype").toUpperCase();
                Account account = null;

                switch (type) {
                    case "SAVINGS":
                        float savingsRate = rs.getFloat("interes_rate"); // from DB
                        account = new Savings(customer,
                                rs.getInt("account_no"),
                                rs.getDouble("balance"),
                                rs.getString("branch"),
                                savingsRate);
                        break;

                    case "INVESTMENTS":
                        float investmentRate = rs.getFloat("interes_rate"); // from DB
                        account = new Investments(customer,
                                rs.getInt("account_no"),
                                rs.getDouble("balance"),
                                rs.getString("branch"),
                                investmentRate);
                        break;
                    case "CHEQUE":
                        account = new Cheque(customer,
                                rs.getInt("account_no"),
                                rs.getDouble("balance"),
                                rs.getString("branch"));
                        break;
                    default:
                        System.out.println("Unknown account type: " + type);
                }

                if (account != null) accounts.add(account);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;
    }
}

