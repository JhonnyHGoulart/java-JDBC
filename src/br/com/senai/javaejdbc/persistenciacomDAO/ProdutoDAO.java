package br.com.senai.javaejdbc.persistenciacomDAO;

import br.com.senai.javaejdbc.connectionfactory.ConnectionFactory;

import java.sql.*;

public class ProdutoDAO {
    private Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }

    public void salvar(Produto produto) throws SQLException {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            String sql = "INSERT INTO PRODUTO (ID,NOME,DESCRICAO) VALUES (?,?,?)";
            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstm.setInt(1, 3);
                pstm.setString(2, produto.getNome());
                pstm.setString(3, produto.getDescricao());

                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                        produto.setId((rst.getInt(1)));
                    }
                }
            }
        }
    }
}
