package echangole.com.mvvmtodo.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task:Task)
    @Update()
    suspend fun update(task: Task)
    @Delete()
    suspend fun delete(task: Task)
    @Query("select * from task_table")
     fun getTasks():Flow<List<Task>>



}