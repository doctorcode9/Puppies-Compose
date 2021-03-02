package com.example.puppyadoptionapp.data

import com.example.puppyadoptionapp.R

data class DogData(
    val id:Int,
    val name:String,
    val sex:String,
    val age: Int,
    val weight: Double,
    val imagePath: Int,
)


var DogsList = mutableListOf<DogData>(
    DogData(0,"Bobby","Male",2,1.3, R.drawable.puppy1),
    DogData(1,"Leia","Female",1,1.1, R.drawable.puppy2),
    DogData(2,"Rex","Male",4,3.0, R.drawable.puppy3),
    DogData(3,"Melo","Male",2,1.1, R.drawable.puppy4),
    DogData(4,"Shuya","Male",1,2.8, R.drawable.puppy5),
    DogData(5,"Maki","Female",1,1.8, R.drawable.puppy6),
    DogData(6,"Kiba","Male",2,1.0, R.drawable.puppy7),
    DogData(7,"Kurama","Male",2,1.0, R.drawable.puppy8),
)