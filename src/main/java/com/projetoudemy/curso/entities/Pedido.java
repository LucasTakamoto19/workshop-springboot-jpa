package com.projetoudemy.curso.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projetoudemy.curso.entities.enums.PedidoStatus;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "db_pedidos")
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy/MM/dd'T'HH:mm:ss'Z'",
            timezone = "GMT")
    private Instant moment;

    @Autowired
    private PedidoStatus pedidoStatus;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private User cliente;

    @OneToMany(mappedBy = "id.pedido")
    private Set<PedidoItem> itens = new HashSet<>();

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Pagamento pagamento;

    public Pedido() {
    }

    public Pedido(Long id, Instant moment, PedidoStatus pedidoStatus, User cliente) {
        this.id = id;
        this.moment = moment;
        setPedidoStatus(pedidoStatus);
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public PedidoStatus getPedidoStatus() {
        return PedidoStatus.valueOf(String.valueOf(pedidoStatus));
    }

    public void setPedidoStatus(PedidoStatus pedidoStatus) {
        if (pedidoStatus != null){
            this.pedidoStatus = PedidoStatus.valueOf(pedidoStatus.getCode());
        }
    }

    public User getCliente() {
        return cliente;
    }

    public void setCliente(User cliente) {
        this.cliente = cliente;
    }

    public void setItens(Set<PedidoItem> itens) {
        this.itens = itens;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Set<PedidoItem>getItens(){
        return itens;
    }

    public Double getTotal(){
        double soma = 0;
        for (PedidoItem x : itens){
            soma = soma + x.getSubTotal();
        }
        return soma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id) && Objects.equals(moment, pedido.moment) && Objects.equals(cliente, pedido.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moment, cliente);
    }
}
