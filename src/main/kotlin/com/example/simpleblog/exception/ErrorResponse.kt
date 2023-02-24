package com.example.simpleblog.exception

import jdk.internal.net.http.common.Log.errors
import org.springframework.validation.AbstractBindingResult
import org.springframework.validation.BindingResult

import org.springframework.validation.FieldError

class ErrorResponse(
    errorCode: ErrorCode,
    var errors:List<>
) {



    class FieldError private constructor(

        val field:String,
        val value:String,
        val reason:String?
    ){
        companion object{

            fun of(bindingResult:BindingResult){

                val fieldErrors = bindingResult.fieldErrors

                fieldErrors.map{ fieldError ->
                    FieldError(
                        field = errors().field,
                        value = if(errors().rejectvalue == null)"" else errors().rejectedvalue.toString()
                        reason = errors.defaultMessage
                    )
                }

            }
        }
    }
}