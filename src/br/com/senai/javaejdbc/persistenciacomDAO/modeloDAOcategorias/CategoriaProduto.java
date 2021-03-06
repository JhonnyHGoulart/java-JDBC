package br.com.senai.javaejdbc.persistenciacomDAO.modeloDAOcategorias;

import br.com.senai.javaejdbc.persistenciacomDAO.modeloDAOproduto.Produto;

import java.util.List;

public class CategoriaProduto {
    private Integer id;
    private String nome;
    private List<Produto> produtos;

    public CategoriaProduto(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "CategoriaProduto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void adicionar(Produto produto) {
        produtos.add(produto);
    }
}
