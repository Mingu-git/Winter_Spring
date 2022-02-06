package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    //psvm + eneter = 단축
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        //멤버서비스에 멤버 임플이 있기 떄문에
        MemberService memberService = appConfig.memberService();

        // member service 에서 impl 을 선택
        // MemberService memberService = new MemberServiceImpl(); ->appconfig 사용시 위처럼 변경
        //member 객체 임의로 설정  + command option v 단축키 사용
        Member member = new Member(1L, "memberA", Grade.VIP) ;
        memberService.Join(member);

        Member findMember = memberService.findMember(1L);
        // 출력 단축키 = sout + enter
        System.out.println("new member = "+ member.getName());
        System.out.println("findMember = " + findMember.getName());


    }
}
