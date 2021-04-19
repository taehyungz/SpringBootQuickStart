package com.rubypaper.service;

import com.rubypaper.domain.Member;
import com.rubypaper.persistence.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepo;

    @Override
    public Member getMember(Member member) {
        Optional<Member> findMember = memberRepo.findById(member.getId());
        return findMember.orElse(null);
    }
}
