package com.kotlin.countermvvm

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kotlin.countermvvm.ui.theme.CounterMVVMTheme
import androidx.lifecycle.viewmodel.compose.viewModel
class MainActivity : ComponentActivity() {



    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: CounterViewModel = viewModel()
            CounterMVVMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Counter(viewModel)
                }
            }
        }
    }
}

@Composable
fun Counter(viewModel: CounterViewModel){

    //var counter by remember { mutableStateOf(0) }
    var counter by remember {viewModel.count }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Counter Application",
            modifier = Modifier.padding(10.dp),
            style = TextStyle(
                fontSize = 28.sp,
                color = Color.Black
            )
        )
        Text(
            text = counter.toString(),
            modifier = Modifier.padding(10.dp),
            style = TextStyle(
                fontSize = 22.sp,
                color = Color.Black
            ),

        )

        Row {
            Box (
                modifier = Modifier.padding(10.dp)
            ){
                Button(onClick = { viewModel.increment() }) {
                    Text(text = "Increment")
                }
            }

            Box (
                modifier = Modifier.padding(10.dp)
            ) {
                Button(onClick = { viewModel.decrement() }) {
                    Text(text = "Decrement")
                }
            }


        }
    }

}