package com.example.testingbutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.testingbutton.ui.theme.TestingButtonTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestingButtonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    //studentButton()
                    Greeting(name = "Hello I am making pull request")
                    studentButton2()
                }
            }
        }
    }
}


@Composable
fun studentButton(/* onClick: () -> Unit*/){
    var showDialog by remember { mutableStateOf(false) }

    Column() {
        Button(onClick = { showDialog = true }) {
            Text(text = "Random Student")
        }
        if (showDialog) {
            val list = listOf("hello", "pie", "love", "do", "bike")
            val randomIndex = Random.nextInt(list.size);
            val randomElement = list[randomIndex]
            Text("Random Student: $randomElement")
        }
    }
}

@Composable
fun studentButton2(/* onClick: () -> Unit*/){

    var showDialog by remember { mutableStateOf(1) }

    val names = when(showDialog) {
        1 -> "Hello"
        2 -> "Pie"
        3 -> "Love"
        4 -> "Bike"
        else -> "do"
    }

    Column() {
        Text(text = names)
        Button(onClick = { showDialog = (1..4).random() }) {
            Text(text = "Random Student")
        }
    }
}




@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestingButtonTheme {
        Greeting("Android")
    }
}
