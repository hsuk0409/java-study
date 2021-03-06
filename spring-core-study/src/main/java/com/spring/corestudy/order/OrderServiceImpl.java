package com.spring.corestudy.order;

import com.spring.corestudy.discount.DiscountPolicy;
import com.spring.corestudy.member.Member;
import com.spring.corestudy.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); // DIP 위반
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); // DIP 위반

    // DIP OK!
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
