package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        //appConfig에 의해 결정 되도록 위와같이 코드변경
        //MemberService memberService = new MemberServiceImpl();
        //OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.Join(member);
        
        // 커맨드 + 옵션 + v = 알아서 생성자 느낌으로 생성을 해줘
        Order order  = orderService.createOrder(memberId, "itemA", 10000);

        //Tostring 으로 인하여 객체 생성시 바로 이렇게 출력이됨
        System.out.println("order = " + order);
        System.out.println(" order.calculatePrice() = " +  order.calculatePrice());
    }
}
