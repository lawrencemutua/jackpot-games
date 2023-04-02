package com.jackpotgameslawi.Model

data class game (
    val leagueTime: String,
    val homeTeam: String,
    val awayTeam: String,
    val awayTeamImage: String,
    val homeTeamImage: String,
    val tip: String,
    val result: String,
    val odd: String


        ){
    constructor():this(
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        ""
    )}