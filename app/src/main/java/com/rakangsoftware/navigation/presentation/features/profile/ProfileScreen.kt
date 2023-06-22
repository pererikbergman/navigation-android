package com.rakangsoftware.navigation.presentation.features.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rakangsoftware.navigation.presentation.ui.theme.NavigationTheme

@Composable
fun ProfileScreenView(modifier: Modifier = Modifier) {
    Scaffold { paddingValues ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Profile Screen"
            )
        }
    }
}

@Preview
@Composable
fun ProfileScreenViewPreview() {
    NavigationTheme {
        ProfileScreenView()
    }
}
