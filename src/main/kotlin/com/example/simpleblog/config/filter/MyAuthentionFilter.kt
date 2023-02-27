package com.example.simpleblog.config.filter

import mu.KotlinLogging
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest

class MyAuthentionFilter: Filter {

    val log = KotlinLogging.logger{ }

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {

        val servletRequst = request as HttpServletRequest
        val principal = servletRequst.session.getAttribute("principal")

        if(principal == null){
            throw RuntimeException("session not found")
        }else{
            chain.doFilter(request, response)
        }


    }
}