package com.rubypaper.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString(exclude = "member") //ToString 순환 참조 해제
@Entity
public class Board {
    @Id
    @GeneratedValue
    private Long seq;
    private String title;
//    private String writer;
    private String content;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createDate;
    private Long cnt;

    public void setMember(Member member) {
        this.member = member;
        member.getBoardList().add(this);
    }

    @ManyToOne
    @JoinColumn(name="MEMBER_ID", nullable = false) //외부조인은 내부조인보다 성능이 좋지 않으므로 inner join으로 변경
    private Member member;
}
