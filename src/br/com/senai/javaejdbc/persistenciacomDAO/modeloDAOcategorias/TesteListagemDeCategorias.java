package br.com.senai.javaejdbc.persistenciacomDAO.modeloDAOcategorias;

import br.com.senai.javaejdbc.connectionfactory.ConnectionFactory;
import br.com.senai.javaejdbc.persistenciacomDAO.modeloDAOproduto.Produto;
import br.com.senai.javaejdbc.persistenciacomDAO.modeloDAOproduto.ProdutoDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TesteListagemDeCategorias {
    public static void main(String[] args) throws SQLException {

        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            CategoriaDAO categoriaDAO = new CategoriaDAO(connection);

            List<CategoriaProduto> listaDeCategorias = categoriaDAO.listarComProdutos();
            listaDeCategorias.stream()
                    .forEach(ct -> {
                        System.out.println(ct);
                        try {
                            for (Produto produto : new ProdutoDAO(connection).buscar(ct)) {
                                System.out.println(ct.getNome() + " - " + produto.getNome());
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }
}
