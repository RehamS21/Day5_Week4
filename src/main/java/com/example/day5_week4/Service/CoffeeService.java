package com.example.day5_week4.Service;

import com.example.day5_week4.Api.ApiException;
import com.example.day5_week4.Model.Coffee;
import com.example.day5_week4.Repository.CoffeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    public List<Coffee> getAllCoffee(){
        return coffeeRepository.findAll();
    }

    public void addCoffee(Coffee coffee){
        coffeeRepository.save(coffee);
    }

    public void updateCoffee(Integer id , Coffee coffee){
        Coffee oldCoffee = coffeeRepository.findCoffeeById(id);

        if(oldCoffee == null)
            throw new ApiException("Coffee id is wrong");

        oldCoffee.setName(coffee.getName());
        oldCoffee.setCategory(coffee.getCategory());
        oldCoffee.setPrice(coffee.getPrice());


        coffeeRepository.save(oldCoffee);

    }
    public void deleteCoffee(Integer id){
        Coffee deleteCoffee = coffeeRepository.findCoffeeById(id);

        if (deleteCoffee == null)
            throw new ApiException("Coffee not found");

        coffeeRepository.delete(deleteCoffee);

    }

    public Coffee getCoffeeById(Integer id){
        Coffee coffee = coffeeRepository.findCoffeeById(id);

        if (coffee == null)
            throw new ApiException("Coffee not found");

        return coffee;
    }

    public List<Coffee> getAllCategory(String category){
        List<Coffee> categoryList = coffeeRepository.findCoffeeByCategory(category);

        if (categoryList.isEmpty())
            throw new ApiException("Sorry, list of coffee not found");

        return categoryList;
    }
}
