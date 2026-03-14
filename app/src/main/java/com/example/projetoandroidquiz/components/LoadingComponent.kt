package com.example.projetoandroidquiz.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.projetoandroidquiz.R

@Composable
fun LoadingComponent(
    isLoading: Boolean
) {
    if (isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.loadging_background),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxHeight()
                    .aspectRatio(7f / 7f),
                contentScale = ContentScale.Crop
            )
            CircularProgressIndicator()
        }
    }
}