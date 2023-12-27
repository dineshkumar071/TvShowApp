package com.example.dashboardproject.ui.base

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.dashboardproject.Repository.Model.Results
import com.example.dashboardproject.common.TSFragmentChannel
import com.google.gson.Gson
import com.google.gson.GsonBuilder

open class TSBaseFragment:Fragment() {

    lateinit var mContext: Context
    lateinit var tsFragmentChannel: TSFragmentChannel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    fun convertPOJOtoJSON(result:Results):String{
        val userGson = GsonBuilder().create()
        return userGson.toJson(result)
    }

    fun convertJSONtoPOJO(result: String):Results{
        val gson = Gson()
        return gson.fromJson(
            result,
            Results::class.java
        )
    }

    companion object{
        fun setFragmentChannel(mTsFragmentChannel: TSFragmentChannel){
            TSBaseFragment().apply {
                tsFragmentChannel = mTsFragmentChannel
            }
        }
    }

}