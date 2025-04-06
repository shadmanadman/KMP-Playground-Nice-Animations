package org.kmp.playground.nice.animations

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseInExpo
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.EaseInOutQuad
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun PaymentProgressStatus() {
    var isToggle by remember { mutableStateOf(false) }

    val progressBoxWidth = 500.dp
    val progressBoxHeight = 300.dp

    var payButtonAlpha = 1f
    val payButtonAnimateY by animateDpAsState(
        targetValue = if (isToggle) 180.dp else 0.dp,
        animationSpec = tween(durationMillis = 800, easing = EaseIn),
        label = "pay button Y offset animation",
        finishedListener = {
            0f
        }
    )
    val payButtonBackgroundColor = if (isToggle) Color.White else Color(0xFF8F87F1)
    var payButtonTextAlpha by remember { mutableStateOf(1f) }
    val payButtonAnimateColor by animateColorAsState(
        targetValue = payButtonBackgroundColor,
        animationSpec = tween(durationMillis = 800, easing = EaseInExpo),
        label = "pay button background color",
        finishedListener = { payButtonTextAlpha = 0f }
    )
    val payButtonBorderColor = if (isToggle) Color(0xFF8F87F1) else Color.Transparent
    val payButtonAnimateBorderColor by animateColorAsState(
        targetValue = payButtonBorderColor,
        animationSpec = tween(durationMillis = 800, easing = EaseInExpo),
        label = "pay button background color"
    )


    // Card shape turn around animation
    val rotation = remember { Animatable(0f) }
    LaunchedEffect(isToggle) {
        // First turn
        rotation.animateTo(
            targetValue = 180f,
            animationSpec = tween(durationMillis = 1000)
        )
        rotation.animateTo(
            targetValue = 0f,
            animationSpec = tween(durationMillis = 1000)
        )
    }
    val cardShapeScaleValue = if (isToggle) 1f else 0f
    val cardShapeAnimateScale by animateFloatAsState(
        targetValue = cardShapeScaleValue,
        animationSpec = tween(durationMillis = 800, easing = EaseInExpo),
        label = "card shape scale animation"
    )

    val cardShapeMoveY = if (isToggle) 100.dp else 0.dp
    val cardShapeAnimateY by animateDpAsState(
        targetValue = cardShapeMoveY,
        animationSpec = tween(durationMillis = 1000, delayMillis = 800, easing = EaseInExpo),
        label = "card shape scale animation"
    )
    val cardShapeMoveX = if (isToggle) 220.dp else 0.dp
    val cardShapeAnimateX by animateDpAsState(
        targetValue = cardShapeMoveX,
        animationSpec = tween(durationMillis = 1000, delayMillis = 800, easing = EaseInExpo),
        label = "card shape scale animation"
    )

    val cardShapeMoveXToPay = if (isToggle) 520.dp else 0.dp
    val cardShapeAnimateXToPay by animateDpAsState(
        targetValue = cardShapeMoveXToPay,
        animationSpec = tween(durationMillis = 3000, delayMillis = 1500, easing = EaseInOutQuad),
        label = "card shape scale animation"
    )

    val cardShapeMoveXFasterAtEnd = if (isToggle) 660.dp else 0.dp
    val cardShapeAnimateXFasterAtEnd by animateDpAsState(
        targetValue = cardShapeMoveXFasterAtEnd,
        animationSpec = tween(durationMillis = 400, delayMillis = 4000, easing = EaseInOutQuad),
        label = "card shape scale animation"
    )

    // Payment Success animation
    val payButtonChangeToCircleAnimation by animateDpAsState(
        targetValue = if (isToggle) 100.dp else 12.dp,
        animationSpec = tween(durationMillis = 500, delayMillis = 4500, easing = EaseInOutQuad),
        label = "card shape scale animation"
    )
    val payButtonMoveYAnimation by animateDpAsState(
        targetValue = if (isToggle) 200.dp else 0.dp,
        animationSpec = tween(durationMillis = 500, delayMillis = 5000, easing = EaseInOutQuad),
        label = "card shape scale animation"
    )
    val payButtonHeartBitAnimation by animateFloatAsState(
        targetValue = if (isToggle) 1.3f else 1f,
        animationSpec = infiniteRepeatable(
            tween(
                durationMillis = 500,
                delayMillis = 5500,
                easing = EaseInOut
            ), repeatMode = RepeatMode.Reverse
        ),
        label = "card shape scale animation"
    )

    val payButtonReflectionHeartBitAnimation by animateFloatAsState(
        targetValue = if (isToggle) 1.5f else 1f,
        animationSpec = infiniteRepeatable(
            tween(
                durationMillis = 800,
                delayMillis = 6000,
                easing = EaseInOut
            ), repeatMode = RepeatMode.Reverse
        ),
        label = "card shape scale animation"
    )

    val payButtonReflectionAlphaAnimation by animateFloatAsState(
        targetValue = if (isToggle) 1f else 0f,
        animationSpec = tween(durationMillis = 500, delayMillis = 5500, easing = EaseInExpo),
        label = "card shape scale animation"
    )

    val checkIconSizeAnimation by animateDpAsState(
        targetValue = if (isToggle) 100.dp else 0.dp,
        animationSpec = tween(durationMillis = 500, delayMillis = 6500, easing = EaseInOutQuad),
        label = "card shape scale animation"
    )


    val hidePaymentDetailsMessageYAnimation by animateDpAsState(
        targetValue = if (isToggle) 200.dp else 110.dp,
        animationSpec = tween(durationMillis = 500, easing = EaseInOutQuad),
        label = "card shape scale animation"
    )

    val hidePaymentDetailsMessageAlphaAnimation by animateFloatAsState(
        targetValue = if (isToggle) 0f else 1f,
        animationSpec = tween(durationMillis = 1000, easing = EaseInOutQuad),
        label = "card shape scale animation"
    )


    val showPaymentSuccessMessageYAnimation by animateDpAsState(
        targetValue = if (isToggle) 140.dp else 200.dp,
        animationSpec = tween(durationMillis = 1000, delayMillis = 6000, easing = EaseInOutQuad),
        label = "card shape scale animation"
    )

    val showPaymentSuccessMessageAlphaAnimation by animateFloatAsState(
        targetValue = if (isToggle) 1f else 0f,
        animationSpec = tween(durationMillis = 800, delayMillis = 6000, easing = EaseInOutQuad),
        label = "card shape scale animation"
    )

    val rotationForCheckIcon = remember { Animatable(0f) }
    LaunchedEffect(isToggle) {
        delay(6500)
        // First turn
        rotationForCheckIcon.animateTo(
            targetValue = 180f,
            animationSpec = tween(durationMillis = 500)
        )
        rotationForCheckIcon.animateTo(
            targetValue = 0f,
            animationSpec = tween(durationMillis = 500)
        )
    }
    Box(
        modifier = Modifier.size(progressBoxWidth, progressBoxHeight),
        contentAlignment = Alignment.Center
    ) {
        // Card shape
        CardShape(modifier = Modifier.graphicsLayer { rotationX = rotation.value }
            .scale(cardShapeAnimateScale).offset(y = cardShapeAnimateY, x = -cardShapeAnimateX)
            .offset(x = cardShapeAnimateXToPay).offset(x = cardShapeAnimateXFasterAtEnd))

        // Pay button
        PayButton(
            textAlpha = payButtonTextAlpha,
            modifier =
                Modifier.offset(y = payButtonAnimateY).alpha(payButtonAlpha)
                    .offset(y = -payButtonMoveYAnimation)
                    .graphicsLayer {
                        scaleX = payButtonHeartBitAnimation
                        scaleY = payButtonHeartBitAnimation
                    }
                    .border(
                        width = 5.dp,
                        color = payButtonAnimateBorderColor,
                        shape = RoundedCornerShape(payButtonChangeToCircleAnimation)
                    ).background(
                        payButtonAnimateColor,
                        shape = RoundedCornerShape(payButtonChangeToCircleAnimation)
                    ),
            onClickListener = { isToggle = !isToggle },
            checkCircleModifier = Modifier.size(checkIconSizeAnimation)
                .graphicsLayer { rotationY = rotationForCheckIcon.value }
        )

        // Reflection pay button
        PayButton(
            textAlpha = payButtonTextAlpha,
            modifier =
                Modifier.offset(y = payButtonAnimateY).alpha(payButtonAlpha)
                    .offset(y = -payButtonMoveYAnimation)
                    .alpha(payButtonReflectionAlphaAnimation)
                    .graphicsLayer {
                        scaleX = payButtonReflectionHeartBitAnimation
                        scaleY = payButtonReflectionHeartBitAnimation
                    }
                    .border(
                        width = 5.dp,
                        color = payButtonAnimateBorderColor,
                        shape = RoundedCornerShape(payButtonChangeToCircleAnimation)
                    ).background(
                        payButtonAnimateColor,
                        shape = RoundedCornerShape(payButtonChangeToCircleAnimation)
                    ),
            onClickListener = { isToggle = !isToggle },
            checkCircleModifier = Modifier.size(checkIconSizeAnimation)
                .graphicsLayer { rotationY = rotationForCheckIcon.value }
        )


        PaymentDetailsMessage(
            modifier = Modifier.offset(y = hidePaymentDetailsMessageYAnimation)
                .alpha(hidePaymentDetailsMessageAlphaAnimation)
        )
        PaymentSuccessMessage(
            modifier = Modifier.offset(y = showPaymentSuccessMessageYAnimation)
                .alpha(showPaymentSuccessMessageAlphaAnimation)
        )
    }

}

@Composable
fun PaymentDetailsMessage(modifier: Modifier) {
    Text(
        modifier = modifier,
        text = "Your payment amount: 315$",
        color = Color.Black,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun PaymentSuccessMessage(modifier: Modifier) {
    Text(
        text = "Thank you for your payment\nThe details will be sent to your email",
        textAlign = TextAlign.Center,
        modifier = modifier,
        color = Color.Black,
        lineHeight = 40.sp,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold
    )
}

@Preview
@Composable
fun PayButton(
    modifier: Modifier,
    checkCircleModifier: Modifier,
    textAlpha: Float = 1f,
    onClickListener: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .clickable(onClick = onClickListener)
            .size(300.dp, 150.dp).clip(RoundedCornerShape(12.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            "Pay with Paypal",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.alpha(textAlpha)
        )
        Icon(
            imageVector = Icons.Rounded.Check,
            tint = Color(0xFF8F87F1),
            contentDescription = null,
            modifier = checkCircleModifier.size(50.dp)
        )
    }

}

@Preview
@Composable
fun CardShape(modifier: Modifier) {
    Box(
        modifier = modifier
            .size(300.dp, 150.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(

                Color(0xFF8F87F1)
            )


    ) {
        Box(
            modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 20.dp)
                .size(300.dp, 30.dp).background(Color.White)
        )
    }
}

@Preview
@Composable
fun TwoColoredBorderBox(modifier: Modifier) {
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