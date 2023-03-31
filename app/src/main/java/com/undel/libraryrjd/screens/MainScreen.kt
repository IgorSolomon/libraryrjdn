package com.undel.libraryrjd.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.undel.libraryrjd.MainViewModal

@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModal){
    var allDoc = viewModel.allDocument.observeAsState(listOf()).value
    allDoc.forEach { Log.d("checkData", "ID: ${it}") }
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(text = "text")


    }

}


















