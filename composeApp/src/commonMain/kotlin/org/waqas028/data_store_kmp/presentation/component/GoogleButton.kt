package org.waqas028.data_store_kmp.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import datastore_kmp.composeapp.generated.resources.Res
import datastore_kmp.composeapp.generated.resources.ic_google
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun GoogleButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    onButtonClick: () -> Unit,
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        onClick = { onButtonClick() },
        contentPadding = PaddingValues(),
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colors.primary),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.onPrimary,
            disabledBackgroundColor = MaterialTheme.colors.surface.copy(.6f),
        ),
        shape = RoundedCornerShape(15.dp)
    ) {

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(Res.drawable.ic_google),
                    contentDescription = null,
                )
                Text(
                    text = buttonText,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colors.onSurface,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun GoogleButtonPreview() {
    GoogleButton(buttonText = "Sign in with Google") {}
}