package com.example.moviesapp.movie.data.mapper_impl

import com.example.moviesapp.common.data.ApiMapper
import com.example.moviesapp.movie.data.remote.models.MovieDto
import com.example.moviesapp.movie.domain.models.Movie
import com.example.moviesapp.utils.GenreConstants

class MovieApiMapperImpl : ApiMapper<List<Movie>, MovieDto> {
    override fun mapToDomain(apiDto: MovieDto): List<Movie> {
        return apiDto.results?.map { result ->
            Movie(
                backdropPath = formatEmptyValue(result?.backdropPath),
                genrelds = formatGenre(result?.genreIds),
                id = result?.id ?: 0,
                originalLanguage = formatEmptyValue(result?.originalLanguage, "language"),
                originalTitle = formatEmptyValue(result?.originalTitle, "title"),
                overview = formatEmptyValue(result?.overview, "overview"),
                popularity = result?.popularity ?: 0.0,
                posterPath = formatEmptyValue(result?.posterPath),
                releaseDate = formatEmptyValue(result?.releaseDate, "release date"),
                title = formatEmptyValue(result?.title, "title"),
                video = result?.video ?: false,
                voteAverage = result?.voteAverage ?: 0.0,
                voteCount = result?.voteCount ?: 0
            )
        } ?: emptyList()
    }

    private fun formatEmptyValue(value: String?, default: String = "") : String {
        if(value.isNullOrEmpty()) return "Unknown $default"
        return value
    }

    private fun formatGenre(genreIds: List<Int?>?): List<String> {
        return genreIds?.map { GenreConstants.getGenreNameById(it ?: 0) } ?: emptyList()
    }
}