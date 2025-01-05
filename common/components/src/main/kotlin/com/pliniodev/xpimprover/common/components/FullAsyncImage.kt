package com.pliniodev.xpimprover.common.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.pliniodev.xpimprover.common.theme.CustomSpacing
import com.pliniodev.xpimprover.common.theme.RoundedShape
import com.pliniodev.xpimprover.common.theme.modifiers.modifyIfTrue

@Composable
fun FullAsyncImage(
    url: String,
    modifier: Modifier = Modifier,
    fillContent: Boolean = true,
    size: AsyncImageSize = AsyncImageSize.MEDIUM,
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(4.dp),
        border = BorderStroke(width = 1.dp, Color.Transparent),
        shape = RoundedShape.small
    ) {
        SubcomposeAsyncImage(
            model = url,
            contentDescription = "",
            modifier = Modifier
                .modifyIfTrue(fillContent) {
                    fillMaxWidth()
                }
                .size(size.size)
                .padding(CustomSpacing.xSmall)
                .clip(RoundedShape.small),
            contentScale = ContentScale.Crop
        ) {
            val state = painter.state
            if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                Progress(modifier = Modifier.fillMaxWidth())
            } else {
                SubcomposeAsyncImageContent()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FullDogImageTest() {
    FullAsyncImage(url = "")
}

enum class AsyncImageSize(val size: Dp) {
    SMALL(100.dp),
    MEDIUM(200.dp),
    LARGE(300.dp)
}

