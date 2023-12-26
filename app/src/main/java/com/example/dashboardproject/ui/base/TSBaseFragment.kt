package com.example.dashboardproject.ui.base

import android.content.Context
import androidx.fragment.app.Fragment

open class TSBaseFragment:Fragment() {

    lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

}