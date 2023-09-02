package files.app.roomexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import files.app.roomexample.lesson2.MainScreen


/*@Suppress("UNCHECKED_CAST")*/
class MainActivity : ComponentActivity() {
    //Lesson 1
    /*    private val db by lazy {
            Room.databaseBuilder(
                applicationContext,
                ContactDatabase::class.java,
                "contacts.db"
            ).build()
        }
        private val viewModel by viewModels<ContactViewModel>(
            factoryProducer = {
                object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return ContactViewModel(db.dao) as T
                                }
            }    )*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Lesson 1
            /*          val state by viewModel.state.collectAsState()
                        ContactScreen(state = state, onEvent = viewModel::onEvent)*/
            MainScreen()

        }
    }
}