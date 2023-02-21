package nl.pdik.level4.task2.repository

import android.content.Context
import nl.pdik.level4.task2.database.RockDao
import nl.pdik.level4.task2.database.RockPaperScissorsDatabase
import nl.pdik.level4.task2.models.Game

class GameRepository(context: Context) {
    private val RockDao: RockDao

    init {
        val database = RockPaperScissorsDatabase.getDatabase(context)
        RockDao = database!!.rockDao()
    }

    suspend fun insert(game: Game) = RockDao.insert(game)

    suspend fun delete(game: Game) = RockDao.delete(game)

    fun getGames() = RockDao.getGames()

    fun getWins() = RockDao.count("WIN")
    fun getDraws() = RockDao.count("DRAW")
    fun getLoses() = RockDao.count("LOSE")

    suspend fun deleteAll() = RockDao.deleteAll()

}
