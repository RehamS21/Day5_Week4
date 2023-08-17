package com.example.day5_week4.Controller;

import com.example.day5_week4.Api.ApiResponse;
import com.example.day5_week4.Model.Coffee;
import com.example.day5_week4.Service.CoffeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api/v1/coffee")
@RequiredArgsConstructor
public class CoffeeController {
    private final CoffeeService coffeeService;

    @GetMapping("/get")
    public ResponseEntity getAllCoffees(){
        return ResponseEntity.status(200).body(coffeeService.getAllCoffee());
    }

    @PostMapping("/add")
    public ResponseEntity addNewCoffee(@RequestBody @Valid Coffee coffee){
        coffeeService.addCoffee(coffee);
        return ResponseEntity.status(200).body(new ApiResponse("New coffee added successfully"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateCoffee(@PathVariable Integer id, @RequestBody @Valid Coffee coffee){

        coffeeService.updateCoffee(id, coffee);

        return ResponseEntity.status(200).body(new ApiResponse("Updated the coffee successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCoffee(@PathVariable Integer id){
        coffeeService.deleteCoffee(id);
        return ResponseEntity.status(200).body(new ApiResponse("The coffee deleted successfully"));
    }

    @GetMapping("/oneCoffee/{id}")
    public ResponseEntity getOneCoffee(@PathVariable Integer id){

        return ResponseEntity.status(200).body(coffeeService.getCoffeeById(id));
    }

    @GetMapping("/getCategory/{category}")
    public ResponseEntity getCoffeeCategory(@PathVariable String category){
        return ResponseEntity.status(200).body(coffeeService.getAllCategory(category));
    }


}
