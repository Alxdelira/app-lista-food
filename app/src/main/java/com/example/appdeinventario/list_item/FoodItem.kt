package com.example.appdeinventario.list_item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.appdeinventario.model.Food

@Composable
fun FoodItem(
    food: Food
) {
    val imagemFood = food.imgFood
    val foodName = food.foodName
    val foodDescription = food.foodDescription
    val price = food.price
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(0.dp, 10.dp, 0.dp, 10.dp)
    ) {
        val (imgFood, txtFoodName, txtFoodDescription, txtPrice, btAddCard, containerImg, rowItem) = createRefs()

        Card(modifier = Modifier
            .constrainAs(containerImg) {
                top.linkTo(parent.top, 0.dp)
                start.linkTo(parent.start, 0.dp)
            }
            .size(130.dp)
            .padding(20.dp), colors = CardDefaults.cardColors(
            containerColor = Color.White
        ), shape = ShapeDefaults.Medium, elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )) {

        }

        Image(painter = painterResource(imagemFood!!),
            contentDescription = null,
            modifier = Modifier
                .constrainAs(imgFood) {
                    top.linkTo(containerImg.top, 0.dp)
                    start.linkTo(containerImg.start, 0.dp)
                    end.linkTo(containerImg.end, 0.dp)
                    bottom.linkTo(containerImg.bottom, 0.dp)
                }
                .size(60.dp))

        Text(text = foodName!!,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.constrainAs(txtFoodName) {
                top.linkTo(parent.top, 30.dp)
                start.linkTo(containerImg.end, 0.dp)

            })

        Text(text = foodDescription!!,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .constrainAs(txtFoodDescription) {
                    top.linkTo(txtFoodName.bottom)
                    start.linkTo(containerImg.end)
                    end.linkTo(parent.end)
                }
                .padding(65.dp, 10.dp, 40.dp, 0.dp),
            maxLines = 3)

        Text(text = price!!,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.constrainAs(txtPrice) {
                top.linkTo(txtFoodDescription.bottom, 30.dp)
                start.linkTo(containerImg.end, 0.dp)

            })

        Button(onClick = {

        }, modifier = Modifier
            .height(45.dp)
            .constrainAs(btAddCard) {
                top.linkTo(txtFoodDescription.bottom, 10.dp)
                start.linkTo(txtPrice.end, 10.dp)
                end.linkTo(parent.end, 10.dp)
            }, colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFF44336)
        )
        ) {
            Text(
                text = "Add Card",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Row(modifier = Modifier
            .width(350.dp)
            .height(3.dp)
            .background(Color.White)
            .constrainAs(rowItem) {
                top.linkTo(txtPrice.bottom, 30.dp)
                start.linkTo(parent.start, 20.dp)
                end.linkTo(parent.end, 20.dp)
            }) {

        }
    }
}

