package com.example.simpleblog.exception

open class BusinessException : RuntimeException {
    private var errorCode:ErrorCode
        get() {
            return this.errorCode
        }

    constructor(errorCode: ErrorCode):super(errorCode.message){
        this.errorCode = errorCode
    }

    constructor(message: String?, errorCode: ErrorCode):super(errorCode.message){
        this.errorCode = errorCode
    }
    fun getErrorCode():ErrorCode{
        return errorCode
    }
}