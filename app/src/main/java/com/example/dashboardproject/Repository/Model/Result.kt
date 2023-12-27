package com.example.dashboardproject.Repository.Model

import com.squareup.moshi.Json


class Result {
    @Json(name = "adult")
    var adult: Boolean? = null

    @Json(name = "backdrop_path")
    var backdropPath: String? = null

    @Json(name = "id")
    var id: Int? = null

    @Json(name = "title")
    var title: String? = null

    @Json(name = "original_language")
    var originalLanguage: String? = null

    @Json(name = "original_title")
    var originalTitle: String? = null

    @Json(name = "overview")
    var overview: String? = null

    @Json(name = "poster_path")
    var posterPath: String? = null

    @Json(name = "media_type")
    var mediaType: String? = null

    @Json(name = "genre_ids")
    var genreIds: List<Int>? = null

    @Json(name = "popularity")
    var popularity: Double? = null

    @Json(name = "release_date")
    var releaseDate: String? = null

    @Json(name = "video")
    var video: Boolean? = null

    @Json(name = "vote_average")
    var voteAverage: Int? = null

    @Json(name = "vote_count")
    var voteCount: Int? = null

    @Json(name = "name")
    var name: String? = null

    @Json(name = "original_name")
    var originalName: String? = null

    @Json(name = "first_air_date")
    var firstAirDate: String? = null

    @Json(name = "origin_country")
    var originCountry: List<String>? = null
}