package com.example.kotlin.Bai_tap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin.R

class luachon : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VotingScreen()
        }
    }
}

@Composable
fun VotingScreen() {
    var VoteDocThan by remember { mutableIntStateOf(0) }
    var VoteDaCoChu by remember { mutableIntStateOf(0) }
    var VoteLGBT by remember { mutableIntStateOf(0) }

    val totalVotes = VoteDocThan + VoteDaCoChu + VoteLGBT

    val DocThan = if (totalVotes > 0) (VoteDocThan.toFloat() / totalVotes) * 100 else 0f
    val DaCoChu = if (totalVotes > 0) (VoteDaCoChu.toFloat() / totalVotes) * 100 else 0f
    val LGBT = if (totalVotes > 0) (VoteLGBT.toFloat() / totalVotes) * 100 else 0f

    val percentageTextStyle = LocalTextStyle.current.copy(fontSize = 20.sp, fontWeight = FontWeight.Bold)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bình Chọn",
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF6200EA)) // Sử dụng MaterialTheme nếu muốn đồng nhất
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Poster Image
            Image(
                painter = painterResource(id = R.drawable.abc), // Dùng drawable nếu ảnh trong drawable
                contentDescription = "Poster",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
                    .padding(end = 16.dp)
            )

            // Hiển thị phần trăm
            Column {
                Text(text = "ĐỘC THÂN: ${"%.2f".format(DocThan)}%", color = Color.Green, style = percentageTextStyle)
                Text(text = "ĐÃ CÓ CHỦ: ${"%.2f".format(DaCoChu)}%", color = Color.Red, style = percentageTextStyle)
                Text(text = "LGBT: ${"%.2f".format(LGBT)}%", color = Color(0xFF9C27B0), style = percentageTextStyle)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Các nút bầu chọn
        VotingButton(
            text = "ĐỘC THÂN",
            backgroundColor = Color.Green,
            onClick = {
                VoteDocThan++
            }
        )
        VotingButton(
            text = "ĐÃ CÓ CHỦ",
            backgroundColor = Color.Red,
            onClick = {
                VoteDaCoChu++
            }
        )
        VotingButton(
            text = "LGBT",
            backgroundColor = Color(0xFF9C27B0),
            onClick = {
                VoteLGBT++
            }
        )
    }
}

@Composable
fun VotingButton(text: String, backgroundColor: Color, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(vertical = 8.dp)
            .background(backgroundColor, shape = RoundedCornerShape(8.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(text = text, fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.Bold)
    }
}
