package com.example.moviesapp.movie_detail.data.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthorDetails(
    @SerialName("name")
    val name: String? = null,
    @SerialName("username")
    val username: String? = null,
    @SerialName("avatar_path")
    val avatarPath: String? = null,
    @SerialName("rating")
    val rating: Double? = null,
)
