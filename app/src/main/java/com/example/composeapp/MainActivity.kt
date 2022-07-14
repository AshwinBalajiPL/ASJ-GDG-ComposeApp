package com.example.composeapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.ui.theme.ComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colors.background
                ) {
//                    HelloContent()
                    Column() {
                        Text(modifier = Modifier.padding(40.dp,10.dp),text = "Login", fontSize = 28.sp, fontWeight = FontWeight.Bold)
                        Column(
                            modifier = Modifier.padding(50.dp,0.dp),
                        ) {
                            var userName by remember{ mutableStateOf("")}
                            var password by remember{ mutableStateOf("")}
                            OutlinedTextField(
                                value = userName,
                                onValueChange = {userName = it},
                                label = {Text("Username")},
                                modifier = Modifier.padding(bottom = 10.dp)
                            )
                            OutlinedTextField(
                                value = password,
                                onValueChange = {password = it},
                                label = {Text("Password")},
                                modifier = Modifier.padding(top = 10.dp)
                            )
                            Button(onClick = { /*TODO*/ }, modifier = Modifier
                                .padding(40.dp, 25.dp)
                                .width(200.dp)
                                .height(50.dp)) {
                                Text(text = "Login ", fontSize = 20.sp)
                                Icon(painter = painterResource(id = R.drawable.ic_login), contentDescription = "Login")
                            }
                        }
                    }
                    }

            }
        }
    }
}

@Composable
fun HelloContent() {
    Column(modifier = Modifier.padding(16.dp)) {
        var name by remember { mutableStateOf("") }
        if (name.isNotEmpty()) {
            Text(
                text = "Hello, $name!",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.h5
            )
        }
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )
    }
}
