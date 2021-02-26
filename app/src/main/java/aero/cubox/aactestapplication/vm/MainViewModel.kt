package aero.cubox.aactestapplication.vm

import aero.cubox.aactestapplication.AppDatabase
import aero.cubox.aactestapplication.Todo
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {
    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java, "todo-db"
    ).build()

    var todos: LiveData<List<Todo>>
    var newTodo : String?=null
    init {
        todos = getAll()
    }

    fun getAll(): LiveData<List<Todo>> {
        return db.todoDao().getAll()
    }


    suspend fun insert(todo: String){
        //워커스레드(백그라운드)에서 작동하게함. 코루틴으로 비동기화
        db.todoDao().insert(Todo(todo))
    }
}