package com.example.trackeroop;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private ArrayList<FoodList> foodList;
    private ArrayAdapter<FoodList> adapter;
    private ListView listView;
    private TextView calories;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, foodList);

        listView = findViewById(R.id.lv_foods);
        calories = findViewById(R.id.tv_calories);
        btnAdd = findViewById(R.id.btn_add);

        listView.setAdapter(adapter);

        btnAdd.setOnClickListener(this);
        listView.setOnItemClickListener(this);
    }

    private void updateCalories() {
        double totalCalories = 0.0;
        for (FoodList foodList : foodList) {
            totalCalories += foodList.getCalories();
        }
        calories.setText("Total Calories: " + totalCalories);
    }

    @Override
    public void onClick(View v) {
        if (v == btnAdd) {
            DialogUtil.openAddFoodDialog(this, (foodName, calories) -> {
                foodList.add(new Food(foodName, calories));
                adapter.notifyDataSetChanged();
                updateCalories();
            });
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (parent == listView) {
            FoodList selectedFood = foodList.get(position);
            Toast.makeText(MainActivity.this, selectedFood.getDetails(), Toast.LENGTH_SHORT).show();
        }
    }

}