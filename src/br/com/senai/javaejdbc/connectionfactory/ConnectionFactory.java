package br.com.senai.javaejdbc.connectionfactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection recuperarConexao() throws SQLException {
        return DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");

    }
}
