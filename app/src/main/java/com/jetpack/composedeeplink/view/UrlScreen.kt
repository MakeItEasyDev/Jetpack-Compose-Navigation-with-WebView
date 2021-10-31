package com.jetpack.composedeeplink.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun UrlScreen(
    navController: NavController
) {
    val urlText = remember {
        mutableStateOf(TextFieldValue())
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(MaterialTheme.colors.primary)
        ) {
            Text(
                text = "WebView Page",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            TextField(
                value = urlText.value,
                onValueChange = { urlText.value = it },
                label = {  Text(text = "Enter Url") },
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .background(Color.White),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    navController.navigate("webview/${urlText.value.text}")
                },
                shape = RoundedCornerShape(10.dp),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 6.dp,
                    pressedElevation = 8.dp,
                    disabledElevation = 0.dp
                ),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Text(
                    text = "Submit",
                    modifier = Modifier.padding(6.dp)
                )
            }
        }
    }
}




















