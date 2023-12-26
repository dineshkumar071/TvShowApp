package com.example.dashboardproject.Repository

import com.example.dashboardproject.Utils.Status

data class TSResponse<out T>(val status: Status?, val data:T?, val message:String?) {
    companion object{

        fun<T> success(data:T?):TSResponse<T>{
            return TSResponse(Status.SUCCESS, data, "")
        }

        fun <T> error(msg: String): TSResponse<T> {
            return TSResponse(Status.ERROR, null, msg)
        }

        fun <T> loading(data: T?): TSResponse<T> {
            return TSResponse(Status.LOADING, data, null)
        }
    }
}