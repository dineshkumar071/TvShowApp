package com.example.dashboardproject.common

import com.example.dashboardproject.Repository.Model.Results

interface TSFragmentChannel {

    fun showImagePosterFragment()

    fun showDetailScreenFragment(results: String)
}