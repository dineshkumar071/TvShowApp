package com.example.dashboardproject.Repository.Model

import com.squareup.moshi.Json


class Trending {
    @Json(name = "page")
    var page: Int? = null

    @Json(name = "results")
    var results: List<Result>? = null

    @Json(name = "total_pages")
    var totalPages: Int? = null

    @Json(name = "total_results")
    var totalResults: Int? = null
}