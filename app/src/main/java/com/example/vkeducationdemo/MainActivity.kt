package com.example.vkeducationdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.vkeducationdemo.ui.theme.VKEducationDemoTheme
import com.example.vkeducationdemo.utils.dialPhone
import com.example.vkeducationdemo.utils.openSecondActivity
import com.example.vkeducationdemo.utils.shareText
import com.example.vkeducationdemo.utils.validateNotEmpty
import com.example.vkeducationdemo.utils.validatePhone

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VKEducationDemoTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val context = LocalContext.current
    var text by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    fun updateError(newError: String?) {
        errorMessage = newError
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InputField(
                text = text,
                error = errorMessage,
                onTextChanged = {
                    text = it
                    errorMessage = null
                }
            )
            Spacer(modifier = Modifier.height(24.dp))
            ActionButtons(
                onOpenSecond = {
                    validateNotEmpty(text)?.let { return@ActionButtons updateError(it) }
                    context.openSecondActivity(text.trim())
                },
                onDial = {
                    validatePhone(text)?.let { return@ActionButtons updateError(it) }
                    context.dialPhone(text.trim())
                },
                onShare = {
                    validateNotEmpty(text)?.let { return@ActionButtons updateError(it) }
                    context.shareText(text.trim())
                }
            )
        }
    }
}

@Composable
private fun InputField(
    text: String,
    error: String?,
    onTextChanged: (String) -> Unit
) {
    OutlinedTextField(
        value = text,
        onValueChange = onTextChanged,
        label = { Text("Введите текст или номер телефона") },
        isError = error != null,
        modifier = Modifier.fillMaxWidth(),
        singleLine = true
    )
    error?.let {
        Text(
            text = it,
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
        )
    }
}

@Composable
private fun ActionButtons(
    onOpenSecond: () -> Unit,
    onDial: () -> Unit,
    onShare: () -> Unit
) {
    Button(
        onClick = onOpenSecond,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Открыть вторую Activity")
    }
    Spacer(modifier = Modifier.height(12.dp))
    OutlinedButton(
        onClick = onDial,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Позвонить другу")
    }
    Spacer(modifier = Modifier.height(12.dp))
    OutlinedButton(
        onClick = onShare,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Поделиться текстом")
    }
}