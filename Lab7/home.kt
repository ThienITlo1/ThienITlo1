package com.example.kotlin.Lab7

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kotlin.R

@Composable
fun home(navController: NavController){

    var text by remember {
        mutableStateOf("")
    }
    data class product(val id: Int, val img: Int, var name: String)
    val list1 = remember {
        mutableStateListOf(
            product ( 1, R.drawable.potato,"Potato"),
            product ( 2, R.drawable.carrot,"Carrot"),
            product ( 3, R.drawable.onion,"Onion"),
        )
    }
    val list2 = remember {
        mutableStateListOf(
            product ( 1, R.drawable.rice,"Rice"),
            product ( 2, R.drawable.buckwheat,"Buckwheat"),
            product ( 3, R.drawable.cous_cous,"Сous Сous"),
        )
    }
    val list3 = remember {
        mutableStateListOf(
            product ( 1, R.drawable.rug,"Rug"),
            product ( 2, R.drawable.screwdriver,"Screwdriver"),
            product ( 3, R.drawable.towels,"Towels"),
        )
    }

    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 20.dp, start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(text = "Your city")
            Row {
                Image(
                    painter = painterResource(R.drawable.location),
                    contentDescription = null,
                    modifier = Modifier
                        .width(25.dp)
                        .height(25.dp)
                )
                Text(
                    text = "Tallin",
                    modifier = Modifier
                        .width(50.dp)
                        .align(Alignment.CenterVertically),
                    //horizontalAlignment = Alignment.CenterHorizontally
                    //verti
                )
                Image(
                    painter = painterResource(R.drawable.mui_tien_xuong),
                    contentDescription = null

                )
            }
        }

        //search
        TextField(
            value = text,
            onValueChange = { text = it },
            placeholder = { Text(text = "Search") },
            modifier = Modifier
                .width(350.dp)
                .height(60.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color(0x008FD776),/// trong suoi
                unfocusedIndicatorColor = Color(0x008FD776),/// trong suoi
            ),
            shape = RoundedCornerShape(40.dp),
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "icon search",
                    modifier = Modifier.size(24.dp)
                )
            }
        )

        //list 1
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "Vegetables",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
            Image(
                painter = painterResource(id = R.drawable.icon_next),
                contentDescription = "icon next",
                modifier = Modifier.size(30.dp)
            )
        }
        LazyRow() {
            itemsIndexed (list1) { index,item ->
                Card(modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp)
                    .width(140.dp)
                    .height(100.dp)
                    .clickable {
//                            Toast
//                                .makeText(context, "Tên: " + item.tenNV, Toast.LENGTH_SHORT)
//                                .show()
                    },
                    colors = CardDefaults. cardColors(
                        containerColor  = Color(0xFFE3F5DD)
                    ),
                ){

                    Box() {
                        Image(
                            painter = painterResource(id = item.img),
                            contentDescription = "",
                            modifier = Modifier
                                .fillMaxSize(),
                            contentScale = ContentScale.FillBounds
                        )
                        Text(
                            text = item.name.toString(),
                            modifier = Modifier
                                .padding(start = 10.dp, top = 5.dp),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }

                }
            }
        }

        //list 2
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "Grocery",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
            Image(
                painter = painterResource(id = R.drawable.icon_next),
                contentDescription = "icon next",
                modifier = Modifier.size(30.dp)
            )
        }
        LazyRow() {
            itemsIndexed (list2) { index,item ->
                Card(modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp)
                    .width(140.dp)
                    .height(100.dp)
                    .clickable {
//                            Toast
//                                .makeText(context, "Tên: " + item.tenNV, Toast.LENGTH_SHORT)
//                                .show()
                    },
                    colors = CardDefaults. cardColors(
                        containerColor  = Color(0xFFE3F5DD)
                    ),
                ){

                    Box() {
                        Image(
                            painter = painterResource(id = item.img),
                            contentDescription = "",
                            modifier = Modifier
                                .fillMaxSize(),
                            contentScale = ContentScale.FillBounds
                        )
                        Text(
                            text = item.name.toString(),
                            modifier = Modifier
                                .padding(start = 10.dp, top = 5.dp),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }

                }
            }
        }

        //list 3
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "For home",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
            Image(
                painter = painterResource(id = R.drawable.icon_next),
                contentDescription = "icon next",
                modifier = Modifier.size(30.dp)
            )
        }
        LazyRow() {
            itemsIndexed (list3) { index,item ->
                Card(modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp)
                    .width(140.dp)
                    .height(100.dp)
                    .clickable {
//                            Toast
//                                .makeText(context, "Tên: " + item.tenNV, Toast.LENGTH_SHORT)
//                                .show()
                    },
                    colors = CardDefaults. cardColors(
                        containerColor  = Color(0xFFE3F5DD)
                    ),
                ){

                    Box(modifier = Modifier.fillMaxSize()) {
                        Image(
                            painter = painterResource(id = item.img),
                            contentDescription = "",
                            modifier = Modifier
                                .fillMaxSize(),
                            contentScale = ContentScale.FillBounds
                        )
                        Text(
                            text = item.name.toString(),
                            modifier = Modifier
                                .padding(start = 10.dp, top = 5.dp),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }

                }
            }
        }

        //list 1
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "Vegetables",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
            Image(
                painter = painterResource(id = R.drawable.icon_next),
                contentDescription = "icon next",
                modifier = Modifier.size(30.dp)
            )
        }
        LazyRow() {
            itemsIndexed (list1) { index,item ->
                Card(modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp)
                    .width(140.dp)
                    .height(100.dp)
                    .clickable {
//                            Toast
//                                .makeText(context, "Tên: " + item.tenNV, Toast.LENGTH_SHORT)
//                                .show()
                    },
                    colors = CardDefaults. cardColors(
                        containerColor  = Color(0xFFE3F5DD)
                    ),
                ){

                    Box(modifier = Modifier.fillMaxSize()) {
                        Image(
                            painter = painterResource(id = item.img),
                            contentDescription = "",
                            modifier = Modifier
                                .fillMaxSize(),
                            contentScale = ContentScale.FillBounds
                        )
                        Text(
                            text = item.name.toString(),
                            modifier = Modifier
                                .padding(start = 10.dp, top = 5.dp),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }

                }
            }
        }


        }
    }