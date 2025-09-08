package dev.java10x.Fridge.service;

import dev.java10x.Fridge.model.Food;
import dev.java10x.Fridge.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;
// Aqui fazemos as regras . Quem se conecta com banco de dados é repository
// JPA se conecta com Banco de dados
// Regras de salvar que vem do CRUD repository do JPA
@Service
public class FoodService {


    private final FoodRepository foodRepository;
    // Aqui tenho todos os métodos direto do JPA . Ele deleta salva encontra TUDO !
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    // Aparece todos os comandos de JPA . Pego todos e Listo
    public List<Food> getAll() { return  foodRepository.findAll();}

    // Criar
    public Food save(Food food) {return foodRepository.save(food);}

    // Deletar . Tem que passar id se não vai deletar tudo
    public void delete(Long id) {foodRepository.deleteById(id);}
}
