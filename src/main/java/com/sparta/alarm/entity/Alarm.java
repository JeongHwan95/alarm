package com.sparta.alarm.entity;

import com.sparta.alarm.dto.ReqDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Alarm {

    private int id;
    private String title;
    private String content;
    private String manager;
    private String password;
    private String date;

    public Alarm(int id, ReqDTO reqDTO) {
        this.id = id;
        this.title = reqDTO.getTitle();
        this.content = reqDTO.getContent();
        this.manager = reqDTO.getManager();
        this.password = reqDTO.getPassword();
        this.date = reqDTO.getDate();
    }
}
