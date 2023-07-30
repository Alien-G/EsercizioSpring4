package com.example.demo.Services;
import com.example.demo.DAO.MealDAO;
import com.example.demo.Entities.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class MealService {
    private MealDAO mealDao;

    @Autowired
    public MealService(MealDAO mealDao){
        this.mealDao=mealDao;
    }
    public void addMeal (Meal meal) {
        mealDao.addMeal(meal);
    }

    public void updateMeal (Meal meal) {
        mealDao.updateMeal(meal);
    }


    public void deleteMeal (String mealname) {
        mealDao.deleteMeal(mealname);
    }

    public List<Meal> getMeals(){
        return mealDao.getMeals();
    }

}