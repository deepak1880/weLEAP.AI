package com.example.weleapai.features.auth.presentation.signup

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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.weleapai.R
import com.example.weleapai.ui.theme.Black
import com.example.weleapai.ui.theme.DarkBlue
import com.example.weleapai.ui.theme.LightBlue
import com.example.weleapai.ui.theme.White
import com.example.weleapai.ui.theme.spacing
import com.example.weleapai.utils.DialogContent
import com.example.weleapai.utils.GradientButton
import com.example.weleapai.utils.InputText

@Composable
fun SignUpScreen(
    controller: NavHostController,
) {
    var showDialog by remember { mutableStateOf(false) }
    val onLoginClick = { controller.navigate("login") }
    val onSignUpClick = { controller.navigate("homeScreen") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightBlue),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            modifier = Modifier.padding(start = 15.dp, end = 10.dp, top = 35.dp),
            text = stringResource(R.string.app_name),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            color = Black
        )
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.default))

        Text(
            modifier = Modifier.padding(start = 15.dp, top = 10.dp, end = 120.dp),
            text = stringResource(R.string.sign_up_message),
            fontSize = 45.sp,
            fontWeight = FontWeight.Normal,
            color = Black,
            lineHeight = 50.sp
        )

        Text(
            modifier = Modifier.padding(start = 15.dp, end = 40.dp),
            text = "Smart way!",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Black,
            lineHeight = 50.sp
        )

        Text(
            modifier = Modifier.padding(start = 15.dp, end = 5.dp, top = 30.dp),
            text = stringResource(R.string.sign_up_message2),
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            color = Black,
            lineHeight = 25.sp
        )


        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.default),
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(100.dp)
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
                Text(
                    modifier = Modifier.padding(top = MaterialTheme.spacing.defaultSmall),
                    text = stringResource(R.string.signup_welcome_message),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        brush = Brush.horizontalGradient(listOf(Black, Black))
                    )
                )
                InputText(modifier = Modifier.fillMaxWidth(),
                    label = "Username",
                    placeholder = stringResource(R.string.user_name),
                    icon = Icons.Outlined.Email,
                    value = "",
                    keyboardType = KeyboardType.Text,
                    errorMessage = "",
                    onTextChange = { })
                InputText(modifier = Modifier.fillMaxWidth(),
                    label = "Email",
                    placeholder = stringResource(R.string.email_placeholder),
                    icon = Icons.Outlined.Email,
                    value = "",
                    keyboardType = KeyboardType.Email,
                    errorMessage = "",
                    onTextChange = { })
                InputText(
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(R.string.password),
                    placeholder = stringResource(R.string.password_placeholder),
                    icon = Icons.Outlined.Lock,
                    value = "",
                    keyboardType = KeyboardType.Password,
                    errorMessage = "",
                    onTextChange = { },
                    isPassword = true
                )

                GradientButton(modifier = Modifier.fillMaxWidth(), onClick = {onSignUpClick() }) {
                    Text(text = stringResource(R.string.sign_up))
                }
                Row(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.extraSmall),
                ) {
                    Text(
                        text = "Already have an account?",
                        color = Black,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        modifier = Modifier.clickable {
                            onLoginClick()
                        },
                        text = stringResource(R.string.login),
                        color = DarkBlue,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold
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
private fun PreviewSignUpScreen() {
    SignUpScreen(
        NavHostController(LocalContext.current)
    )
}