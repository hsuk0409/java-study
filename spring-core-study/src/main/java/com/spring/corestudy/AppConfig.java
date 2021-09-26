package com.spring.corestudy;

import com.spring.corestudy.discount.FixDiscountPolicy;
import com.spring.corestudy.member.MemberService;
import com.spring.corestudy.member.MemberServiceImpl;
import com.spring.corestudy.member.MemoryMemberRepository;
import com.spring.corestudy.order.OrderService;
import com.spring.corestudy.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}