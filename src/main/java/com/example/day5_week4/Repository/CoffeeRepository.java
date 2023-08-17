package com.example.day5_week4.Repository;


import com.example.day5_week4.Model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee,Integer> {

    Coffee findCoffeeById(Integer id);

    List<Coffee> findCoffeeByCategory(String category);


    // JPQL
    @Query("select c from Coffee c where c.id = ?1")
    Coffee pleaseGetByIdForMe(Integer id);
}
