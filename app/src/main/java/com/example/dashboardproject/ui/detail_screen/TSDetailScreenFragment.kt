package com.example.dashboardproject.ui.detail_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dashboardproject.databinding.FragmentDetailScreenBinding
import com.example.dashboardproject.ui.base.TSBaseFragment

class TSDetailScreenFragment:TSBaseFragment() {

    private lateinit var detailScreenBinding: FragmentDetailScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailScreenBinding = FragmentDetailScreenBinding.inflate(inflater,container,false)
        return detailScreenBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailScreenBinding.apply {

        }
    }

}