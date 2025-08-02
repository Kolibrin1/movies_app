package com.example.moviesapp.movie_detail.domain.repository

import com.example.moviesapp.movie.domain.models.Movie
import com.example.moviesapp.movie_detail.domain.models.MovieDetail
import com.example.moviesapp.utils.Response
import kotlinx.coroutines.flow.Flow

interface MovieDetailRepository {
    fun fetchMovieDetail(movield: Int): Flow<Response<MovieDetail>>
    fun fetchMovie(): Flow<Response<List<Movie>>>
}