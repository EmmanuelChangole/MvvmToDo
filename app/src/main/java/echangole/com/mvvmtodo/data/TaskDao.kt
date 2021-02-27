package echangole.com.mvvmtodo.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao
{
     @Query("SELECT * FROM task_table where name Like '%' || :searchQuery ||'%' ORDER BY important DESC")
    fun getTasks(searchQuery:String):Flow<List<Task>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task:Task)
    @Update()
    suspend fun update(task: Task)
    @Delete()
    suspend fun delete(task: Task)
    /*@Query("select * from task_table")
     fun getTasks():Flow<List<Task>>*/



}