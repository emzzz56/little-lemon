package com.emz.littlelemon

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.edit
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Profile(navController: NavController){
    val context = LocalContext.current
    val sharedPreferences by lazy {
        context.getSharedPreferences("LittleLemon", Context.MODE_PRIVATE)
    }
    val firstName = MutableLiveData<String>()
    val lastName = MutableLiveData<String>()
    val email = MutableLiveData<String>()

    firstName.value = sharedPreferences.getString("firstName", "")
    lastName.value = sharedPreferences.getString("lastName", "")
    email.value = sharedPreferences.getString("email", "")
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth(1f)
            .background(Color.White)
            .padding(top = 20.dp, bottom = 20.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Little Lemon",
            Modifier
                .width(150.dp)
                .padding(top = 20.dp, bottom = 20.dp),
            contentScale = ContentScale.FillWidth
        )
        Column (
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Personal Information",
                textAlign = TextAlign.Start,
                fontSize = 18.sp,
            )
        }
        Column (
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ){
            Text(
                text = "First name",
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Text(text = firstName.value.toString())
            Row (modifier = Modifier.padding(vertical = 15.dp)){
            }
            Text(
                text = "Last name",
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Text(text = lastName.value.toString())
            Row (modifier = Modifier.padding(vertical = 15.dp)){
            }
            Text(
                text = "Email",
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Text(text = email.value.toString())
            Row (modifier = Modifier.padding(vertical = 15.dp)){
            }
            Button(onClick = {
                sharedPreferences.edit(commit = true){
                    putString("firstName", "")
                    putString("lastName", "")
                    putString("email", "")
                }
                navController.navigate("onBoarding")
            },
                modifier = Modifier.fillMaxWidth(1f),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFF4CE14)
                )
            ) {
                Text(text = "Log out", color = Color.Black)
            }
        }
    }
}


@Preview()
@Composable
fun ProfilePreview(){
    Profile(rememberNavController())
}