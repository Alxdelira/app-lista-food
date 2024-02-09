package com.example.appdeinventario

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.appdeinventario.list_item.FoodItem
import com.example.appdeinventario.model.Food

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodList()
        }
    }
}

@Composable
private fun FoodList() {

    val foodList: MutableList<Food> = mutableListOf(
        Food(
            imgFood = R.drawable.food1,
            foodName = "Food 1",
            foodDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut.",
            price = "$ 120.00"

        ),
        Food(
            imgFood = R.drawable.food2,
            foodName = "Food 1",
            foodDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut.",
            price = "$ 100.00"

        ),
        Food(
            imgFood = R.drawable.food3,
            foodName = "Food 1",
            foodDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut.",
            price = "$ 20.00"

        ),
        Food(
            imgFood = R.drawable.food4,
            foodName = "Food 1",
            foodDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut.",
            price = "$ 160.00"

        ),
        Food(
            imgFood = R.drawable.food5,
            foodName = "Food 1",
            foodDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut.",
            price = "$ 65.00"

        ),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        LazyColumn {
            itemsIndexed(foodList) { _, food ->
                FoodItem(food)
            }
        }
    }
}