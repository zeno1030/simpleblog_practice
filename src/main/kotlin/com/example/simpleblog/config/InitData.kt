/*
 * 한 게시글의 수정
 *
 * **page**
 * 포털/SNS/커뮤니티/뉴스관리, 관리설정 > 전체데이터
 *
 * **parameter**
 * options(object): DB 검색옵션
 * value(object): 수정할 값
 */
package com.example.simpleblog.config

import com.example.simpleblog.domain.member.*
import io.github.serpro69.kfaker.Faker
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.EventListener

@Configuration
class InitData(
    private val memberRepository: MemberRepository
) {
    val faker = Faker()
    @EventListener(ApplicationReadyEvent::class)
    private fun init(){
        val members = mutableListOf<Member>()
        for(i in 1 until 100) {
            val member = generateMember()
            members.add(member)
        }
        memberRepository.saveAll(members)
    }

    private fun generateMember(): Member =MemberSaveReq(
            email = faker.internet.safeEmail(),
            password = "1234",
            role = Role.USER
        ).toEntity()




}