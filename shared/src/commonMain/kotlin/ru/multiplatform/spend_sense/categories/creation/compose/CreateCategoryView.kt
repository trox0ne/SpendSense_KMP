package ru.multiplatform.spend_sense.categories.creation.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.stringResource
import ru.multiplatform.spend_sense.common.ui.atoms.AppTextField
import ru.multiplatform.spend_sense.common.ui.atoms.BottomModalContainer
import ru.multiplatform.spend_sense.MR
import ru.multiplatform.spend_sense.categories.creation.CreateCategoryData
import ru.multiplatform.spend_sense.common.ui.atoms.AppButton

@Composable
fun CreateCategoryView(isExpand: Boolean,
    createListener: (CreateCategoryData) -> Unit
) {
    val focusRequester by remember { mutableStateOf(FocusRequester()) }
    val focusManager = LocalFocusManager.current

    var title by remember { mutableStateOf("") }
    var subtitle by remember { mutableStateOf("") }
    var rColor by remember { mutableFloatStateOf(0.3f) }
    var gColor by remember { mutableFloatStateOf(0.6f) }
    var bColor by remember { mutableFloatStateOf(0.9f) }

    LaunchedEffect(isExpand) {
        if (isExpand) {
            focusRequester.requestFocus()
        } else {
            focusManager.clearFocus()
            title = ""
            subtitle = ""
            rColor = 0.3f
            gColor = 0.6f
            bColor = 0.9f
        }
    }

    BottomModalContainer {
        AppTextField(
            title,
            stringResource(MR.strings.title_category_placeholder),
            modifier = Modifier
                .focusRequester(focusRequester)
                .fillMaxWidth()
        ) {
            title = it
        }

        Spacer(modifier = Modifier.height(16.dp))

        AppTextField(
            subtitle,
            stringResource(MR.strings.subtitle_category_placeholder),
            modifier = Modifier.fillMaxWidth()
        ) {
            subtitle = it
        }

        Spacer(modifier = Modifier.height(16.dp))

        ColorBox(rColor, gColor, bColor) {
            Column {
                ColorSlider(Color.Red, rColor) { rColor = it }
                ColorSlider(Color.Green, gColor) { gColor = it }
                ColorSlider(Color.Blue, bColor) { bColor = it }
            }
        }

        AppButton(stringResource(MR.strings.save)) {
            createListener(
                CreateCategoryData(
                    title,
                    subtitle,
                    Color(rColor, gColor, bColor).toArgb().toString())
            )
        }
    }
}