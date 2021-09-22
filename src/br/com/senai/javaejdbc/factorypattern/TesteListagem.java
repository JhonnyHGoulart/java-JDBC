package br.com.senai.javaejdbc.factorypattern;

import java.sql.*;

public class TesteListagem {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");

        Statement stm = connection.createStatement();
        stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");

        ResultSet rst = stm.getResultSet();

        while (rst.next()) {
            Integer id = rst.getInt("ID");
            System.out.println(id);
            String nome = rst.getString("NOME");
            System.out.println(nome);
            String descricao = rst.getString("DESCRICAO");
            System.out.println(descricao);

        }

        connection.close();
    }
}
