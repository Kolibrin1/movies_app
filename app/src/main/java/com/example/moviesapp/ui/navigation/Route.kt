package com.example.moviesapp.ui.navigation

import com.example.moviesapp.utils.Constants

sealed class Route {
    data class HomeScreen(val route: String = "homeScreen") : Route()
    data class FilmScreen(
        val route: String = "FilmScreen",
        val routeWithArgs: String = "$route/{${Constants.MOVIE_ID}}"
    ) : Route() {
        fun getRoutWithArgs(id: Int): String {
            return "$route/$id"
        }
    }
}