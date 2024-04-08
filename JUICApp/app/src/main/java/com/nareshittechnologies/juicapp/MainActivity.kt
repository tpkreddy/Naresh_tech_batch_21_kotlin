package com.nareshittechnologies.juicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
        Column {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "First Button")
            }

            Button(onClick = { /*TODO*/ }) {
                Text(text = "Second Button")
            }

            Button(onClick = { /*TODO*/ }) {
                Text(text = "Third Button")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewButtons(){
        DisplayButtons()
    }
}
