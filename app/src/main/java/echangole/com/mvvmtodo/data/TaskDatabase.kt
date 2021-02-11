package echangole.com.mvvmtodo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import echangole.com.mvvmtodo.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [Task::class],version = 1)
abstract class TaskDatabase:RoomDatabase()
{
   abstract fun taskDao():TaskDao
   class CallBack @Inject constructor (
           private val database:Provider<TaskDatabase>,
        @ApplicationScope  private val applicationScope:CoroutineScope
   ) :RoomDatabase.Callback()
   {
      override fun onCreate(db: SupportSQLiteDatabase) {
         super.onCreate(db)
         //database operation
         val dao=  database.get().taskDao()
         applicationScope.launch {
            dao.insert(Task("washing dish"))
            dao.insert(Task("Cleaning"))
            dao.insert(Task("Writing python code",important = true))
            dao.insert(Task("Watching movies",completed = true))
            dao.insert(Task("Doing some assignment"))



         }


      }
   }

}