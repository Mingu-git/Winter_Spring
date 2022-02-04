package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("Vip는 10% 할인 적용되어야 한다")
    void vip_ok(){
        //given
        Member member = new Member(1L,"memberVip", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        //static -> 임포트 스태틱 올라감 간결해짐 = 자바 기본문법이랜다.
        assertThat(discount).isEqualTo(1000);
    }
    @Test
    @DisplayName("Basic은 할인 적용 x 한다")
    void vip_not(){
        Member member = new Member(2L,"memberbasic",Grade.BASIC);
        int discount = discountPolicy.discount(member,10000);

        assertThat(discount).isEqualTo(0);
    }

}