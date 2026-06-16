package com.example.apexplanettask1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    var isLoggedIn by remember { mutableStateOf(false) }

    if (isLoggedIn) {
        HomeScreen(
            onLogout = {
                isLoggedIn = false
            }
        )
    } else {
        LoginScreen(
            onLogin = {
                isLoggedIn = true
            }
        )
    }
}

@Composable
fun LoginScreen(onLogin: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "ApexPlanet Internship App",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Task 3 - Dashboard Application"
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = onLogin
        ) {
            Text("Login")
        }
    }
}

@Composable
fun HomeScreen(onLogout: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Student Dashboard",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(25.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text("Name : Parvathi")
                Spacer(modifier = Modifier.height(8.dp))

                Text("Course : Android Development")
                Spacer(modifier = Modifier.height(8.dp))

                Text("Company : ApexPlanet")
                Spacer(modifier = Modifier.height(8.dp))

                Text("Task : Task 3")
                Spacer(modifier = Modifier.height(8.dp))

                Text("Skills : Kotlin, Jetpack Compose")
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text("Project Description")

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    "Developed an Android application using Kotlin and Jetpack Compose. Implemented Login Screen, Dashboard Screen, Navigation and User Interaction."
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = onLogout
        ) {
            Text("Logout")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    MyApp()
}