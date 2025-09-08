package dev.java10x.Fridge.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;


// Ele vai dizer que essa classe vai ser persistida lá na camada de repository
// Que vai se conectar com  Banco de Dados
@Entity // <- Entity Cria tabela no banco de dados com colunas
@Table(name = "food_table") // Indica qual vai ser o nome da tabela
public class Food {

    @Id // Vai ser gerado automaticamente quando fizer uma requisição > Próprio Java vai cuidar disso
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* Passa uma estratégia para gerar Id
    Toda vez que eu adicionar uma nova comida ela vai partir do numero 1 . Vai ser sequencial */
    private Long id ;
    private String name ;
    private LocalDateTime expiritionDate ;
    private Integer quantity ;

    public Food(){

    }

    public Food(LocalDateTime expiritionDate, Long id, String name, Integer quantity) {
        this.expiritionDate = expiritionDate;
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public LocalDateTime getExpiritionDate() {
        return expiritionDate;
    }

    public void setExpiritionDate(LocalDateTime expiritionDate) {
        this.expiritionDate = expiritionDate;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
