package com.example.simpleblog.exception

import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class GlobalExceptionHandler {

    val log = KotlinLogging.logger { }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun hadleMethodArgumentNotValidException(e: MethodArgumentNotValidException) {

        log.error { "hadleMethodArgumentNotValidException $e" }

        ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, e.bindingResult)

        return ResponseEntity(of, HttpStatus.BAD_REQUEST)


    }
}