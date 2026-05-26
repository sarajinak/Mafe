package com.example.mafe

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import android.content.Intent
import com.example.mafe.ui.theme.theme

class ForgotPassword : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ForgotPasswordBody()
        }
    }
}

@Composable
fun ForgotPasswordBody(){
    var password by remember { mutableStateOf("") }
    var repassword by remember { mutableStateOf("") }
    var visibility by remember { mutableStateOf(false) }
    val context = LocalContext.current
    Column(
            modifier = Modifier.fillMaxSize()
                .background(color = Color.White)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier
                        .height(130.dp).weight(1f),
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
                            modifier = Modifier.height(150.dp)
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
            modifier = Modifier.height(600.dp)
                .padding(8.dp)
        ) {
            Card(
                modifier = Modifier
                    .height(130.dp).weight(1f),
                shape = RoundedCornerShape(30.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 30.dp
                ),
                colors = CardDefaults.cardColors(containerColor = Color.LightGray)
            ) {
        Text(
            "Forgot Password", style = TextStyle(
                color = Box,
                fontWeight = FontWeight.W700,
                fontSize = 28.sp,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.fillMaxWidth().padding(30.dp)
        )
                        Spacer(modifier = Modifier.height(15.dp)
                )
        Text(text = "New Password", style = TextStyle(
            color = theme
        ))
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            visualTransformation = if (visibility)
                VisualTransformation.None
            else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = {
                    visibility = !visibility
                }) {
                    Icon(
                        painter =
                            if (visibility)
                                painterResource(R.drawable.baseline_visibility_24)
                            else
                                painterResource(
                                    R.drawable.baseline_visibility_off_24
                                ),
                        contentDescription = null
                    )
                }
            },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth()
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
        Text(text = "Re-type Password", style = TextStyle(
            color = theme,
        ))
        OutlinedTextField(
            value = repassword,
            onValueChange = {
                repassword = it
            },
            visualTransformation = if (visibility)
                VisualTransformation.None
            else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = {
                    visibility = !visibility
                }) {
                    Icon(
                        painter =
                            if (visibility)
                                painterResource(R.drawable.baseline_visibility_24)
                            else
                                painterResource(
                                    R.drawable.baseline_visibility_off_24
                                ),
                        contentDescription = null
                    )
                }
            },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth()
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
                    modifier = Modifier.height(40.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Back to Login Page",style = TextStyle(
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        color = Box,
                        fontWeight = FontWeight.SemiBold,
                        textDecoration = TextDecoration.Underline,
                    ),
                        modifier = Modifier.clickable {
                            val intent = Intent(context, LoginActivity::class.java)
                            context.startActivity(intent)
                        })
                }
        ElevatedButton(modifier = Modifier.padding(5.dp).fillMaxWidth(),
            onClick = {},
            colors = ButtonDefaults.buttonColors(Box.copy(0.4f))
        ) {
            Text(
                "Reset Password", style = TextStyle(
                    fontSize = 17.sp,
                    color = Box,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        }
}
    }
}


@Preview(showBackground = true)
@Composable
fun ForgotPasswordPreview() {
    ForgotPasswordBody()
}