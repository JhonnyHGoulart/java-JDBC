package br.com.senai.javaejdbc.connectionfactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteRemocao {
    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

//        Statement stm = connection.createStatement();
//        stm.execute("DELETE FROM PRODUTO WHERE ID > 2");

        PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
        stm.setInt(1, 2);
        stm.execute();

        Integer linhasModificadas = stm.getUpdateCount();
        System.out.println("Quantidade de linhas que foram modificadas: " + linhasModificadas);

    }
}
