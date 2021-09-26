package br.com.senai.javaejdbc.persistenciacomDAO.modeloDAOproduto;

import br.com.senai.javaejdbc.connectionfactory.ConnectionFactory;

import java.sql.*;

public class TesteInsercaoComProduto {
    public static void main(String[] args) throws SQLException {

        Produto comoda = new Produto(3, "Cômoda", "Cômoda Vertical");

        try (Connection connection = new ConnectionFactory().recuperarConexao()) {

            String sql = "INSERT INTO PRODUTO(ID, NOME, DESCRICAO) VALUES(?,?,?)";
            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstm.setInt(1, comoda.getId());
                pstm.setString(2, comoda.getNome());
                pstm.setString(3, comoda.getDescricao());
                pstm.execute();

                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                        comoda.setId(rst.getInt(1));
                    }
                }
            }
        }
        System.out.println(comoda);
    }
}
