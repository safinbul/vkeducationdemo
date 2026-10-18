package com.example.vkeducationdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.vkeducationdemo.ui.applist.AppListScreen
import com.example.vkeducationdemo.ui.theme.VKEducationDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VKEducationDemoTheme {
                AppListScreen()
            }
        }
    }
}
