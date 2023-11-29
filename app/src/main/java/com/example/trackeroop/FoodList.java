package com.example.trackeroop;

public abstract class FoodList {
    private String foodName;
    private double calories;

    public FoodList(String foodName, double calories) {
        this.foodName = foodName;
        this.calories = calories;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public abstract String getDetails();
}
