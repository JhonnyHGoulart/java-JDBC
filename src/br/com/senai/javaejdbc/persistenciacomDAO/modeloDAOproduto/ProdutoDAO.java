package br.com.senai.javaejdbc.persistenciacomDAO.modeloDAOproduto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }

    public void salvar(Produto produto) throws SQLException {
        String sql = "INSERT INTO PRODUTO (ID,NOME,DESCRICAO) VALUES (?,?,?)";
        try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstm.setInt(1, produto.getId());
            pstm.setString(2, produto.getNome());
            pstm.setString(3, produto.getDescricao());
            pstm.execute();

            try (ResultSet rst = pstm.getGeneratedKeys()) {
                while (rst.next()) {
                    produto.setId((rst.getInt(1)));
                }
            }
        }
    }

    public List<Produto> listarProdutos() throws SQLException {
        List<Produto> produtos = new ArrayList<Produto>();
        String sql = "SELECT * FROM PRODUTO";
        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.execute();

            try (ResultSet rst = pstm.getResultSet()) {
                while (rst.next()) {
                    Produto produto =
                            new Produto(rst.getInt(1), rst.getString(2), rst.getString(3));

                    produtos.add(produto);
                }
            }
        }

        return produtos;
    }

}
