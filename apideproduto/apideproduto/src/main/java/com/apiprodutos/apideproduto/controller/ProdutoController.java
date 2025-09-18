package com.apiprodutos.apideproduto.controller;


import com.apiprodutos.apideproduto.model.Produto;
import com.apiprodutos.apideproduto.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController // Essa anotation avisa que essa classe vai receber requisições Rest
@RequestMapping("/produtos")
public class ProdutoController {


    private ProdutoRepository produtoRepository; // Para injetar o ProdutoRepository "Minha JPA"

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }



    @PostMapping // Para enviar e salvar dados
    public Produto enviarDados(@RequestBody Produto produto){
        System.out.println("Produto recebido :" + produto );
        var id = UUID.randomUUID().toString();
        produto.setId(id);
        produtoRepository.save(produto);
        return produto;
    }

    // Passa o Tipo do Id  , O ponto var é que desejo criar uma variável através daquela expressão . Estou acessando por id !!! no get do Postman
    @GetMapping("/{id}") // Pode outros tambem como /{nome}/{outrovalor} e através disso Cria outro PathVariable com uma virgula apos o Tipo da variavel
    public Produto obterProduto(@PathVariable("id") String id ){ // O PathVariable recebe via URL . O código gerado pelo ID /codigoqualquer
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.isPresent() ? produto.get() : null;
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") String id){
        produtoRepository.deleteById(id);
    }

    // Put serve para atualizar os dados onde o id de produto for o id que eu enviei lá no meu post .
    @PutMapping("/{id}")
    public void atualizar(@PathVariable("id") String id , @RequestBody Produto produto){
        produto.setId(id);
        produtoRepository.save(produto);
    }

    // Metodo de busca onde posso passar na url raiz . Parametro de requisição . Realizador de busca de parâmentros

    // Caso também possa fazer mais do que uma é so continuar dessa maneira @RequestParam("nome") String nome , @RequestParam("preco") Double preco
    @GetMapping
    public List<Produto> buscar(@RequestParam("nome") String nome){
        return produtoRepository.findByNome(nome);
    }


    /*@PostMapping
    public void Produto enviarDadosSemVoid(){@RequestBody Produto produto}{
        System.out.println("Produto Recebido: " + produto);
    } */

}