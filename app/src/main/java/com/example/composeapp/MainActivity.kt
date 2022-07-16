package com.example.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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
                    Column(modifier = Modifier.fillMaxSize()) {
                        Text(
                            modifier = Modifier.padding(40.dp, 10.dp),
                            text = "Login",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Column(
                            modifier = Modifier.padding(50.dp, 0.dp),
                        ) {
                            var userName by remember { mutableStateOf("") }
                            var password by remember { mutableStateOf("") }
                            var showPassword by remember { mutableStateOf(false) }
                            var isUserNameError by remember {
                                mutableStateOf(false)
                            }
                            OutlinedTextField(
                                value = userName,
                                onValueChange = {
                                    isUserNameError = it.contains(" ")
                                    userName = it
                                },
                                label = { Text("Username") },
                                isError = isUserNameError,
                                singleLine = true,
                                modifier = Modifier.padding(bottom = 10.dp)
                            )
                            OutlinedTextField(
                                value = password,
                                onValueChange = { password = it },
                                label = { Text("Password") },
                                singleLine = true,
                                visualTransformation = if (!showPassword) PasswordVisualTransformation(
                                    '*'
                                ) else VisualTransformation.None,
                                modifier = Modifier.padding(top = 10.dp),
                                trailingIcon = {
                                    IconButton(onClick = {
                                        showPassword = !showPassword
                                    }) {
                                        if (!showPassword)
                                            Icon(
                                                painter = painterResource(id = R.drawable.ic_lock),
                                                contentDescription = "Hide"
                                            )
                                        else
                                            Icon(
                                                painter = painterResource(id = R.drawable.ic_lock_open),
                                                contentDescription = "Show"
                                            )
                                    }
                                }
                            )
                            Button(
                                onClick = { /*TODO*/ }, modifier = Modifier
                                    .padding(40.dp, 25.dp)
                                    .width(200.dp)
                                    .height(50.dp)
                            ) {
                                Text(text = "Login ", fontSize = 20.sp)
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_login),
                                    contentDescription = "Login"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


