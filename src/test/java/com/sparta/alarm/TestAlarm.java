package com.sparta.alarm;


import com.sparta.alarm.entity.Alarm;
import com.sparta.alarm.repository.AlarmRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
public class TestAlarm {


    @PersistenceContext
    EntityManager em;

    @Autowired
    AlarmRepository alarmRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    @DisplayName("Table 생성")
    void test1(){
        Alarm alarm = new Alarm();
        alarm.setId(1);
        alarm.setDate("240123");
        alarm.setTitle("안녕하세요.");
        alarm.setContent("Content 입니다.");
        alarm.setManager("김정환");
        alarm.setPassword("1q2w3e4r");

        em.persist(alarm);
    }


}
