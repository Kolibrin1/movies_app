package com.example.moviesapp.movie.data.repository_impl

import com.example.moviesapp.common.data.ApiMapper
import com.example.moviesapp.movie.data.remote.api.MovieApiService
import com.example.moviesapp.movie.data.remote.models.MovieDto
import com.example.moviesapp.movie.domain.models.Movie
import com.example.moviesapp.movie.domain.repository.MovieRepository
import com.example.moviesapp.utils.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class MovieRepositoryImpl(private val movieApiService: MovieApiService, private val apiMapper: ApiMapper<List<Movie>, MovieDto>) : MovieRepository {
    override fun fetchDiscoverMovie(): Flow<Response<List<Movie>>> = flow {
        emit(Response.Loading())
        val movieDto = movieApiService.fetchDiscoverMovie()
        apiMapper.mapToDomain(movieDto).apply {
            emit(Response.Success(this))
        }
    }.catch { e ->
        e.printStackTrace()
        emit(Response.Error(e))
    }

    override fun fetchTrendingMovie(): Flow<Response<List<Movie>>> = flow {
        emit(Response.Loading())
        val movieDto = movieApiService.fetchTrendingMovie()
        apiMapper.mapToDomain(movieDto).apply {
            emit(Response.Success(this))
        }
    }.catch { e ->
        e.printStackTrace()
        emit(Response.Error(e))
    }
}