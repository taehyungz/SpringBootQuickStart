package com.rubypaper.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnectionManager {
    private String driverClass;
    private String url;
    private String username;
    private String password;

    public void setDriverClass(String driverClass) { this.driverClass = driverClass; }

    public void setUrl(String url) { this.url = url; }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getConnection() {
        try {
            Class.forName(driverClass);
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "JDBCConnectionManager [driverClass=" + driverClass + ", url=" + url + ", username=" + username + ", password=" + password + "]";
    }

}
