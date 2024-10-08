package com.example.pastryappui.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pastryappui.R
import com.example.pastryappui.ui.navigation.Route
import com.example.pastryappui.ui.theme.PastryAppUITheme

@Composable
fun WelcomeScreen(navcontroller : NavHostController) {
    // Define the color to ensure consistency and reuse
    val buttonColor = Color(0xFF8B4513)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.intro_logo),
                contentDescription = "Baker with pastries",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f), // Covers 50% of the screen height
                contentScale = ContentScale.Fit
            )


            // Main Content
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Satisfy Your Cravings with Our",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Fresh Cakes, Donuts",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = buttonColor // Using button color for consistency
                )
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color.Black)) {
                            append("and ")
                        }
                        withStyle(style = SpanStyle(color = buttonColor)) {
                            append("Pastries")
                        }
                    },
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = buttonColor // Using button color for consistency
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Browse the best edibles from top sellers",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Gray
                )
                Text(
                    text = "Get personalized recommendations",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Gray
                )
                Text(
                    text = "Enjoy fast, free shipping",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        navcontroller.navigate(Route.HomeScreen.name)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
                    shape = RoundedCornerShape(25.dp)
                ) {
                    Text(text = "Let's Get Started", color = Color.White)
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color.Black)) {
                            append("Already have an account? ")
                        }
                        withStyle(style = SpanStyle(color = buttonColor)) {
                            append("Sign In")
                        }
                    },
                    fontSize = 14.sp,
                )
            }
        }
    }
}

@Preview
@Composable
fun ComponentPreview() {
    PastryAppUITheme {
        WelcomeScreen(rememberNavController())
    }
}
