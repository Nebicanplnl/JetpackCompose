package com.example.jetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ColumnSamples() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text ="İtem one")
        Text(text ="İtem two")
        Text(text ="İtem three")
    }
}

@Composable
fun RowSamples() {
    Row(
        modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text ="İtem one")
        Text(text ="İtem two")
        Text(text ="İtem three")
    }
}

@Preview(showBackground = true)
@Composable
fun ColumnSamplesPreview() {
    ColumnSamples()
}

@Preview(showBackground = true)
@Composable
fun RowSamplesPreview() {
    RowSamples()
}

