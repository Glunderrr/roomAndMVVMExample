package files.app.roomexample.lesson2

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import files.app.roomexample.lesson2.db.MainDb
import files.app.roomexample.lesson2.db.NameEntity
import kotlinx.coroutines.launch

@Suppress("UNCHECKED_CAST")
class MainViewModel(private val dataBase: MainDb) : ViewModel() {

    val itemsList = dataBase.dao.getAllItems()

    val typedTextState = mutableStateOf("")


    fun insertItem() = viewModelScope.launch {
        dataBase.dao.insertItem(NameEntity(name = typedTextState.value))
        typedTextState.value = ""
    }

    fun deleteItem(nameEntity: NameEntity) = viewModelScope.launch {
        dataBase.dao.deleteItem(nameEntity)
    }

    companion object {
        val factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val database = (checkNotNull(extras[APPLICATION_KEY]) as App).database
                return MainViewModel(database) as T
            }
        }
    }

}