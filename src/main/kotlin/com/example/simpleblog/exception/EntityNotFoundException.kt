package com.example.simpleblog.exception

class EntityNotFoundException(message:String?) : BusinessException(message, ErrorCode.ENTITY_NOT_FOUND){


}