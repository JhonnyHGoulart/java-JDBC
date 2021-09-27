package br.com.senai.javaejdbc.persistenciacomDAO.modeloDAOcategorias;

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
}
