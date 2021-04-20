package com.rubypaper.config;

import com.rubypaper.domain.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

// Member객체를 UserDetails 타입 객체로 변환해야함
// 이를 위해 1. Member 클래스가 UserDetails 인터페이스를 구현하거나
// 2. UserDetails 인터페이스를 구현한 User클래스를 상속해야 한다.
// 1번 방법은 재정의해야 할 추상 메소드들이 생기기 때문에 바람직하지 않음
// 따라서 2번을 사용함
public class SecurityUser extends User {
    private static final long serialVersionUID = 1L;

    public SecurityUser(Member member) {
        super(member.getId(), member.getPassword(),
                AuthorityUtils.createAuthorityList(member.getRole().toString()));
    }
}
