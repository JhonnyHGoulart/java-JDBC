package br.com.senai.javaejdbc.connectionfactory;

import java.io.Console;
import java.sql.*;

public class TesteInsercaoComParametro2 {
    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();
        connection.setAutoCommit(false);

        try {

            PreparedStatement stm =
                    connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            adicionarVariavel("SmartTV", "45 Polegadas", stm);
            adicionarVariavel("Radio", "Radio de bateria", stm);
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ROLLBACK EXECUTADO");
            connection.rollback();

        }
    }

    public static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
        stm.setString(1, nome);
        stm.setString(2, descricao);

        if (nome.equals("Radio")) {
            throw new RuntimeException("Não foi possivel cadicionar o produto");
        }
        stm.execute();

        ResultSet rst = stm.getGeneratedKeys();
        while (rst.next()) {
            Integer id = rst.getInt(1);
            System.out.println("O id criado foi: " + id);
        }
        rst.close();
    }
}
