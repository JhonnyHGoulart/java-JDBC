package br.com.senai.javaejdbc.persistenciacomDAO;

import br.com.senai.javaejdbc.connectionfactory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteInsercaoComProduto2 {
    public static void main(String[] args) throws SQLException {

        Produto comoda = new Produto(3, "Cômoda", "Cômoda Vertical");
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            produtoDAO.salvar(comoda);
        }
    }
}
