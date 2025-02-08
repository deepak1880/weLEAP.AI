package com.example.weleapai.features.auth.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.weleapai.ui.theme.DarkBlue
import com.example.weleapai.ui.theme.spacing
import com.example.weleapai.core.utils.GradientButton

@Composable
fun OnboardingScreen(controller: NavHostController) {

    val subtitle = stringResource(R.string.explanation)
    val buttonText = stringResource(R.string.built_portfolio)
    val appIntro = stringResource(R.string.app_intro)
    val launchImage: Int = R.drawable.bc
    val onClick = { controller.navigate("login") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = MaterialTheme.spacing.extraLarge,
                    start = MaterialTheme.spacing.medium,
                    end = MaterialTheme.spacing.medium
                ),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = appIntro,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 45.sp,
                color = DarkBlue
            )
            Text(
                text = subtitle,
                fontSize = 16.sp,
                lineHeight = 22.sp,
                fontWeight = FontWeight.SemiBold,
                color = Black
            )
        }

        Image(
            modifier = Modifier
                .height(500.dp)
                .widthIn(min = 0.dp, max = 350.dp)
                .padding(top = 60.dp)
                .align(Alignment.Center),
            painter = painterResource(id = launchImage),
            contentDescription = "",
            contentScale = ContentScale.Fit
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 40.dp, start = 15.dp, end = 15.dp)
        ) {
            GradientButton(
                modifier = Modifier.fillMaxWidth(),
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