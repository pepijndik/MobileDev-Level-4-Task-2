package nl.pdik.level4.task2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import nl.pdik.level4.task2.models.Game
import nl.pdik.level4.task2.repository.GameRepository


class GameViewModel(application: Application) : AndroidViewModel(application) {
    private val gameRepository = GameRepository(application.applicationContext)
    private val mainScope = CoroutineScope(Dispatchers.Main)
    val gameBacklog = gameRepository.getGames()

    /**
     * Insert a game into the repository.
     */
    fun NewGame(game: Game) {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                gameRepository.insert(game)
            }

        }
    }

    /**
     * Delete the gameLogs from the repository.
     */
    fun deleteGameLogs() {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                gameRepository.deleteAll()
            }
        }
    }

    /**
     * Delete a game from the repository.
     */
    fun deleteGame(game: Game) {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                gameRepository.delete(game)
            }
        }
    }
}
