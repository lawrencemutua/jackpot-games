package com.jackpotgameslawi.Model

data class jackpot(
    val game: String,
    val league: String,
    val time: String,
    val tip: String
){ constructor() : this(
    "",
    "",
    "",
    ""
)

}
