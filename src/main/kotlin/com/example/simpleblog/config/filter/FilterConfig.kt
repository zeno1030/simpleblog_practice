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
    * ==== back ====
    * 1. 비동기 처리,
    * 2. 파일 핸들링
    * 3. sse event + web socket을 활용한 실시간 챗봇
    * 4. aws 배포
    * 5. actuator + admin-server를 통한 간단한 모니터링
    * 6. code deploy + gitgub action을 통한 CI/CD
    * 7. 스프링 시큐리티 + JWT 인증처리
    * 8. Junit + mockk 테스트 환경설정
    * 9. restdoc 통한 API 문서 자동화
    * 10. gradle 멀티 모듈을 통해서, domain을 공유하는 Batch 서버 작성
    * 11. 인메모리  concurrentHashmap을 통한 cache 적용
    * 12. 계층형 테이블 전략
    * 13. 스프링 클라우드 모듈들을 활용해서 간단하게 MSA 환경 구축
    * 14. Docker 연동해서 배포
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