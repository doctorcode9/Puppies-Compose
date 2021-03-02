package com.example.puppyadoptionapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.puppyadoptionapp.R
import com.example.puppyadoptionapp.data.DogData
import com.example.puppyadoptionapp.ui.theme.Purple500

@Composable
fun DetailsScreen(navController: NavController,dogData: DogData){
    Scaffold(
        //define the top bar
    topBar = {
        TopAppBar(
            navigationIcon = { IconButton(onClick = { navController.popBackStack() }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription =  null, tint = Purple500)
            }},
            title = { Text("PUPPIES 🐕",textAlign = TextAlign.Center,modifier = Modifier.fillMaxWidth(),style = MaterialTheme.typography.h5) },
            actions = { IconButton(onClick = { /*TODO*/ }) { Icon(imageVector = Icons.Filled.Favorite, contentDescription =null,tint = Purple500) }},
            modifier = Modifier.height(68.dp),
            backgroundColor = Color.White,
            elevation = 0.dp
            )
    },
        //Defining the Bottom bar content
    bottomBar = {
        Row(Modifier.padding(16.dp)){
            Button(onClick = { /*TODO*/ },
                Modifier
                    .fillMaxWidth()
                    .height(53.dp)) {
                Text("Adopt Me",style = MaterialTheme.typography.h5)
            }

        }
    }
    ) { innerPadding ->
    BodyContent(Modifier.padding(16.dp),dogs = dogData)
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier, dogs:DogData){
    Column(modifier = modifier) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(color = Color.Gray),
            Alignment.Center){
            Image(painter = painterResource(id = dogs.imagePath) , contentDescription = null,contentScale = ContentScale.Crop,modifier = Modifier.fillMaxSize())

        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(dogs.name, style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(12.dp))
        Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceAround) {
            val mod = Modifier
                .border(1.dp, Color(0xffd5d5d5), shape = RoundedCornerShape(4.dp))
                .padding(vertical = 8.dp)
                .weight(1f)
            DetailsBox(title = "Sex", info = "${dogs.sex}",mod)
            Spacer(modifier = Modifier.width(4.dp))
            DetailsBox(title = "Age", info = "${dogs.age} year",mod)
            Spacer(modifier = Modifier.width(4.dp))
            DetailsBox(title = "Weight", info = "${dogs.weight} Kg",mod)

        }
        Spacer(modifier = Modifier.height(12.dp))
        Text("Summary :", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(4.dp))
        Text("This is the most beautiful dog that you've ever seen in your life 💜",style = MaterialTheme.typography.body1,color = Color(0xff515151),fontStyle = FontStyle.Italic)
    }
}


//Creating the details Box
@Composable
fun DetailsBox(title:String, info:String, modifier: Modifier = Modifier){
    Box(modifier = modifier)
        {
        Column() {
            Text(title,Modifier.fillMaxWidth(),textAlign = TextAlign.Center)
            Text(info,Modifier.fillMaxWidth(),textAlign = TextAlign.Center)
        }
    }
}