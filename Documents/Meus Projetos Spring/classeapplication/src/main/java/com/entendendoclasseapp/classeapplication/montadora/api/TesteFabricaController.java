package com.entendendoclasseapp.classeapplication.montadora.api;


import com.entendendoclasseapp.classeapplication.montadora.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carros")
public class TesteFabricaController {

    @Autowired // Ela diz o Spring va lá no seu conteiner e me de uma instância de motor para eu injetar aqui para que eu possa utilizar
    private Motor motor;

    @PostMapping
    public CarroStatus iniciarCarro(@RequestBody Chave chave){

        var carro = new HondaHRV(motor);  // Ele precisa de um motor
        return carro.darIgnicao(chave);
    }


}
