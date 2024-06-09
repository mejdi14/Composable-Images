import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import composableimages.composeapp.generated.resources.Res
import composableimages.composeapp.generated.resources.compose_multiplatform
import composableimages.composeapp.generated.resources.side1
import composableimages.composeapp.generated.resources.side10
import composableimages.composeapp.generated.resources.side13
import composableimages.composeapp.generated.resources.side14
import composableimages.composeapp.generated.resources.side15
import composableimages.composeapp.generated.resources.side16
import composableimages.composeapp.generated.resources.side17
import composableimages.composeapp.generated.resources.side18
import composableimages.composeapp.generated.resources.side19
import composableimages.composeapp.generated.resources.side20
import composableimages.composeapp.generated.resources.side21
import composableimages.composeapp.generated.resources.side22
import composableimages.composeapp.generated.resources.side23
import composableimages.composeapp.generated.resources.side25
import composableimages.composeapp.generated.resources.side30
import composableimages.composeapp.generated.resources.side31
import composableimages.composeapp.generated.resources.side32
import composableimages.composeapp.generated.resources.side33
import composableimages.composeapp.generated.resources.side4
import composableimages.composeapp.generated.resources.side5
import composableimages.composeapp.generated.resources.side6
import composableimages.composeapp.generated.resources.side7
import composableimages.composeapp.generated.resources.side8
import composableimages.composeapp.generated.resources.side9
import kotlinx.coroutines.delay

@Composable
@Preview
fun App() {
    MaterialTheme {
        val listImages = listOf(
            Res.drawable.side1,
            Res.drawable.side4,
            Res.drawable.side5,
            Res.drawable.side6,
            Res.drawable.side7,
            Res.drawable.side8,
            Res.drawable.side9,
            Res.drawable.side10,
            Res.drawable.side13,
            Res.drawable.side14,
            Res.drawable.side15,
            Res.drawable.side16,
            Res.drawable.side17,
            Res.drawable.side18,
            Res.drawable.side19,
            Res.drawable.side20,
            Res.drawable.side21,
            Res.drawable.side22,
            Res.drawable.side23,
            Res.drawable.side25,
            Res.drawable.side30,
            Res.drawable.side31,
            Res.drawable.side32,
            Res.drawable.side33,
        )

        Box(modifier = Modifier.fillMaxSize()) {
            for (i in 20 downTo 0) {
                val isVisible = remember { mutableStateOf(false) }
                val isTransitionStarted = remember { mutableStateOf(false) }
                val translationXValue by animateFloatAsState(
                    targetValue = if (isTransitionStarted.value) -20f * i else 0f,
                    animationSpec = tween(durationMillis = 300)
                )
                val translationYValue by animateFloatAsState(
                    targetValue = if (isVisible.value) 0f else 1000f,
                    animationSpec = tween(durationMillis = 500)
                )

                val alphaValue by animateFloatAsState(
                    targetValue = if (isVisible.value) 1f else 0f,
                    animationSpec = tween(durationMillis = 500)
                )
                LaunchedEffect(i) {
                    delay(60L * i)   // Delay each card by 200 milliseconds
                    isVisible.value = true
                    delay(200L)
                    isTransitionStarted.value = true
                }

                Image(
                    painter = painterResource(listImages[i]),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.align(Alignment.Center)
                        .height(200.dp)
                        .width(180.dp)
                        .graphicsLayer {
                            translationX = translationXValue
                            translationY = translationYValue
                            alpha = alphaValue
                        }, contentDescription = null
                )
            }
        }
    }
}


