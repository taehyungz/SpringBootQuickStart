package com.rubypaper.board.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString(exclude = "member")
@Entity
public class Board {
    @Id
    @GeneratedValue
    private Long seq;

    private String title;

    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false) //JPA 수정작업 처리시 update칼럼에 포함하지 않음
    private Date createDate = new Date();

    @Column(updatable = false)
    private Long cnt = 0L;

    @ManyToOne
    //MEMBER_ID컬럼을 통해 외래키 관리, nullable=false를 통해 내부조인으로 처리하여 성능 향상
    @JoinColumn(name="MEMBER_ID", nullable = false, updatable = false)
    private Member member;

    public void setMember(Member member) {
        this.member = member;
        member.getBoardList().add(this);
    }
}
