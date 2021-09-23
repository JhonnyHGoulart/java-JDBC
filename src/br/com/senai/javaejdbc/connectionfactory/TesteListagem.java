package br.com.senai.javaejdbc.connectionfactory;

import java.sql.*;

public class TesteListagem {
    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        Connection connection = connectionFactory.recuperarConexao();

//        Statement stm = connection.createStatement();
//        stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");

        PreparedStatement stm = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
        stm.execute();

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
