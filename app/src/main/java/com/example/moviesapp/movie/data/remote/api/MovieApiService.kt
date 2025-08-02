package com.example.moviesapp.movie.data.remote.api

import com.example.moviesapp.movie.data.remote.models.MovieDto
import com.example.moviesapp.BuildConfig
import com.example.moviesapp.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET(Constants.MOVIE_ENDPOINT)
    suspend fun fetchDiscoverMovie(
        @Query("api_key") apiKey : String = BuildConfig.apiKey,
        @Query("include_adult") includeAdult : Boolean = false,
    ) : MovieDto

    @GET(Constants.TRENDING_MOVIE_ENDPOINT)
    suspend fun fetchTrendingMovie(
        @Query("api_key") apiKey : String = BuildConfig.apiKey,
        @Query("include_adult") includeAdult : Boolean = false,
    ) : MovieDto
}