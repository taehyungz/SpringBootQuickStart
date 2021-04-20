package com.rubypaper.config;

import com.rubypaper.domain.Member;
import com.rubypaper.persistence.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoardUserDetailsService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //MemberRepository로 회원정보를 조회하여 UserDetails 타입의 객체로 리턴한다.
        Optional<Member> optional = memberRepo.findById(username);
        if(!optional.isPresent()) {
            throw new UsernameNotFoundException(username + " 사용자 없음");
        } else {
            Member member = optional.get();
            return new SecurityUser(member);
        }
    }
}
