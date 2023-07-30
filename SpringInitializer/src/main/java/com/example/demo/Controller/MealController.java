package com.example.demo.Controller;
import com.example.demo.Entities.Meal;
import com.example.demo.Services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/meal")
public class MealController {

    private MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("/get-meal")
    public ResponseEntity<List<Meal>> getMeals() {
        List<Meal> meals = mealService.getMeals();
        return ResponseEntity.ok(meals);
    }

    @PostMapping(value = "/add-meal")
    public ResponseEntity<String> postMeal(@RequestBody Meal meal) {
        mealService.addMeal(meal);
        return ResponseEntity.ok("Added new Meal");
    }

    @PutMapping("/put/update-meal")
    public ResponseEntity<String> putMeal(@RequestBody Meal meal) {
        mealService.updateMeal(meal);
        return ResponseEntity.ok("Updated");
    }

    @DeleteMapping("/delete-meal/{mealName}")
    public ResponseEntity<String> deleteMeal(@PathVariable("mealName") String mealName) {
        mealService.deleteMeal(mealName);
        return ResponseEntity.ok("Deleted Meal");
    }
}