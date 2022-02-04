package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    //오더 서비스는 2가지가 필요 멤버 + 할인정책

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private  final DiscountPolicy discountPolicy = new FixDiscountPolicy();


    @Override
    public Order createOrder(Long memberID, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberID);

        // 단일체계 원칙이 잘 실행됨  -> 디스카운트 폴리시를 이용해 ->가격변경 - >
        // 오더를 통해 가격변경시 단일체계 원칙 불만족
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberID,itemName,itemPrice,discountPrice);
    }
}
