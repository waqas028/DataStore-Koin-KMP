package org.waqas028.data_store_kmp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import datastore_kmp.composeapp.generated.resources.Res
import datastore_kmp.composeapp.generated.resources.ic_eye_hide
import datastore_kmp.composeapp.generated.resources.ic_eye_show
import org.jetbrains.compose.resources.painterResource

@Composable
fun PasswordTextFields(
    placeholder: String,
    password: String,
    passwordVisibility: Boolean,
    onTextChange: (String) -> Unit,
    onToggleClick: (Boolean) -> Unit,
) {
    Column {
        OutlinedTextField(
            value = password,
            onValueChange = {
                onTextChange(it)
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            placeholder = {
                Text(
                    text = placeholder,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.6f),
                )
            },
            textStyle = TextStyle(MaterialTheme.colors.onSurface),
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = "",
                    tint = MaterialTheme.colors.primary
                )
            },
            trailingIcon = {
                IconButton(onClick = { onToggleClick(!passwordVisibility) }) {
                    if (passwordVisibility) {
                        Image(
                            painter = painterResource(Res.drawable.ic_eye_show),
                            contentDescription = "",
                            modifier = Modifier.size(25.dp)
                        )
                    } else
                        Image(
                            painter = painterResource(Res.drawable.ic_eye_hide),
                            contentDescription = ""
                        )
                }
            },
            shape = RoundedCornerShape(15.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
        )
    }
}