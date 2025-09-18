package com.apiprodutos.apideproduto.controller;


import com.apiprodutos.apideproduto.model.Produto;
import org.springframework.web.bind.annotation.*;

@RestController // Essa anotation avisa que essa classe vai receber requisições Rest
@RequestMapping("/produtos")
public class ProdutoController {

    /* Caso eu queira receber em toString()
     @PostMapping
     public void enviarDados(@RequestBody Produto produto){
        System.out.println("Produto recebido: " + produto);
        }
*/

    // Caso eu queria retornar e receber em Json . Ou monstrar no Postman
     @PostMapping
       public Produto salvar(@RequestBody Produto produto){
        System.out.println("Produto recebido: " + produto);
        return produto;
    }


}