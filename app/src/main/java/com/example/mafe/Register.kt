package com.example.mafe

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mafe.ui.theme.Box
import com.example.mafe.ui.theme.theme


class Register : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RegisterBody()
        }
    }
}

@Composable
fun RegisterBody(){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirm by remember { mutableStateOf("") }
    var visibility by remember { mutableStateOf(false) }
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier
                    .height(130.dp)
                    .weight(1f),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 30.dp
                ),
                colors = CardDefaults.cardColors(containerColor = theme.copy(0.8f))
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.mafe),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .height(150.dp)
                            .width(150.dp),
                        alignment = Alignment.CenterEnd
                    )
                    Text("MAFE", style = TextStyle(
                        color = Color.LightGray,
                        fontSize = 50.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    ))
                }}
        }
        Spacer(
            modifier = Modifier.height(10.dp)
        )
        Column(
            modifier = Modifier
                .height(600.dp)
                .padding(5.dp)
        ) {
            Card(
                modifier = Modifier
                    .height(130.dp)
                    .weight(1f),
                shape = RoundedCornerShape(30.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 30.dp
                ),
                colors = CardDefaults.cardColors(containerColor = Color.LightGray)
            ) {
                Text(
                    text = "Register", style = TextStyle(
                        color = Box,
                        fontSize = 35.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp)
                )
                Text("Email", style = TextStyle(
                    color = theme,
                    textAlign = TextAlign.Center
                ))
                Spacer(
                    modifier = Modifier.height(5.dp)
                )
                OutlinedTextField(
                    value = email,
                    onValueChange = {
                        email = it
                    },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    placeholder = {
                        Text("abc@gmail.com")
                    },
                    colors = TextFieldDefaults.colors(
                        unfocusedIndicatorColor = Color.Transparent,
                        unfocusedContainerColor = Box.copy(0.5f),
                        focusedContainerColor = Color.Gray.copy(0.2f),
                        focusedIndicatorColor = Color.Green
                    )
                )
                Spacer(
                    modifier = Modifier.height(5.dp)
                )
                Text("Password",style = TextStyle(
                    color = theme,
                    textAlign = TextAlign.Center))
                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    visualTransformation = if (visibility)
                        VisualTransformation.None
                    else
                        PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = {
                            visibility = !visibility
                        }) {
                            Icon(
                                painter = if (visibility)
                                    painterResource(R.drawable.baseline_visibility_24)
                                else
                                    painterResource(R.drawable.baseline_visibility_off_24),
                                contentDescription = "Visibility"
                            )
                        }
                    },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    placeholder = {
                        Text("********")
                    },
                    colors = TextFieldDefaults.colors(
                        unfocusedIndicatorColor = Color.Transparent,
                        unfocusedContainerColor = Box.copy(0.5f),
                        focusedContainerColor = Color.Gray.copy(0.2f),
                        focusedIndicatorColor = Color.Green
                    )
                )
                Spacer(
                    modifier = Modifier.height(5.dp)
                )
                Text("Confirm Password",style = TextStyle(
                    color = theme,
                    textAlign = TextAlign.Center))
                OutlinedTextField(
                    value = confirm,
                    onValueChange = {
                        confirm = it
                    },
                    visualTransformation = if (visibility)
                        VisualTransformation.None
                    else
                        PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = {
                            visibility = !visibility
                        }) {
                            Icon(
                                painter = if (visibility)
                                    painterResource(R.drawable.baseline_visibility_24)
                                else
                                    painterResource(R.drawable.baseline_visibility_off_24),
                                contentDescription = "Visibility"
                            )
                        }
                    },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    placeholder = {
                        Text("********")
                    },
                    colors = TextFieldDefaults.colors(
                        unfocusedIndicatorColor = Color.Transparent,
                        unfocusedContainerColor = Box.copy(0.5f),
                        focusedContainerColor = Color.Gray.copy(0.2f),
                        focusedIndicatorColor = Color.Green
                    )
                )
                Spacer(
                    modifier = Modifier.height(20.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Already have an Account?",style = TextStyle(
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp
                    ))
                    Text(
                        " Login", style = TextStyle(
                            color = Box,
                            textAlign = TextAlign.Center,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.SemiBold,
                            textDecoration = TextDecoration.Underline
                        ),
                        modifier = Modifier.clickable {
                            val intent = Intent(context, LoginActivity::class.java)
                            context.startActivity(intent)
                        })
                }
                Row(
                    modifier = Modifier.padding(5.dp)
                ) {
                    ElevatedButton(
                        colors = ButtonDefaults.buttonColors(Box.copy(0.4f)),
                        onClick = {
                            val sharedPreferences = context.getSharedPreferences(
                                "User",
                                Context.MODE_PRIVATE
                            )
                            val emailStorage: String? = sharedPreferences.getString("email", "")
                            val passwordStorage: String? =
                                sharedPreferences.getString("password", "")

                            if (email == emailStorage && password == passwordStorage) {
                                Toast.makeText(
                                    context,
                                    "Login success",
                                    Toast.LENGTH_LONG
                                ).show()
                                val editor = sharedPreferences.edit()
                                editor.putBoolean("isLoggedIn", true)
                            } else {
                                Toast.makeText(
                                    context,
                                    "Login failed",
                                    Toast.LENGTH_LONG
                                ).show()

                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Register", style = TextStyle(
                            fontSize = 20.sp,
                            color = Box,
                            fontWeight = FontWeight.Bold
                        ))
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    RegisterBody()
}