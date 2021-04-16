package com.rubypaper.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(exclude = "boardList")
@Entity
public class Member {
    @Id
    @Column(name="MEMBER_ID")
    private String id;
    private String pasword;
    private String name;
    private String role;

    // fetch는 연관관계에 있는 정보도 같이 조회할 것인지를 나타냄. 기본은 LAZY이다.
    // mappedBy는 양방향 연관관계에서 연관관계의 주인을 지정할 때 사용함
    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Board> boardList = new ArrayList<Board>();
}
