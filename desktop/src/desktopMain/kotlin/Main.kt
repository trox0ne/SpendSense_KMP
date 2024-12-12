import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import ru.multiplatform.spend_sense.di.getKoinInstance
import ru.multiplatform.spend_sense.di.initKoin
import ru.multiplatform.spend_sense.root.compose.RootScreen
import ru.multiplatform.spend_sense.root.RootViewModel
import ru.multiplatform.spend_sense.sayHello

fun main() {

    initKoin()

    application {
        val state = rememberWindowState().apply { size = DpSize(1920.dp, 1080.dp) }
        Window(
            onCloseRequest = { exitApplication() },
            state = state,
            title = "SpendSense"
        ) {
            RootScreen()
        }

    }
}