package com.example.utsmocom

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }

    val validUsername = "admin"
    val validPassword = "admin123"

    val validate = {
        isError = username.isBlank() || password.isBlank() || username != "admin" || password != "admin123"
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = username,
                onValueChange = { username = it; isError = false },
                label = { Text("Username") },
                isError = isError,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it; isError = false},
                label = { Text("Password") },
                isError = isError,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            )

            if (isError) {
                Text(
                    text = "Invalid username or password",
                    color = Color.Red,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            Row(
                modifier = Modifier.padding(vertical = 12.dp)
            ) {
                Button(
                    onClick = {
                        if (username == validUsername && password == validPassword) {
                        isError = false
                        navController.navigate("dashboard")
                    } else {
                        isError = true
                    } },
                    modifier = Modifier.padding(horizontal = 5.dp)
                ) {
                    Text("Login")
                }
            }
        }
    }
}