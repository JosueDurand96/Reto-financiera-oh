package com.durand.retofinancieraoh.domain.model

import com.durand.retofinancieraoh.data.model.MovieMasterResponse
import com.durand.retofinancieraoh.data.model.MovieResponse

data class MovieMaster(val data: List<Movie>)
data class Movie(val image: String, val name: String)

fun MovieMasterResponse.toDomain() = MovieMaster(data.map { it.toDomain() })

fun MovieResponse.toDomain() = Movie(image, name)
