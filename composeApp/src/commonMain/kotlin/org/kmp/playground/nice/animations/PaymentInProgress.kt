package org.kmp.playground.nice.animations

import androidx.annotation.Size
import androidx.compose.animation.core.EaseInBounce
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun PaymentProgressStatus() {
    val isToggle by remember { mutableStateOf(false) }

    val sliderSizeWidth = 250.dp
    val sliderSizeHeight = 180.dp

    val borderBoxYOffset = if (isToggle) 0.dp else sliderSizeHeight
    val borderBoxAnimateY by animateDpAsState(
        targetValue = borderBoxYOffset,
        animationSpec = tween(durationMillis = 1000, easing = EaseInBounce),
        label = "border box Y offset animation"
    )

    Box(modifier = Modifier.size(500.dp, 300.dp)) {
        TwoColoredBorderBox(
            Modifier.size(sliderSizeWidth, sliderSizeHeight).offset(y = borderBoxAnimateY)
        )
        PayButton(onClickListener = { isToggle != isToggle })
    }

}

@Preview
@Composable
fun PayButton(onClickListener: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .clickable(onClick = onClickListener)
            .size(200.dp, 100.dp).clip(RoundedCornerShape(12.dp)).background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFF8F87F1),
                        Color(0xffFED2E2)
                    )
                )
            ), contentAlignment = Alignment.Center
    ) {
        Text("Pay", fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}

@Preview
@Composable
fun CardShape() {
    Box(
        modifier = Modifier
            .size(200.dp, 100.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFF8F87F1),
                        Color(0xffFED2E2)
                    )
                )
            )
    ) {
        Box(
            modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 20.dp)
                .size(200.dp, 30.dp).background(Color.White)
        )
    }
}

@Preview
@Composable
fun TwoColoredBorderBox(
    modifier: Modifier = Modifier.size(250.dp, 100.dp)
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp))
            .drawBehind {
                val strokeWidth = 15.dp.toPx()
                val width = size.width
                val height = size.height

                // Draw top border
                drawLine(
                    color = Color(0xFFE9A5F1),
                    start = Offset(0f, 0f),
                    end = Offset(width, 0f),
                    strokeWidth = strokeWidth
                )
                // Draw left border
                drawLine(
                    color = Color(0xFFE9A5F1),
                    start = Offset(0f, 0f),
                    end = Offset(0f, height),
                    strokeWidth = strokeWidth
                )
                // Draw right border
                drawLine(
                    color = Color(0xFFE9A5F1),
                    start = Offset(width, 0f),
                    end = Offset(width, height),
                    strokeWidth = strokeWidth
                )
            }

    )
}