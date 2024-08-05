package com.example.receptstest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.receptstest.Presentation.CategoryListItem
import com.example.receptstest.Presentation.CategoryListScreen
import com.example.receptstest.Presentation.MealScreen
import com.example.receptstest.Presentation.Screen
import com.example.receptstest.domain.model.Category
import com.example.receptstest.ui.theme.ReceptsTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReceptsTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.CategoryListScreen.route
                    ){
                        composable(
                            route = Screen.CategoryListScreen.route
                        ){
                            CategoryListScreen(navController)
                        }
                        composable(
                            route = Screen.MealScreen.route + "/{strCategory}"//tuk sushto propsukam /
                        ){
                            MealScreen()
                        }

                    }
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ReceptsTestTheme {
        Greeting("Android")
    }
}