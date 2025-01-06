package com.example.weleapai.features.onboarding.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.weleapai.R
import com.example.weleapai.ui.theme.Black
import com.example.weleapai.ui.theme.Purple
import com.example.weleapai.ui.theme.spacing
import com.example.weleapai.utils.GradientButton

@Composable
fun OnboardingScreen(controller: NavHostController) {

    val appName = stringResource(R.string.app_name)
    val subtitle = stringResource(R.string.explanation)
    val buttonText = stringResource(R.string.built_portfolio)
    val appIntro = stringResource(R.string.app_intro)
    val launchImage: Int = R.drawable.lauch_icon
    val roundIconTop: Int = R.drawable.ellipse_top
    val roundIconMiddle: Int = R.drawable.ellipse_midle
    val onClick = { controller.navigate("signup") }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        Image(
            modifier = Modifier
                .size(200.dp)
                .offset(x = -5.dp)
                .align(Alignment.TopStart),
            painter = painterResource(id = roundIconTop),
            contentDescription = "",
            contentScale = ContentScale.Fit
        )
        Image(
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.TopEnd)
                .offset(x = 50.dp, y = 100.dp),
            painter = painterResource(id = roundIconMiddle),
            contentDescription = "",
            contentScale = ContentScale.Fit,

            )

        Image(
            modifier = Modifier
                .height(300.dp)
                .widthIn(min = 0.dp, max = 250.dp)
                .align(Alignment.Center),
            painter = painterResource(id = launchImage),
            contentDescription = "",
            contentScale = ContentScale.Fit
        )

                Column(
                    verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.Bottom),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Transparent,
                                    Transparent
                                )
                            )
                        )
                        .padding(
                            top = MaterialTheme.spacing.default,
                            start = MaterialTheme.spacing.default,
                            end = MaterialTheme.spacing.default,
                            bottom = 20.dp
                        )
                ) {
                    Text(
                        text = appName,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Purple,
                    )
                    Text(
                        text = appIntro,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 20.sp,
                    )
                    Text(
                        text = subtitle,
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight.Normal,
                    )
                    Spacer(modifier = Modifier.height(15.dp))

                    GradientButton(
                        modifier = Modifier
                            .fillMaxWidth(),
                        onClick = onClick
                    ) {
                        Text(text = buttonText)
                    }
                }
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    OnboardingScreen(
        NavHostController(LocalContext.current)
    )
}