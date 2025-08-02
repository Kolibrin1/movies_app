package com.example.moviesapp.movie.domain.repository

import com.example.moviesapp.movie.domain.models.Movie
import com.example.moviesapp.utils.Response
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun fetchDiscoverMovie() : Flow<Response<List<Movie>>>
    fun fetchTrendingMovie() : Flow<Response<List<Movie>>>
}