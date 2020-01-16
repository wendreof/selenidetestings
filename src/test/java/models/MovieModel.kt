package models

data class MovieModel(
        var title: String,
        var status: String,
        var year: String,
        var releaseDate: String,
        var cast: List<String>,
        var plot: String)