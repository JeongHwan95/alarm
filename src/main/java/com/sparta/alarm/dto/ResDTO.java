package com.sparta.alarm.dto;

import com.sparta.alarm.entity.Alarm;
import lombok.Getter;

@Getter
public class ResDTO {

    private int id;
    private String title;
    private String content;
    private String manager;

    private String date;

    public ResDTO(Alarm alarm){
        this.id = alarm.getId();
        this.title = alarm.getTitle();
        this.content = alarm.getContent();
        this.manager = alarm.getManager();

        this.date = alarm.getDate();
    }
}
