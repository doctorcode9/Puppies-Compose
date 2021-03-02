package com.example.puppyadoptionapp.screens

import android.widget.Space
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import com.example.puppyadoptionapp.R
import com.example.puppyadoptionapp.data.DogData
import com.example.puppyadoptionapp.data.DogsList


@ExperimentalFoundationApi
@Composable
fun HomeScreen(navController: NavController){
    Scaffold(
        topBar = {
            AppHeader()
        }
    ) {
        HomeBody(Modifier.padding(16.dp),onCardClicked = {pet ->
            navController.navigate("DetailsScreen/${pet.id}")

        })

    }
}


@ExperimentalFoundationApi
@Composable
fun HomeBody(modifier: Modifier = Modifier, onCardClicked: (DogData) -> Unit){
    Column(modifier = modifier) {
        Text(text = "Our Puppies List 🐶",style = MaterialTheme.typography.h5,fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        LazyVerticalGrid(cells = GridCells.Fixed(2), content = {

            items(DogsList.size) {
                item -> PetCardGrid(DogsList[item], onCardClicked)
            }
        })
    }

}


@Composable
fun AppHeader(){
    Column(Modifier.padding(16.dp)) {
        var textFieldValue = remember { mutableStateOf<String>("")}
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = null,modifier = Modifier.size(50.dp))
        Spacer(Modifier.height(10.dp))
        Text(
            "Find your next best friend",
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Black,
            modifier = Modifier
                .fillMaxWidth(0.7f)

        )
        Spacer(Modifier.height(24.dp))
        TextField(
            value = textFieldValue.value,
            onValueChange = { value -> textFieldValue.value = value },
            Modifier
                .fillMaxWidth()
                .background(color = Color.Transparent)
                .border(1.dp, Color(0x22212121), shape = RoundedCornerShape(8.dp))
                ,
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
            placeholder = {Text("Search for your favorite Pet ")},
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                textColor = MaterialTheme.colors.primary,
                leadingIconColor = MaterialTheme.colors.primary
            ),
            textStyle = TextStyle(
                fontSize = 20.sp,

            )

        )

    }
}

@Composable
fun PetCardGrid(dogs:DogData, onCardClicked: (DogData) -> Unit){
    Box(
        Modifier
            .padding(4.dp)
            .border(1.dp, Color(0x22212121), shape = RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .clickable(enabled = true, onClick = { onCardClicked(dogs) })
    ){

        Column(Modifier.padding(8.dp)) {
            //Setting up the Images
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .clip(shape = RoundedCornerShape(4.dp))
                    .background(color = Color.Gray),
                Alignment.Center){
                Image(painter = painterResource(id = dogs.imagePath) , contentDescription = null,contentScale = ContentScale.Crop,modifier = Modifier.fillMaxSize())

            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(dogs.name, style = TextStyle(color = Color(0xff212121),fontWeight = FontWeight.Bold,fontSize = 22.sp))
            petDetail(age = dogs.age, weight = dogs.weight)
        }
    }
}

@Composable
fun petDetail(age:Int,weight: Double){
    Row(horizontalArrangement = Arrangement.SpaceBetween){
        Column(

            Modifier
                .weight(1F)
                .align(Alignment.CenterVertically)){
            val year = if(age>1) "Years" else "Year"
            Text("Age", style = TextStyle(
                color = Color(0xaa212121)
            ),
                textAlign = TextAlign.Center
                )
            Text("$age $year",textAlign = TextAlign.Center)
        }
        Column(
            Modifier
                .weight(1F)
                .align(Alignment.CenterVertically)){

            Text("Weight", style = TextStyle(
                color = Color(0xaa212121)
            ),textAlign = TextAlign.Center)
            Text("$age Kg",textAlign = TextAlign.Center)
        }

    }
}

@ExperimentalFoundationApi
@Preview(showSystemUi = true)
@Composable
fun appPreview(){
    Column() {
        AppHeader()
        HomeBody(onCardClicked = {})
    }
}