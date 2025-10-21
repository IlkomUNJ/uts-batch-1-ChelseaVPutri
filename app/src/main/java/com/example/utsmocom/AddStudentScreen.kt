package com.example.utsmocom

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddStudentScreen(navController: NavController) {
    var nim by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(text = "Add Student") },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = Color.White
            ),
            navigationIcon = {
                IconButton(
                    onClick = { navController.navigate("dashboard") }
                ) { Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White) }
            }
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = nim,
                onValueChange = { newText -> nim = newText },
                label = { Text("Student ID") },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            )

            OutlinedTextField(
                value = name,
                onValueChange = { newText -> name = newText },
                label = { Text("Student Name") },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 5.dp)
            )

            OutlinedTextField(
                value = phone,
                onValueChange = { newText -> phone = newText },
                label = { Text("Student Phone Number") },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 5.dp)
            )

            OutlinedTextField(
                value = address,
                onValueChange = { newText -> address = newText },
                label = { Text("Student Address") },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 5.dp)
            )

            Row(modifier = Modifier.padding(vertical = 12.dp)) {
                Button(
                    onClick = {}
                ) {
                    Text("Register")
                }
            }
        }
    }
}