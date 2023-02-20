package nl.pdik.level4.task2.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "game")
data class Game(

    @ColumnInfo(name = "result")
    var result: GameResult,

    @ColumnInfo(name = "computer_move")
    var computer_move: GameMove,

    @ColumnInfo(name = "player_move")
    var player_move: GameMove,

    @ColumnInfo(name = "played")
    var played: Date,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0

)
