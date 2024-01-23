package com.sparta.alarm.repository;

import com.sparta.alarm.entity.Alarm;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AlarmRepository {

    @Getter
    Map<Integer, Alarm> alarms = new HashMap<>();

}
