package org.waqas028.data_store_kmp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun CustomCircularProgressBar(modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .fillMaxSize()
        .clickable(enabled = false) {}
    ) {
        Box(modifier = Modifier
            .size(90.dp)
            .align(Alignment.Center)
            .background(color = Color.Black.copy(alpha = .5f), shape = RoundedCornerShape(10.dp))
        ){
            CircularProgressIndicator(
                modifier = Modifier
                    .size(60.dp)
                    .align(Alignment.Center),
                color = MaterialTheme.colors.primary,
                backgroundColor = Color.White,
            )
        }
    }
}