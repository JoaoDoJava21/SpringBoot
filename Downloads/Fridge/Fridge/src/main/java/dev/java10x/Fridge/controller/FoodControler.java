package dev.java10x.Fridge.controller;


// Sempre anotar para que serve esse código
// Dominio só vem com deploy então fiz no LocalHost com H2

import dev.java10x.Fridge.model.Food;
import dev.java10x.Fridge.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Passador de rodas para seguir "Tipo entra nessa rota aqui ou na outra porta"
@RequestMapping("/food") // Mapea as rotas do controller
public class FoodControler {

    // Injenção de dependencia
    @Autowired
    private final FoodService service;

    public FoodControler(FoodService service) {
        this.service = service;
    }

    // Requisições
    // GET
    // POST
    // PUT
    // DELETE
    @GetMapping  // Listagem (" Lista todas as comidas que eu cadastrar ") PEGAR
    public List<Food> getAll() {return service.getAll();}

    @PostMapping //Para fazer requisição do tipo post para mandar para o servidor , ENVIAR
    // Create tem que ter nome , Data de expiração , Quantidade do produto.
    // Request Pede os parametros
    public Food create(@RequestBody Food food) {return service.save(food); }

}
