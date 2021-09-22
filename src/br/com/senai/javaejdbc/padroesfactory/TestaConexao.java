package br.com.senai.javaejdbc.padroesfactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost/", "postgres", "postgres");

        System.out.println("Fechando conexão!!");
        connection.close();
    }
}
