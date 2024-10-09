package com.emz.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.room.Room


@Composable
fun Home(navController: NavController){
    val context = LocalContext.current
    val database by lazy {
        Room.databaseBuilder(
            context,
            MenuDatabase::class.java,
            "menu.db"
        ).build()
    }
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .weight(.3f)
            ) {}
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
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(.3f)
                    .background(Color.White)
                    .padding(top = 20.dp, bottom = 20.dp)
            ) {

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
        Row(
            modifier = Modifier
                .background(Color(0xFF495E57))
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Column {


                Row {
                    Column(
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .weight(.7f)
                            .padding(top = 20.dp, bottom = 20.dp)
                    ) {
                        Text(
                            text = "Little Lemon",
                            color = Color(0xFFE8C517),
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Chicago",
                            color = Color.White,
                            fontSize = 20.sp,
                            modifier = Modifier.padding(bottom = 20.dp)
                        )
                        Text(
                            text = "We are a family owned Mediterranean restaurant, focused on traditional recipes served with a modern twist.",
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .weight(.3f)
                            .padding(top = 20.dp, bottom = 20.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.heroimage),
                            contentDescription = "Little Lemon",
                            modifier = Modifier
                                .width(150.dp)
                                .height(120.dp)
                                .offset(y = 50.dp)
                                .clip(RoundedCornerShape(20.dp)),
                            contentScale = ContentScale.FillWidth
                        )
                    }
                }
                Row {
                    Column {
                        TextField(
                            value = "Enter Search Phrase",
                            onValueChange = {},
                            textStyle = TextStyle(fontSize = 10.sp),
                            modifier = Modifier
                                .border(1.dp, Color.Gray, shape = RoundedCornerShape(4.dp))
                                .padding(vertical = 0.dp)
                                .fillMaxWidth()
                                .height(45.dp),
                            colors = androidx.compose.material.TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.White
                            ),
                        )
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .background(Color.White)
                .padding(20.dp)
                .fillMaxSize()
        ) {
            Column () {
                Text(
                    text = "Order For Delivery!",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Row (
                    modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)
                ){
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFEDEFEE)),
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .height(30.dp)
                            .width(70.dp)
                    ) {
                        Text(text = "Starters", fontSize = 10.sp)
                    }
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFEDEFEE)),
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .height(30.dp)
                            .width(70.dp)
                    ) {
                        Text(text = "Mains", fontSize = 10.sp)
                    }
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFEDEFEE)),
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .height(30.dp)
                            .width(70.dp)
                    ) {
                        Text(text = "Desserts", fontSize = 10.sp)
                    }
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFEDEFEE)),
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .height(30.dp)
                            .width(70.dp)
                    ) {
                        Text(text = "Drinks", fontSize = 10.sp)
                    }
                }
            }
            Column {
                val menuItems by database.menuDao().getAllMenuItems()
                .observeAsState(emptyList())
                ItemsList(menuItems)
            }
        }

    }
}


@Preview
@Composable
fun HomePreview(){
    Home(rememberNavController())
}

@Composable
private fun ItemsList(menuItems: List<MenuItem>) {
    if (menuItems.isEmpty()) {
        androidx.compose.material3.Text(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp),
            text = "The menu is empty"
        )
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp)
        ) {
            items(
                items = menuItems,
                itemContent = {
                        menuItem ->
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ){
                        androidx.compose.material3.Text(menuItem.title)
                        androidx.compose.material3.Text(modifier = Modifier.weight(1f),
                            textAlign = TextAlign.Right,
                            text = "%.2f".format(menuItem.price))
                    }
                    Spacer(modifier = Modifier.width(16.dp))

                }
            )
        }
    }
}