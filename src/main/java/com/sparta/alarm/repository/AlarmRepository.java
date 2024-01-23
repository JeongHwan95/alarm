package com.sparta.alarm.repository;

import com.sparta.alarm.entity.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AlarmRepository extends JpaRepository<Alarm, Integer> {


}
