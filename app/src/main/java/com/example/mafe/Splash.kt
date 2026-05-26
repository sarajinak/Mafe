package com.example.mafe

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import androidx.compose.foundation.background
import android.content.Intent
import com.example.mafe.ui.theme.theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SplashBody()
        }
    }
}

@Composable
fun SplashBody(){
    val context = LocalContext.current
//    val activity = context as Activity
    LaunchedEffect(Unit) {

        delay(3000)
        val sharedPreferences = context.getSharedPreferences(
            "User",
            Context.MODE_PRIVATE
        )
        val intent = Intent(context, LoginActivity::class.java)
        context.startActivity(intent)
        //activity.finish()

        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn",false)
        if(isLoggedIn){
            //activity.finish()
        }else{
            //activity.finish()
        }
    }
    Column(
        modifier = Modifier.fillMaxSize().background(color = theme.copy(0.8f))
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.mafe),
            contentDescription = null,
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
        )
        CircularProgressIndicator()
    }
}

@Preview(showBackground = true)
@Composable
fun SplashPreview(){
    SplashBody()
}