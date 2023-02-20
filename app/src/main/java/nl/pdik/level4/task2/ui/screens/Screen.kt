package nl.pdik.level4.task2.ui.screens

import androidx.annotation.StringRes
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.ui.graphics.vector.ImageVector
import nl.pdik.level4.task2.R

sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int,
    val icon: Int
) {
    object PlayScreen : Screen(
        "play", R.string.bottom_nav_play, R.drawable.gamepad
    )

    object HistoryScreen :
        Screen("history", R.string.bottom_nav_history, R.drawable.baseline_history_24)
}
