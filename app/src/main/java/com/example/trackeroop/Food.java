package com.example.trackeroop;

public class Food extends FoodList {
    public Food(String foodName, double calories) {
        super(foodName, calories);
    }

    @Override
    public String getDetails() {
        return "Food name: " + getFoodName() + "\nCalories: " + getCalories();
    }

    @Override
    public String toString() {
        return getDetails();
    }
}
