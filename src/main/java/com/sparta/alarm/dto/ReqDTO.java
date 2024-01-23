package com.sparta.alarm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReqDTO {


    private String title;
    private String content;
    private String manager;
    private String password;
    private String date;
}
