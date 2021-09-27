package br.com.senai.javaejdbc.persistenciacomDAO.modeloDAOcategorias;

import br.com.senai.javaejdbc.persistenciacomDAO.modeloDAOproduto.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    private Connection connection;

    public CategoriaDAO(Connection connection) {
        this.connection = connection;
    }

    public List<CategoriaProduto> listar() throws SQLException {
        List<CategoriaProduto> categorias = new ArrayList<>();

        String sql = "SELECT * FROM CATEGORIA_PRODUTO";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.execute();

            try (ResultSet rst = pstm.getResultSet()) {
                while (rst.next()) {
                    CategoriaProduto categoriaProduto =
                            new CategoriaProduto(rst.getInt(1), rst.getString(2));
                    categorias.add(categoriaProduto);
                }
            }
        }
        return categorias;
    }

    public List<CategoriaProduto> listarComProdutos() throws SQLException {
        List<CategoriaProduto> categorias = new ArrayList<>();

        String sql = "SELECT C.ID, C.NOME, P.ID, P.NOME, P.DESCRICAO FROM CATEGORIA_PRODUTO C INNER JOIN PRODUTO P ON C.ID = P.CATEGORIA_ID";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.execute();

            try (ResultSet rst = pstm.getResultSet()) {
                while (rst.next()) {
                    CategoriaProduto categoriaProduto =
                            new CategoriaProduto(rst.getInt(1), rst.getString(2));
                    categorias.add(categoriaProduto);
                }
            }
        }
        return categorias;
    }
}
