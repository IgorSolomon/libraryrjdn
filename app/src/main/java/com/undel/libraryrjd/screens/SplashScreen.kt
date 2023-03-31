package com.undel.libraryrjd.screens

import android.os.Build.VERSION.SDK_INT

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.undel.libraryrjd.MainViewModal
import com.undel.libraryrjd.R
import com.undel.libraryrjd.navigation.Screens
import com.undel.libraryrjd.ui.theme.LibraryrjdTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController, viewModel: MainViewModal){
    LaunchedEffect(key1 = true){
        viewModel.getAllDoc()
        delay(3000)
        navController.popBackStack()
        navController.navigate(Screens.Main.route)
    }
    GifImage()
}



@Composable
fun GifImage(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()
    Column(
        modifier = Modifier
            .fillMaxHeight(),  //important
        verticalArrangement  = Arrangement.Center,
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(context).data(data = R.drawable.gggg).apply(block = {
                    size(Size.ORIGINAL)
                }).build(), imageLoader = imageLoader
            ),
            contentDescription = null,
            modifier = modifier
                .fillMaxSize(),


            )}
}


@Composable
@Preview(showBackground = true)
fun PrevSplash() {
    LibraryrjdTheme{
        GifImage()
    }

}




















