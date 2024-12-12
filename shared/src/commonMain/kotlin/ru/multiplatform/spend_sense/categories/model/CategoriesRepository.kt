package ru.multiplatform.spend_sense.categories.model

import kotlinx.coroutines.flow.flow

class CategoriesRepository {

    fun getAllFlow() = flow { emit(
        List(20) { index ->
            Category.NONE.copy(
                id = index.toString(),
                title = "category $index"
            )
        }
    ) }

    suspend fun crateCategory(category: Category): Unit = Unit
}
