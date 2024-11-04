import androidx.compose.runtime.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.text.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.*
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlin.R
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Congrats() {
    Column(
        modifier = Modifier
         .fillMaxSize()
         .background(
                color = Color(0xFFFFFFFF),
             ),
        horizontalAlignment = Alignment.CenterHorizontally,

        ){
        Spacer(modifier = Modifier.height(80.dp))

        Text("SUCCESS!",
                color = Color(0xFF303030),
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,


            )
            Box(
                modifier = Modifier
                    .padding(bottom = 57.dp,start = 52.dp,end = 52.dp,)
            ){
                Image(
                    painter = painterResource(id = R.drawable.group1),
                    contentDescription = "My Image",
                    modifier = Modifier.size(260.dp),
                    contentScale = ContentScale.Fit
                )
            }
            Text("Your order will be delivered soon.\nThank you for choosing our app!",
                color = Color(0xFF5F5F5F),
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(bottom = 52.dp,start = 55.dp,end = 55.dp,)
                    .width(265.dp)
            )

        Button  (onClick = { }, modifier = Modifier
            .padding(bottom = 26.dp,start = 29.dp,end = 29.dp,)
            .fillMaxWidth()
            .height(70.dp)
//            .clip(shape = RoundedCornerShape(8.dp))
            .background(
                color = Color(0xFF232323),
                shape = RoundedCornerShape(8.dp)
            )
//            .shadow(
//                elevation = 20.dp,
//                spotColor = Color(0x40303030),
//            )

            ,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent) // Đặt màu nền trong suốt
        ) {

            Text("Track your orders",
                color = Color(0xFFFFFFFF),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
        }
        Button  (onClick = { }, modifier = Modifier
            .padding(bottom = 26.dp,start = 29.dp,end = 29.dp,)
            .fillMaxWidth()
            .height(70.dp)
//            .clip(shape = RoundedCornerShape(8.dp))
            .background(
                color = Color(0xFFFFFFFF),
//                shape = RoundedCornerShape(8.dp)
            )
//            .shadow(
//                elevation = 20.dp,
//                spotColor = Color(0x40303030),
//            )
            .border(
                width = 1.dp,
                color = Color(0xFF303030),
                shape = RoundedCornerShape(8.dp)
            )

            ,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent) // Đặt màu nền trong suốt
        ) {

            Text("BACK TO HOME",
                color = Color(0xFF303030),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
        }

    }
}