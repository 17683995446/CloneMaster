package com.clone.master.common

open class ResultDTO<T>(
    val code: Int,
    val data: T?,
    val message: String
) {
    companion object {
        fun <T> success(data: T?, message: String = "Success"): ResultDTO<T> {
            return ResultDTO(0, data, message)
        }
        
        fun <T> error(code: Int, message: String, data: T? = null): ResultDTO<T> {
            return ResultDTO(code, data, message)
        }
    }
}
