package com.example.simpleblog.util

data class CmResDto<T>(
    val resultCode:T,
    val resultMsg:String,
    val data : T
)
