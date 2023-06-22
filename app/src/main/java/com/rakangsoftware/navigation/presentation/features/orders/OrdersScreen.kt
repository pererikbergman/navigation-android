package com.rakangsoftware.navigation.presentation.features.orders

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.rakangsoftware.navigation.presentation.ui.theme.NavigationTheme

@Composable
fun OrdersScreenView( modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color(0xFF162A3D),
                title = { Text("Orders", color = Color.White) }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Order Screen"
            )
        }
    }
}

@Preview
@Composable
fun OrdersScreenViewPreview() {
    NavigationTheme {
        OrdersScreenView()
    }
}
