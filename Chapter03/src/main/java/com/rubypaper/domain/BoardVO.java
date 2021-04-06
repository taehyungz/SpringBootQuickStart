package com.rubypaper.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class BoardVO {
    private int seq;
    private String title;
    private String writer;
    private String content;
    private Date createDate = new Date();
    private int cnt;
}
