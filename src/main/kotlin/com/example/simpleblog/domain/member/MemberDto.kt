package com.example.simpleblog.domain.member

/**
 * dto <=> entity 간의 맵핑할 때, 크게 스타일이 2개 있는거 같음
 * 1. 각 dto, entity에 책임 할당
 * 2. entitymappeer 라는 놈을 하나 만들어서 걔가 담당하게끔 하는 스타일도 있음
 */

data class MemberSaveReq(

    val  email:String,
    val password:String,
    val role:Role
)

fun MemberSaveReq.toEntity(): Member{
    return Member(
        email = this.email,
        password = this.password,
        role = this.role,
    )
}