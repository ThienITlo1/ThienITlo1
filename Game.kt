package com.example.kotlin

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlin.ui.theme.KotlinTheme

class Game : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    game()

                }
            }
        }
    }
}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun game() {
    val context = LocalContext.current
    data class item_game(val id: Int, val img: Int, val name: String, var isVisible: Boolean = true)

    var list = remember {
        mutableStateListOf(
            item_game(1, R.drawable.abc, "ngôi sao"),
            item_game(2, R.drawable.cuccung, "ngôi sao"),
            item_game(1, R.drawable.abc, "ngôi sao"),
            item_game(3, R.drawable.i, "ngôi sao"),
            item_game(3, R.drawable.i, "ngôi sao"),
            item_game(2, R.drawable.cuccung, "ngôi sao"),
            item_game(4, R.drawable.capu1, "ngôi sao"),
            item_game(4, R.drawable.capu1, "ngôi sao"),

            )
    }

    var lan1 by remember { mutableStateOf(-1) }
    var lan2 by remember { mutableStateOf(-1) }
    var lannhan by remember { mutableStateOf(0) }



    fun check(){
        if(lan1 != -1 && lan2 !=-1){
            if(list[lan1].id == list[lan2].id){
                Toast.makeText(context,"bạn chọn đúng",Toast.LENGTH_SHORT).show()
                list[lan1] = list[lan1].copy(isVisible = false)
                list[lan2] = list[lan2].copy(isVisible = false)
            }else{
                Toast.makeText(context,"bạn chọn sai",Toast.LENGTH_SHORT).show()
            }
            lan1 = -1
            lan2 = -1
            lannhan = 0

        }
    }


    Column {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(list) { index, item ->
                Card(
                    modifier = Modifier
                        .size(width = 100.dp, height = 100.dp)
                        .background(color = Color.White)
                        .clickable(enabled = item.isVisible) {
                            when (lannhan) {
                                0 -> {
                                    lan1 = index
                                    lannhan++
                                }
                                1 -> {
                                    lan2 = index
                                    lannhan++
                                    check()
                                }
                            }
                        }
                ) {
                    if (item.isVisible) {
                        Column(modifier = Modifier.fillMaxSize().background(color = Color.Black)) {
                            Image(
                                painter = painterResource(item.img),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.size(50.dp).align(Alignment.CenterHorizontally)
                            )
                            Text(
                                text = item.name,
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            )
                        }
                    } else {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.White)
                        )
                    }
                }
            }
        }
    }
}