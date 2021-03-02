package com.example.puppyadoptionapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.puppyadoptionapp.data.DogsList
import com.example.puppyadoptionapp.screens.DetailsScreen
import com.example.puppyadoptionapp.screens.HomeScreen
import com.example.puppyadoptionapp.ui.theme.PuppyAdoptionAppTheme

class MainActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PuppyAdoptionAppTheme() {
                MyApp()
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun MyApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "HomeScreen"){
        composable("HomeScreen"){
            HomeScreen(navController)
        }
        composable("DetailsScreen/{dogIndex}",arguments = listOf(navArgument("dogIndex"){ type = NavType.IntType })){
            val dogIndex = it.arguments?.getInt("dogIndex") ?: 0
            DetailsScreen(navController, DogsList[dogIndex])
        }
    }

}

