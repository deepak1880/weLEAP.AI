package com.example.weleapai.features.auth.presentation.login

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weleapai.R
import com.example.weleapai.ui.theme.Black
import com.example.weleapai.ui.theme.DarkBlue
import com.example.weleapai.ui.theme.LightBlue
import com.example.weleapai.ui.theme.White
import com.example.weleapai.ui.theme.spacing
import com.example.weleapai.core.utils.DialogContent
import com.example.weleapai.core.utils.GradientButton
import com.example.weleapai.core.utils.InputText

@Composable
fun LoginScreen(
    onSignUpClick: () -> Unit,
    onLoginSuccess: () -> Unit,
) {
    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightBlue),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            modifier = Modifier.padding(start = 15.dp, end = 10.dp, top = 50.dp),
            text = stringResource(R.string.app_name),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            color = Black
        )
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.default))

        Text(
            modifier = Modifier.padding(start = 15.dp, top = 150.dp, end = 60.dp),
            text = stringResource(R.string.welcome_back),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Black,
            fontFamily = FontFamily.Monospace,
            lineHeight = 50.sp
        )

        Text(
            modifier = Modifier.padding(start = 15.dp, end = 5.dp, top = 10.dp),
            text = stringResource(R.string.login_message),
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Default,
            color = Black,
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(LightBlue),
            contentAlignment = Alignment.BottomCenter
        ) {

            Column(
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.default),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp) // Increase height of the Column
                    .clip(
                        RoundedCornerShape(
                            topStart = MaterialTheme.spacing.default,
                            topEnd = MaterialTheme.spacing.default
                        )
                    )
                    .border(
                        1.dp, DarkBlue, shape = RoundedCornerShape(
                            topStart = MaterialTheme.spacing.default,
                            topEnd = MaterialTheme.spacing.default
                        )
                    )
                    .background(color = White)
                    .padding(MaterialTheme.spacing.default)
            ) {
                InputText(
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(R.string.email),
                    placeholder = stringResource(R.string.email_placeholder),
                    icon = Icons.Outlined.Email,
                    value = "",
                    keyboardType = KeyboardType.Email,
                    errorMessage = "",
                    onTextChange = { }
                )
                InputText(
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(R.string.password),
                    placeholder = stringResource(R.string.password_placeholder),
                    icon = Icons.Outlined.Lock,
                    value = "",
                    keyboardType = KeyboardType.Password,
                    errorMessage = "",
                    onTextChange = {},
                    isPassword = true,
                )

                Text(
                    modifier = Modifier
                        .align(alignment = Alignment.End)
                        .clickable {
                            Toast
                                .makeText(
                                    context,
                                    context.getString(R.string.forget_password),
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                        }
                        .offset(y = -MaterialTheme.spacing.defaultSmall),
                    text = stringResource(R.string.forget_password),
                    color = Black,
                )

                GradientButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { onLoginSuccess ()}
                ) {
                    Text(text = stringResource(R.string.login))
                }
                Row(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.extraSmall),
                ) {
                    Text(
                        text = stringResource(R.string.do_not_have_an_account),
                        color = Black,
                    )
                    Text(
                        modifier = Modifier.clickable {
                            onSignUpClick()
                        },
                        text = stringResource(R.string.sign_up),
                        color = DarkBlue,
                    )
                }
            }
            if (showDialog) {
                DialogContent(message = stringResource(id = R.string.please_wait))
            }
        }

    }
}

@Preview
@Composable
private fun LoginPreview() {
    LoginScreen(
        onLoginSuccess = {},
        onSignUpClick = {},
    )
}