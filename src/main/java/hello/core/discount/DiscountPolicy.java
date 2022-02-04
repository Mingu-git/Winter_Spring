package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
    /**  주석은 [/별별 엔터]
     *
     * @param member
     * @param price
     * @return 할인대상 금액
     */
    int discount(Member member,int price);


}
