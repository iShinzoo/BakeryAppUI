package com.example.pastryappui.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pastryappui.R
import com.example.pastryappui.ui.theme.PastryAppUITheme

@Composable
fun DetailScreen(navcontroller : NavHostController) {
    var selectedWeight by remember { mutableStateOf(1) }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Box(modifier = Modifier.weight(1f)) {
            Image(
                painter = painterResource(id = R.drawable.cake1_0),
                contentDescription = "Chocolate cake",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "Back",
                    modifier = Modifier
                        .size(48.dp)
                        .padding(8.dp)
                        .clickable {

                        }
                )
                Image(
                    painter = painterResource(id = R.drawable.fav_icon),
                    contentDescription = "Favorite",
                    modifier = Modifier
                        .size(48.dp)
                        .padding(8.dp)
                        .clickable {

                        }
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Chocolate cake with cream",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "$165",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF8B4513)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profil),
                    contentDescription = "Seller avatar",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "Jemmy Thompson",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.message),
                    contentDescription = "Chat",
                    modifier = Modifier
                        .size(40.dp)
                        .clickable {

                        }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.call),
                    contentDescription = "Call",
                    modifier = Modifier
                        .size(40.dp)
                        .clickable {

                        }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text("Select Weight (in KGs)", fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                for (weight in 1..5) {
                    Button(
                        onClick = { selectedWeight = weight },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (selectedWeight == weight) Color(0xFF8B4513) else Color.LightGray
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                    ) {
                        Text("${weight}", color = if (selectedWeight == weight) Color.White else Color.Black)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Button(
                    onClick = {  },
                    modifier = Modifier.fillMaxWidth(0.9f),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8B4513))
                ) {
                    Text("Add to Cart", color = Color.White)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.basket),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun ComponentPreview1() {
    PastryAppUITheme {
        DetailScreen(rememberNavController())
    }
}
