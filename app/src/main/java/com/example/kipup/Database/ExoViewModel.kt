import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.collectAsState
import com.example.kipup.Database.Exo
import com.example.kipup.Database.ExoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ExoEntryViewModel(private val exoRepository: ExoRepository) : ViewModel() {

    /**
     * Holds current item ui state
     */
    var exoUiState by mutableStateOf(ExoUiState())
        private set

    /**
     * Updates the [itemUiState] with the value provided in the argument. This method also triggers
     * a validation for input values.
     */
    fun updateUiState(exoDetails: ExoDetails) {
        exoUiState =
            ExoUiState(exoDetails = exoDetails, isEntryValid = validateInput(exoDetails))
    }

    private fun validateInput(uiState: ExoDetails = exoUiState.exoDetails): Boolean {
        return with(uiState) {
            nom.isNotBlank() && muscle.isNotBlank()
        }
    }

    suspend fun saveItem() {
        if (validateInput()) {
            exoRepository.insertExo(exoUiState.exoDetails.toExo())
        }
    }
}

data class ExoUiState(
    val exoDetails: ExoDetails = ExoDetails(),
    val isEntryValid: Boolean = false
)

data class ExoDetails(
    val id: Int = 0,
    val nom: String = "",
    val muscle: String = "",
)

fun ExoDetails.toExo(): Exo = Exo(
    exoId = id,
    nom = nom,
    muscle = muscle
)

fun Exo.toExoUiState(isEntryValid: Boolean = false): ExoUiState = ExoUiState(
    exoDetails = this.toExoDetails(),
    isEntryValid = isEntryValid
)

fun Exo.toExoDetails(): ExoDetails = ExoDetails(
    id = exoId,
    nom = nom,
    muscle = muscle
)




