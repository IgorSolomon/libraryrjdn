package com.undel.libraryrjd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.undel.libraryrjd.navigation.SetupNavHost
import com.undel.libraryrjd.ui.theme.LibraryrjdTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibraryrjdTheme {
                val navController = rememberNavController()
                val viewModel = hiltViewModel<MainViewModal>()
                SetupNavHost(navController = navController, viewModel = viewModel)

            }


        }
    }
}

