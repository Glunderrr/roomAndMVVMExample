package files.app.roomexample.lesson2.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [
        NameEntity::class
    ], version = 1
)
abstract class MainDb : RoomDatabase() {
    abstract val dao: DAO
    companion object {
        fun createDB(context: Context): MainDb {
            return Room.databaseBuilder(
                context,
                MainDb::class.java,
                "test_dp"
            ).build()
        }
    }
}
