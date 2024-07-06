package com.durand.retofinancieraoh.domain.model

import com.durand.retofinancieraoh.data.model.MovieModel

data class Movie(val image: String, val name: String)

fun MovieModel.toDomain() = Movie(image, name)
