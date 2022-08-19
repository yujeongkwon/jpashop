package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

//JUnit5에서는 @RunWith(SpringRunner.class)가 포함대있음
//@RunWith(SpringRunner.class)    //스프링과 테스트 통합
@SpringBootTest //: 스프링 부트 띄우고 테스트(이게 없으면 @Autowired 다 실패)
@Transactional  //롤백
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        //Given
        Member member = new Member();
        member.setUsername("kim");
        //When
        Long saveId = memberService.join(member);
        //Then
        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test()
    public void 중복_회원_예외() throws Exception {
        //Given
        Member member1 = new Member();
        member1.setUsername("kim");
        Member member2 = new Member();
        member2.setUsername("kim");
        //When
        memberService.join(member1);
        Assertions.assertThrows(IllegalStateException.class, () -> {
            memberService.join(member2);
        });
    }
}