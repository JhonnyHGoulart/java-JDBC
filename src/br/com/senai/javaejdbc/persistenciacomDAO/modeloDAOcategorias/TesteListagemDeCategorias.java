package br.com.senai.javaejdbc.persistenciacomDAO.modeloDAOcategorias;

import br.com.senai.javaejdbc.connectionfactory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TesteListagemDeCategorias {
    public static void main(String[] args) throws SQLException {

        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
            List<CategoriaProduto> listaDeCategorias = categoriaDAO.listar();
            listaDeCategorias.stream()
                    .forEach(ct -> System.out.println(ct));
        }
    }
}
