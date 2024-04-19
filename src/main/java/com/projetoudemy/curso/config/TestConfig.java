package com.projetoudemy.curso.config;

import com.projetoudemy.curso.entities.*;
import com.projetoudemy.curso.entities.enums.PedidoStatus;
import com.projetoudemy.curso.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PedidoItemRepository pedidoItemRepository;

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria(null, "Electronics");
        Categoria cat2 = new Categoria(null, "Books");
        Categoria cat3 = new Categoria(null, "Computers");

        Produto pr1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Produto pr2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Produto pr3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Produto pr4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Produto pr5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        produtoRepository.saveAll(Arrays.asList(pr1, pr2, pr3, pr4, pr5));

        // Adicionando o produto1 na categoria2
        pr1.getCategorias().add(cat2);
        pr2.getCategorias().add(cat1);
        pr2.getCategorias().add(cat3);
        pr3.getCategorias().add(cat3);
        pr4.getCategorias().add(cat3);
        pr5.getCategorias().add(cat2);

        produtoRepository.saveAll(Arrays.asList(pr1,pr2, pr3, pr4, pr5));

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));

        Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAGO, u1);
        Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u2);
        Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u1);

        pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));

        PedidoItem pi1 = new PedidoItem(p1, pr1, 2, pr1.getPreco());
        PedidoItem pi2 = new PedidoItem(p1, pr3, 1, pr3.getPreco());
        PedidoItem pi3 = new PedidoItem(p2, pr3, 2, pr3.getPreco());
        PedidoItem pi4 = new PedidoItem(p3, pr5, 2, pr5.getPreco());

        pedidoItemRepository.saveAll(Arrays.asList(pi1, pi2, pi3, pi4));
    }
}
