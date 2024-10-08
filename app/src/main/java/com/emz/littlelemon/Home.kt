package com.emz.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Home(navController: NavController){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ){
        Column(
            modifier = Modifier
                .weight(.3f)
        ){}
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(1f)
                .background(Color.White)
                .padding(top = 20.dp, bottom = 20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Little Lemon",
                Modifier
                    .width(150.dp)
                    .padding(top = 20.dp, bottom = 20.dp),
                contentScale = ContentScale.FillWidth
            )
        }
        Column (horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(.3f)
                .background(Color.White)
                .padding(top = 20.dp, bottom = 20.dp)
        ){

                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "User",
                    Modifier
                        .width(50.dp)
                        .padding(0.dp)
                        .clickable {
                            navController.navigate("Profile")
                        },
                    contentScale = ContentScale.FillWidth
                )
        }
    }
}


@Preview
@Composable
fun HomePreview(){
    Home(rememberNavController())
}