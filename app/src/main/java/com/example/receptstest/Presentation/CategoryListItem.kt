package com.example.receptstest.Presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.receptstest.domain.model.Category
import com.example.receptstest.ui.theme.ReceptsTestTheme

@Composable
fun CategoryListItem(
    category:Category,
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
            text = "${category.idCategory} ${category.strCategory}",
            style = MaterialTheme.typography.bodyMedium, // Използване на правилния стил от Material3
            modifier = Modifier.padding(start = 6.dp),
            //fontSize = 15.sp
        )
        Image(
            painter = rememberImagePainter(data = category.strCategoryThumb),
            contentDescription = category.strCategory,
            modifier = Modifier.size(64.dp),
            contentScale = ContentScale.Crop
        )


    }
}

/*
@Preview(showBackground = true)
@Composable

fun PreviewCategoryListItem(){
    ReceptsTestTheme() {
        CategoryListItem(
            category = Category(
                idCategory = "1",
                strCategory = "Beef",
                strCategoryThumb = "https://www.themealdb.com/images/category/beef.png",
            ),

            onItemClick = {nom}
        )
    }
}*/
