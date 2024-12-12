package ru.multiplatform.spend_sense.categories.list

import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDateTime
import ru.multiplatform.spend_sense.base.BaseViewModel
import ru.multiplatform.spend_sense.base.BaseViewState
import ru.multiplatform.spend_sense.categories.creation.CreateCategoryData
import ru.multiplatform.spend_sense.categories.creation.toCategory
import ru.multiplatform.spend_sense.categories.model.CategoriesRepository
import ru.multiplatform.spend_sense.categories.model.Category
import ru.multiplatform.spend_sense.extensions.now

class CategoriesViewModel(
    private val repository: CategoriesRepository
) : BaseViewModel<CategoriesViewModel.State, Nothing>() {

    init {
        activate()
    }

    fun createCategory(
        data: CreateCategoryData
    ) {
        viewModelScope.launch {
            val currentTime = LocalDateTime.now()
            repository.crateCategory(data.toCategory(currentTime))
        }
    }

    private fun activate() {
        repository.getAllFlow().onEach {
            updateState { copy(categories = it) }
        }.launchIn(viewModelScope)
    }

    data class State(
        val categories: List<Category>
    ) : BaseViewState {
        companion object {
            val NONE = State(emptyList())
        }
    }

    override fun initialState() = State.NONE
}
