package com.example.trackeroop;

import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DialogUtil {

    public interface AddFoodListener {
        void onAddFood(String foodName, double calories);
    }

    public static void openAddFoodDialog(Context context, AddFoodListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView = inflater.inflate(R.layout.activity_add_food, null);

        EditText editTextFoodName = dialogView.findViewById(R.id.et_foodName);
        EditText editTextCalories = dialogView.findViewById(R.id.et_calories);

        builder.setView(dialogView)
                .setTitle("Add Food")
                .setPositiveButton("Add", (dialogInterface, i) -> {
                    String foodName = editTextFoodName.getText().toString().trim();
                    String caloriesText = editTextCalories.getText().toString().trim();

                    if(TextUtils.isEmpty(foodName) || TextUtils.isEmpty(caloriesText)) {
                        Toast.makeText(context, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
                    }else {
                        double calories = Double.parseDouble(caloriesText);

                        if(listener != null) {
                            listener.onAddFood(foodName, calories);
                        }
                    }

                })
                .setNegativeButton("Cancel", (dialogInterface, i) -> dialogInterface.cancel());

        builder.create().show();
    }
}
