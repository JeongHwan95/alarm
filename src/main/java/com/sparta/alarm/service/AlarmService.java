package com.sparta.alarm.service;

import com.sparta.alarm.dto.ReqDTO;
import com.sparta.alarm.dto.ResDTO;
import com.sparta.alarm.entity.Alarm;
import com.sparta.alarm.repository.AlarmRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class AlarmService {


    AlarmRepository alarmRepository;

    @Autowired
    AlarmService(AlarmRepository alarmRepository){
        this.alarmRepository =alarmRepository;

    }

    public boolean postAlarm(@ModelAttribute ReqDTO reqDTO){

        try {
            Alarm alarm = new Alarm(reqDTO);
            alarmRepository.save(alarm);
            return true;
        }catch(Exception e) {
            return false;
        }
    }

    public List<ResDTO> getAlarms(){
        List<ResDTO> responseList = alarmRepository.findAll().stream()
                .map(ResDTO::new).toList();

        return responseList;
    }

    public ResDTO getAlarm(Integer id, String password){
        System.out.println("Controller :: getAlarm :: id와 password :" + id +", " + password);
        Alarm alarm = alarmRepository.findById(id).orElseThrow(()->
            new IllegalArgumentException("선택한 메모는 존재하지 않습니다.")
        );

        ResDTO resDTO = new ResDTO(alarm);

        return resDTO;
    }

    @Transactional
    public boolean putAlarm(int id, ReqDTO reqDTO){
        System.out.println("Controller :: putAlarm :: id는 " + id + " manager는 " + reqDTO.getManager() + " password는 " + reqDTO.getPassword());

        Alarm alarm = alarmRepository.findById(id).orElse(null);

        if(alarm != null && alarm.getPassword().equals(reqDTO.getPassword())){

            alarm.update(reqDTO);
            return true;
        }else{
            return false;
        }
    }

    public boolean deleteAlarm(int id, String password){

        Alarm alarm = alarmRepository.findById(id).orElse(null);

        if(alarm != null && alarm.getPassword().equals(password)){
            alarmRepository.delete(alarm);
            return true;
        }else{
            return  false;
        }
    }
}
