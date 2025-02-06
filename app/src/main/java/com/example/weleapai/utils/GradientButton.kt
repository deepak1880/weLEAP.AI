package com.example.weleapai.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weleapai.ui.theme.DarkBlue
import com.example.weleapai.ui.theme.Purple
import com.example.weleapai.ui.theme.Shapes
import com.example.weleapai.ui.theme.Transparent


@Composable
fun GradientButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Transparent
        ),
        shape = RectangleShape,
        modifier = Modifier
            .then(modifier)
            .clip(Shapes.roundedCornerSmall)
            .height(50.dp)
            .background(
                brush = Brush.linearGradient(
                    listOf(
                        DarkBlue,
                        DarkBlue
                    )
                ),
            ),
        content = content
    )
}

@Preview
@Composable
private fun ButtonPrev() {
    GradientButton(onClick = {  }) {
        Text(text = "Hello world")
    }
}