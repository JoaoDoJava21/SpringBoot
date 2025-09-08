package dev.java10x.Fridge.repository;

import dev.java10x.Fridge.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;


// Todos as querrys de CRUD já vem pronta . Só transformar o FoodRepository em interface e extender ao JPA
public interface FoodRepository extends JpaRepository<Food,Long> {


}
