package com.example.simpleblog.config.filter

import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class FilterConfig {

    /*
    * 이런 필터랑 인터셉터를 이용해서 만든 강력한 인증처리 관련 프레임워크가 있다
    * 스프링 시큐리티라는 건데,
    *
    *
    *  */
    @Bean
    fun registMyAuthentionFilter(): FilterRegistrationBean<MyAuthentionFilter> {

        val bean = FilterRegistrationBean(MyAuthentionFilter())
        bean.addUrlPatterns("/need/*")
        bean.order = 0
        return bean
    }
}