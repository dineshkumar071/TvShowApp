package com.example.dashboardproject.ui.image_poster

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dashboardproject.databinding.FragmentImagePosterBinding
import com.example.dashboardproject.ui.base.TSBaseFragment

class TSImagePosterFragment : TSBaseFragment() {
    private lateinit var imagePosterBinding: FragmentImagePosterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        imagePosterBinding = FragmentImagePosterBinding.inflate(inflater, container, false)
        return imagePosterBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imagePosterBinding.apply {
            rvImagePoster.layoutManager =
                GridLayoutManager(mContext, 2, RecyclerView.HORIZONTAL, false)
        }
    }
}