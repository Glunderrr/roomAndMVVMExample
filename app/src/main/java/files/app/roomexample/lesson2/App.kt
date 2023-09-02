package files.app.roomexample.lesson2

import android.app.Application
import files.app.roomexample.lesson2.db.MainDb

class App : Application() {
    val database by lazy { MainDb.createDB(this) }
}