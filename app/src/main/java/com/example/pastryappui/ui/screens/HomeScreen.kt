package com.example.pastryappui.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
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
import com.example.pastryappui.ui.navigation.Route
import com.example.pastryappui.ui.theme.PastryAppUITheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navcontroller : NavHostController) {

    val primaryColor = Color(0xFF8B4513)
    val categories = listOf("Cookies", "Donuts" , "Pastries", "Cup Cakes",  "Bread")

    val imageCategory = listOf(
        R.drawable.cookie,
        R.drawable.donut,
        R.drawable.pastries,
        R.drawable.cup_cake,
        R.drawable.bread
    )

    val bestSellers = listOf(
        BestSeller("Tiramisu Cake", 99, 4.6f, R.drawable.cake5),
        BestSeller("BlueBerry Cake", 110, 4.2f, R.drawable.cake2),
        BestSeller("Strawberry Cake", 100, 4.8f, R.drawable.cake4),
        BestSeller("Chocolate Cake", 180, 4.9f, R.drawable.cake3),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Welcome", fontSize = 14.sp)
                        Text("Tom Johnson", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    }
                },
                actions = {
                    Icon(
                        Icons.Default.Notifications,
                        contentDescription = "Notifications",
                        modifier = Modifier.padding(22.dp)
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = primaryColor,
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(bottomEnd = 24.dp, bottomStart = 24.dp)),
            )
        },
        bottomBar = {
            Card(
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
            ) {
                NavigationBar(containerColor = primaryColor) {
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Home, contentDescription = "Home",tint = Color.White) },
                        label = { Text("Home", color = Color.White) },
                        selected = true,
                        onClick = {},
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Cart",tint = Color.White) },
                        label = { Text("Cart", color = Color.White) },
                        selected = false,
                        onClick = {
                            navcontroller.navigate(Route.CartScreen.name)
                        }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Favorite, contentDescription = "Wishlist",tint = Color.White) },
                        label = { Text("Wishlist", color = Color.White) },
                        selected = false,
                        onClick = { navcontroller.navigate(Route.DetailsScreen.name) }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.List, contentDescription = "My Order",tint = Color.White) },
                        label = { Text("My Order", color = Color.White) },
                        selected = false,
                        onClick = { /* TODO */ }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Person, contentDescription = "Profile",tint = Color.White) },
                        label = { Text("Profile", color = Color.White) },
                        selected = false,
                        onClick = { /* TODO */ }
                    )
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = { /* TODO */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                placeholder = { Text("Search anything") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = primaryColor,
                    unfocusedBorderColor = Color.Gray
                )
            )

            LazyRow(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .wrapContentHeight(),
            ) {
                items(2) { index ->
                    Image(
                        painter = painterResource(id = if (index == 0) R.drawable.banner1 else R.drawable.banner2),
                        contentDescription = "Promotional image",
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentScale = ContentScale.Fit
                    )
                    if (index == 0) {
                        Spacer(modifier = Modifier.width(12.dp))
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Categories", fontWeight = FontWeight.Bold)
                TextButton(onClick = { /* TODO */ }) {
                    Text("See all", color = primaryColor)
                }
            }

            LazyRow(
                modifier = Modifier.padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(categories.size) { index ->
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = imageCategory[index]),
                            contentDescription = categories[index],
                            modifier = Modifier
                                .size(60.dp)
                                .clip(CircleShape)
                        )
                        Text(categories[index], fontSize = 12.sp)
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Best Seller Product",
                    fontWeight = FontWeight.Bold
                )
                TextButton(onClick = {

                }) {
                    Text("See all", color = primaryColor)
                }
            }

            LazyRow(
                modifier = Modifier.padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(bestSellers) { product ->
                    Card(
                        modifier = Modifier.width(180.dp)
                    ) {
                        Column {
                            Image(
                                painter = painterResource(id = product.imageRes),
                                contentDescription = product.name,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(170.dp),
                                contentScale = ContentScale.Crop
                            )
                            Column(modifier = Modifier.padding(8.dp)) {
                                Text(product.name, fontWeight = FontWeight.Bold)
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(product.price.toString(), color = primaryColor)
                                    Row (
                                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ){
                                        Icon(
                                            Icons.Default.Star,
                                            contentDescription = null,
                                            tint = Color.Yellow,
                                            modifier = Modifier.size(16.dp)
                                        )
                                        Text(product.rating.toString(), fontSize = 12.sp)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

data class BestSeller(val name: String, val price: Int, val rating: Float, val imageRes: Int)

@Preview
@Composable
fun ComponentPreview2() {
    PastryAppUITheme {
        HomeScreen(rememberNavController())
    }
}

