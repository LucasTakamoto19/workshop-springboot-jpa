package com.projetoudemy.curso.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String descricao;
    private Double preco;
    private String imgUrl;

    // garante que é apenas esse produto
    @ManyToMany
    @JoinTable(name = "tb_produto_categoria",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))

    private Set<Categoria> categorias = new HashSet<>();

    @OneToMany(mappedBy = "id.produto")
    private Set<PedidoItem> itens = new HashSet<>();

    public Produto() {
    }

    public Produto(Long id, String name, String descricao, Double preco, String imgUrl) {
        this.id = id;
        this.name = name;
        this.descricao = descricao;
        this.preco = preco;
        this.imgUrl = imgUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    @JsonIgnore
    public Set<Pedido> getPedidos(){
        Set<Pedido> set = new HashSet<>();
        for (PedidoItem x : itens){
            set.add(x.getPedido());
        }
        return set;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id) && Objects.equals(name, produto.name) && Objects.equals(descricao, produto.descricao) && Objects.equals(preco, produto.preco) && Objects.equals(imgUrl, produto.imgUrl) && Objects.equals(categorias, produto.categorias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
