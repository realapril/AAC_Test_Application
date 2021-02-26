package aero.cubox.aactestapplication

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDao {
    //suspend가 붙으면 무조건 코루틴안에서만 호출가능
    @Query("SELECT * FROM Todo")
    fun getAll(): LiveData<List<Todo>>

    @Insert
    suspend fun insertAll(vararg todo: Todo)

    @Insert
    suspend fun insert(todo: Todo)

    @Update
    suspend fun update(todo: Todo)

    @Delete
    suspend fun delete(todo: Todo)
}