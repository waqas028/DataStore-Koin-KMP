package org.waqas028.data_store_kmp.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun CustomButton(modifier: Modifier = Modifier, buttonText: String, onButtonClick: () -> Unit) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        onClick = { onButtonClick() },
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary
        ),
        shape = RoundedCornerShape(15.dp)
    ) {

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = buttonText,
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.onPrimary,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

@Preview
@Composable
fun CustomButtonPreview() {
    CustomButton(buttonText = "Sign in") {}
}