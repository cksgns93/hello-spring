package hello.hellospring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.service.MemberService;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) { this.dataSource = dataSource; }

    @Bean
    public MemberService memberService() { return new MemberService(memberRepository()); }

    @Bean
    public JdbcTemplateMemberRepository memberRepository() { // return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}