package com.nareshittechnologies.juicapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nareshittechnologies.juicapp.ui.theme.JUICAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JUICAppTheme {
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    for(i in 1..7){
                        DisplayButtons()
                    }
                }
            }
        }
    }

    @Composable
    fun DisplayButtons(){
        Surface(color = Color.Blue,
            contentColor = contentColorFor(Color.White),
            modifier = Modifier.padding(all = 8.dp)) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape))

                Column(modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Mirinda",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White)

                    Text(text = "Popular Artist",
                        fontSize = 10.5.sp,
                        fontStyle = FontStyle.Italic,
                        color = Color.White)

                    Button(onClick = {
                        Toast.makeText(applicationContext,"Button is clicked",Toast.LENGTH_LONG).show()
                    }) {
                        Text(text = "Click Me")
                    }
                }
            }
        }

    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewButtons(){
        DisplayButtons()
    }
}
