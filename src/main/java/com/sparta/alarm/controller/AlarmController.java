package com.sparta.alarm.controller;

import com.sparta.alarm.dto.ReqDTO;
import com.sparta.alarm.dto.ResDTO;
import com.sparta.alarm.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AlarmController {

    AlarmService alarmService;
    @Autowired
    AlarmController(AlarmService alarmService){
        this.alarmService = alarmService;
    }


    @PostMapping("/alarm")
    public boolean postAlarm(@ModelAttribute ReqDTO reqDTO){
        System.out.println("Controller :: postAlarm :: reqDTO 내부값 확인 " + reqDTO.getManager() );
        return this.alarmService.postAlarm(reqDTO);
    }

    @GetMapping("/alarms")
    public List<ResDTO> getAlarms(){

        return this.alarmService.getAlarms();

    }

    @PostMapping("/alarm/{id}")
    public ResDTO getAlarm(@PathVariable int id, @RequestParam String password){

        return this.alarmService.getAlarm(id, password);
    }

    @PutMapping("/alarm/{id}")
    public boolean putAlarm(@PathVariable int id, @ModelAttribute ReqDTO reqDTO){
        return this.alarmService.putAlarm(id, reqDTO);
    }

    @DeleteMapping("/alarm/{id}")
    public boolean deleteAlarm(@PathVariable int id, @RequestParam String password){
        return this.alarmService.deleteAlarm(id, password);
    }
}
