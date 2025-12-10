package io.github.JoaoDoJava21.libraryapi3.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Driver;

@Configuration
public class DatabaseConfiguration {


    @Value("${spring.datasource.url}")
    String url;

    @Value("${spring.datasource.username}")
    String username;

    @Value("${spring.datasource.password}")
    String password;

    @Value("${spring.datasource.driver-class-name}")
    String driver;


    // Fonte de dados . Onde vai ler as propriedades do Application.yml
    // Com isso já consigo conectar e criar o nosso JpaRepository e fazer as operações na base de dados
    // Esse aqui é um Datasource Simples , não é recomendado em usar em produção , ele pode quebrar se tiver muitos usuários ficando lento
    // O nosso padrão é o HikariDatasource , ele permite que a gente crie um pool de conexões

//    @Bean
//    public DataSource dataSource(){
//        DriverManagerDataSource ds = new DriverManagerDataSource();
//
//        ds.setUrl(url);
//        ds.setUsername(username);
//        ds.setPassword(password);
//        ds.setDriverClassName(driver);
//
//        return ds;
//    }

    // ===================== APLICAÇÃO PADRÃO =====================

    // Hikari já vem por padrão com a JPA , não precisa adicionar essa depêndencia
    @Bean
    public DataSource hikariDataSource(){

        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driver);


        // Qual o máximo de pool de conexões? , Aqui ele vai liberar no máximo 10 pool de conexões ,depende do quanto precisar
        config.setMaximumPoolSize(10);

        // Minimo que vai ser liberado desde o inicio  , tamanho inicial do pool
        config.setMinimumIdle(1);

        // Nome da pool , isso é opcional
        config.setPoolName("library-db-pool");

        // Quanto tempo ele vai durar a conexão da pool . Observar a documentação do HikariCP Connection pool. Lá mostra como configurar
        // Sendo colocado em milisegundo , onde o padrão é 30 minutos . Mas a baixo irei inserir 10 minutos . Depois de 10 minutos ela para a conexão
        config.setMaximumPoolSize(600000);

        // Ele é o tempo que ele vai obter uma conexão que ele vai gastar para obter ela , tipo se ele demorar mais que o tempo colocado ele vai dar um erro
        // Irei colocar 100000 ms <- 1 minuto e 66 , se passar disso ele vai dar erro
        config.setConnectionTimeout(100000);

        // Aqui eu executo uma querry para verificar se o banco está conectado , Retorna 1 , só para testar se o banco está funcionando
        config.setConnectionTestQuery("select 1");



        return new HikariDataSource(config);
    }

}
