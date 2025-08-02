package com.example.moviesapp.di

import com.example.moviesapp.common.data.ApiMapper
import com.example.moviesapp.movie.data.remote.models.MovieDto
import com.example.moviesapp.movie.domain.models.Movie
import com.example.moviesapp.movie_detail.data.mapper_impl.MovieDetailMapperImpl
import com.example.moviesapp.movie_detail.data.remote.api.MovieDetailApiService
import com.example.moviesapp.movie_detail.data.remote.models.MovieDetailDto
import com.example.moviesapp.movie_detail.data.repository_impl.MovieDetailRepositoryImpl
import com.example.moviesapp.movie_detail.domain.models.MovieDetail
import com.example.moviesapp.movie_detail.domain.repository.MovieDetailRepository
import com.example.moviesapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieDetailModule {
    private val json = Json {
        coerceInputValues = true
        ignoreUnknownKeys = true
    }


    @Provides
    @Singleton
    fun provideMovieDetailRepository(
        movieDetailApiService: MovieDetailApiService,
        mapper: ApiMapper<MovieDetail, MovieDetailDto>,
        movieMapper: ApiMapper<List<Movie>, MovieDto>
    ): MovieDetailRepository = MovieDetailRepositoryImpl(
        movieDetailApiService = movieDetailApiService,
        apiDetailMapper = mapper,
        apiMovieMapper = movieMapper,
    )

    @Provides
    @Singleton
    fun provideMovieMapper(): ApiMapper<MovieDetail, MovieDetailDto> = MovieDetailMapperImpl()

    @Provides
    @Singleton
    fun provideMovieDetailApiService(): MovieDetailApiService {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
            .create(MovieDetailApiService::class.java)
    }




}