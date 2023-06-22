package com.rakangsoftware.navigation.presentation.features.order.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.rakangsoftware.navigation.presentation.ui.theme.NavigationTheme

@Composable
fun OrderDetailScreenView(orderId: Int, onBackTapped: () -> Unit, modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                backgroundColor = Color(0xFF162A3D),
                contentColor = Color.White,
                title = { Text("Orders", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = {
                        onBackTapped()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Go Back",
                            tint = Color.White
                        )
                    }
                }
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
                text = "Order $orderId"
            )
        }
    }
}

@Preview
@Composable
fun OrdersScreenViewPreview() {
    NavigationTheme {
        OrderDetailScreenView(
            orderId = 5,
            onBackTapped = {}
        )
    }
}
