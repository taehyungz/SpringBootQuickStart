package com.rubypaper.board.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(exclude="boardList") //순환참조 문제를 해결하기 위해 boardList는 제외
@Entity
public class Member {
    @Id
    @Column(name="MEMBER_ID")
    private String id;

    private String password;

    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean enabled;

    //mappedBy속성을 통해 연관관계의 주인이 아님을 설정
    //member 조회시 관련된 Board목록도 같이 조회되도록 fetch를 즉시 로딩(EAGER)로 설저
    @OneToMany(mappedBy="member", fetch=FetchType.EAGER)
    private List<Board> boardList = new ArrayList<Board>();
}
