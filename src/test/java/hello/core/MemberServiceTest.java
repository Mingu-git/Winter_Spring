package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;


public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join(){
        //given
        Member member = new Member(1L,"memberA", Grade.VIP);
        //when

        memberService.Join(member);
        Member findMember = memberService.findMember(1L);

        //then
        //aasertThat -> 오류시 빨간불 나옴
        Assertions.assertThat(member).isEqualTo(findMember);



    }
}
