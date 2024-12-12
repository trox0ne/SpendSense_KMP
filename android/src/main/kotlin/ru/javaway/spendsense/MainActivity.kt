package ru.javaway.spendsense

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.multiplatform.spend_sense.di.getKoinInstance
import ru.multiplatform.spend_sense.root.compose.RootScreen
import ru.multiplatform.spend_sense.root.RootViewModel

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RootScreen()
        }
    }
}