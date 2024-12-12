package ru.multiplatform.spend_sense.categories.list.compose

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.zIndex
import kotlinx.coroutines.launch
import ru.multiplatform.spend_sense.categories.creation.compose.CreateCategoryView
import ru.multiplatform.spend_sense.categories.list.CategoriesViewModel
import ru.multiplatform.spend_sense.categories.model.Category
import ru.multiplatform.spend_sense.common.ui.atoms.FAB
import ru.multiplatform.spend_sense.common.ui.atoms.RootBox
import ru.multiplatform.spend_sense.di.getKoinInstance

@Composable
fun BoxScope.CategoriesScreen(
    viewModel: CategoriesViewModel
) {

    val sheetState = rememberModalBottomSheetState(
        ModalBottomSheetValue.Hidden, skipHalfExpanded = true
    )

    val scope = rememberCoroutineScope()

    ModalBottomSheetLayout(
        sheetContent = {
            CreateCategoryView(
                isExpand = sheetState.currentValue == ModalBottomSheetValue.Expanded
            ) { data ->
                scope.launch { sheetState.hide() }
                viewModel.createCategory(data)
            }
        },
        sheetState = sheetState,
        sheetBackgroundColor = Color.Transparent,
        modifier = Modifier.zIndex(1f)
    ) {
        RootBox {
            CategoriesListView(
                viewModel = viewModel,
                modifier = Modifier
            ) {
                    category: Category ->
            }

            FAB {
                scope.launch { sheetState.show() }
            }
        }
    }
}