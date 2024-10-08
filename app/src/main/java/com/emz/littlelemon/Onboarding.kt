package com.emz.littlelemon

import android.content.Context.MODE_PRIVATE
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
import androidx.lifecycle.MutableLiveData
import androidx.core.content.edit
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun onBoarding(navController: NavController){
    val context = LocalContext.current
    val sharedPreferences by lazy {
        context.getSharedPreferences("LittleLemon", MODE_PRIVATE)
    }
    var firstName by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var lastName by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var email by remember {
        mutableStateOf(TextFieldValue(""))
    }
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
            modifier = Modifier
                .background(Color(0xFF485E57))
                .padding(20.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Let's get to know you",
                color = Color.White,
                fontSize = 24.sp,
            )
        }
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
            TextField(
                value = firstName,
                onValueChange = {
                    firstName = it
                },
                textStyle = TextStyle(fontSize = 10.sp),
                modifier = Modifier
                    .border(1.dp, Color.Gray, shape = RoundedCornerShape(4.dp))
                    .padding(vertical = 0.dp)
                    .fillMaxWidth()
                    .height(40.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White
                ),
            )
            Row (modifier = Modifier.padding(vertical = 15.dp)){
            }
            Text(
                text = "Last name",
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            TextField(
                value = lastName,
                onValueChange = {lastName = it},
                textStyle = TextStyle(fontSize = 10.sp),
                modifier = Modifier
                    .border(1.dp, Color.Gray, shape = RoundedCornerShape(4.dp))
                    .padding(vertical = 0.dp)
                    .fillMaxWidth()
                    .height(40.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White
                ),
            )
            Row (modifier = Modifier.padding(vertical = 15.dp)){
            }
            Text(
                text = "Email",
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            TextField(
                value = email,
                onValueChange = {email = it},
                textStyle = TextStyle(fontSize = 10.sp),
                modifier = Modifier
                    .border(1.dp, Color.Gray, shape = RoundedCornerShape(4.dp))
                    .padding(vertical = 0.dp)
                    .fillMaxWidth()
                    .height(40.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White
                ),
            )
            Row (modifier = Modifier.padding(vertical = 15.dp)){
            }
            Button(onClick = {
                if (firstName.text.isBlank() || lastName.text.isBlank() || email.text.isBlank()){
                    Toast.makeText(context, "Registration unsuccessful. Please enter all data.", Toast.LENGTH_LONG).show()
                } else {
                    sharedPreferences.edit(commit = true){
                        putString("firstName", firstName.text)
                        putString("lastName", lastName.text)
                        putString("email", email.text)
                    }
                    Toast.makeText(context, "Registration successful!", Toast.LENGTH_LONG).show()
                    navController.navigate(Home.route)
                }
            },
                modifier = Modifier.fillMaxWidth(1f),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFF4CE14)
                )
                ) {
                Text(text = "Register", color = Color.Black)
            }
        }
    }
}

@Preview()
@Composable
fun onBoardingPreview(){
    onBoarding(rememberNavController())
}