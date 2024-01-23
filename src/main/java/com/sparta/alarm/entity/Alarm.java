package com.sparta.alarm.entity;

import com.sparta.alarm.dto.ReqDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "alarm")
@NoArgsConstructor
public class Alarm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String manager;
    @Column
    private String password;
    @Column
    private String date;

    public Alarm(ReqDTO reqDTO) {

        this.title = reqDTO.getTitle();
        this.content = reqDTO.getContent();
        this.manager = reqDTO.getManager();
        this.password = reqDTO.getPassword();
        this.date = reqDTO.getDate();
    }

    public void update(ReqDTO reqDTO) {
        this.title = reqDTO.getTitle();
        this.content = reqDTO.getContent();
        System.out.println(content);
        this.manager = reqDTO.getManager();
        this.date = reqDTO.getDate();
    }
}
