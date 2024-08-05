package com.example.receptstest.Presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.receptstest.domain.model.Category
import com.example.receptstest.domain.model.Meal

@Composable
fun MealItem(
    meal: Meal
    // onItemClick: (Category) -> Unit ; Tva da go opravq kato imam drug ekran kum koito da me vodi

) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            //.clickable { (onItemClick(category)) }
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "${meal.idMeal} ${meal.strMeal}",
            style = MaterialTheme.typography.bodyMedium, // Използване на правилния стил от Material3
            modifier = Modifier.padding(start = 6.dp),
            //fontSize = 15.sp
        )
        Image(
            painter = rememberImagePainter(data = meal.strMealThumb),
            contentDescription = meal.strMeal,
            modifier = Modifier.size(64.dp),
            contentScale = ContentScale.Crop
        )


    }
}
