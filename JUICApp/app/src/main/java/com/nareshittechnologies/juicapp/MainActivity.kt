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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
                DisplayButtons()
            }
        }
    }

    @Composable
    fun DisplayButtons(){
            var count by remember {
                mutableStateOf(0)
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize()
                .padding(all = 8.dp)
            ) {
                Button(onClick = { count++ }, modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)) {
                    Text(text = "+")
                }

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Yellow)
                    .weight(9f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {

                    Text(text = "${count}",
                        fontSize = 100.sp,
                        fontWeight = FontWeight.Bold
                    )

                }
                
                Button(onClick = { count-- }, modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)) {
                    Text(text = "-")
                }
            }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewButtons(){
        DisplayButtons()
    }
}
