package com.entendendoclasseapp.classeapplication.montadora.configuration;

import com.entendendoclasseapp.classeapplication.montadora.Motor;
import com.entendendoclasseapp.classeapplication.montadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Anotações de Beans .  Ele vai reconhecer essa classe e vai escanear todas as classes e os filhos dele . Cria dentro de pacote para ser Escaneado
@Configuration
public class MontadoraConfiguration {

    // Cria servidor de email para que receba e coloque na aplicação

    // Vai registrar no conteiner para eu conseguir utilizar ele.
    @Bean // Para injetar ele nas dependencias . É quando você cria um objeto e ele retorna construido
    public Motor motor(){
        var motor = new Motor();
        motor.setCavalos(120);
        motor.setCilindros(4);
        motor.setModelo("XPT");
        motor.setLitragem(2.0);
        motor.setTipoMotor(TipoMotor.ASPIRADO);
        return motor;
    }


}
