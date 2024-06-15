import android.util.Log
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.kipup.InventoryApplication

object AppViewModelProvider {
    val Factory = viewModelFactory {
        // Initializer for ItemEditViewModel

        // Initializer for ItemEntryViewModel
        initializer {
            ExoEntryViewModel(inventoryApplication().container.exoRepository)

        }
        Log.i("1","ExoEntryViewModel initialiser")
    }
}


fun CreationExtras.inventoryApplication(): InventoryApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as InventoryApplication)
