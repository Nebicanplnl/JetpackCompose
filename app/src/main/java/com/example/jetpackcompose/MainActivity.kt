package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App(modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    Row(modifier = modifier.background(Color.Blue).fillMaxSize()) {
        Text(text = "Hello")
        Text(text = "World")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTheme {
        App()
    }
}

@Composable
fun CryptoFun(
    cryptoViewModel: CryptoViewModel = hiltViewModel()
) {
    val state = cryptoViewModel.cryptoState.value

    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn {
            items(state.crypto) { crypto ->
                CryptoItem(crypto)
                HorizontalDivider()
            }
        }
        if (state.error.isNotBlank()) {
            Text(text = state.error,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.fillMaxSize()
                    .padding( 20.dp)
                    .align(Alignment.Center))
        }
        if (state.isLoading) {
            CircularProgressIndicator()
        }
    }
}

