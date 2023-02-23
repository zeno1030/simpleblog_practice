package com.example.simpleblog.domain.member

import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository:JpaRepository<Member, Long> {
}

interface  MemberCustomRepository{


}b

class MemberCustomRepositoryImpl(
    private val queryFactory:SpringDataQueryFactory,
): MemberCustomRepository{

    fun findMembers(){
        queryFactory.listOfQ
    }

}
