package com.example.simpleblog.api

import com.example.simpleblog.service.MemberService
import com.example.simpleblog.util.CmResDto
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpSession


@RequestMapping("/need")
@RestController
class MemberController(
    private val memberService: MemberService,
    private val pageable: PageableHandlerMethodArgumentResolverCustomizer
) {
    @GetMapping("/members")
    fun findAll(@PageableDefault(size = 10) pageable: Pageable, session: HttpSession): CmResDto<*> {

        val principal = session.getAttribute("principal")

        if(principal == null){
            throw RuntimeException("session을 찾을 수 없습니다!")
        }

        return CmResDto(HttpStatus.OK,"find All Members", memberService.findAll(pageable))
    }

    @GetMapping("/member/{id}")
    fun findById(@PathVariable id:Long):CmResDto<Any>{
        return CmResDto(HttpStatus.OK, "find Member by id", memberService.findMemberById(id))
    }

}