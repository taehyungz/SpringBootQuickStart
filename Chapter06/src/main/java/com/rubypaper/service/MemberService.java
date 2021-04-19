package com.rubypaper.service;

import com.rubypaper.domain.Member;
import org.springframework.stereotype.Service;

public interface MemberService {
    Member getMember(Member member);
}
