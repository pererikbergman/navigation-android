package com.rakangsoftware.navigation.presentation.features.order.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
fun OrderListScreenView(onOrderTapped: (orderId: Int) -> Unit, modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                backgroundColor = Color(0xFF162A3D),
                title = { Text("Order List", color = Color.White) }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center,
        ) {
            Column {
                Button(onClick = { onOrderTapped(1) }) {
                    Text(
                        text = "Order 1"
                    )
                }
                Button(onClick = { onOrderTapped(2) }) {
                    Text(
                        text = "Order 2"
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun OrdersScreenViewPreview() {
    NavigationTheme {
        OrderListScreenView({

        })
    }
}