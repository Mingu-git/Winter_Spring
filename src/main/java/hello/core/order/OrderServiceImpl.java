package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    //오더 서비스는 2가지가 필요 멤버 + 할인정책
    //appconfig로 생성자 주입
    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    // private  final DiscountPolicy discountPolicy = new RateDiscountPolicy(); //fixdiscountpolicy 변경가능

    //이렇게 할시 ->null pointer exception
    //create order ->discountpolicy -> null ->error
    //따라서 appconfig -> 클래스로 연결

    //철저하게 dip를 지키는 구조 형성 -> fix 가 들어올지 rate가 들어올지 모름
    private  final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberID, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberID);

        // 단일체계 원칙이 잘 실행됨  -> 디스카운트 폴리시를 이용해 ->가격변경 - >
        // 오더를 통해 가격변경시 단일체계 원칙 불만족
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberID,itemName,itemPrice,discountPrice);
    }
}
