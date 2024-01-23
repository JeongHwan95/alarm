package com.sparta.alarm.service;

import com.sparta.alarm.dto.ReqDTO;
import com.sparta.alarm.dto.ResDTO;
import com.sparta.alarm.entity.Alarm;
import com.sparta.alarm.repository.AlarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class AlarmService {


    AlarmRepository alarmRepository;
    Map<Integer, Alarm> alarms;
    @Autowired
    AlarmService(AlarmRepository alarmRepository){
        this.alarmRepository =alarmRepository;
        this.alarms = alarmRepository.getAlarms();
    }

    public boolean postAlarm(@ModelAttribute ReqDTO reqDTO){

        try {
            int id = alarms.size() == 0 ? 1 : Collections.max(alarms.keySet()) + 1;
            Alarm alarm = new Alarm(id, reqDTO);
            alarms.put(id, alarm);

            return true;
        }catch(Exception e){

            return false;
        }
    }

    public List<ResDTO> getAlarms(){
        List<ResDTO> responseList = alarms.values().stream()
                .map(ResDTO::new).toList();

        return responseList;
    }

    public ResDTO getAlarm(int id, String password){
        System.out.println("Controller :: getAlarm :: id와 password :" + id +", " + password);
        if(alarms.containsKey(id)){
            System.out.print("Controller :: getAlarm :: id반환");
            System.out.println("id, password : " + id + ", "  + password);
            Alarm alarm = alarms.get(id);


            if(alarm.getPassword().equals(password)) {
                System.out.println("Controller :: getAlarm :: ResDTO반환");
                return new ResDTO(alarm);
            }
            else{
                try{
                    throw new Exception();
                }catch(Exception e){
                    System.out.println("password가 일치하지 않습니다.");
                }
            }
        }else{
            try {
                throw new Exception();
            }catch(Exception e){
                System.out.println("해당하는 id의 알람이 없습니다. ");
            }
        }
        return null;
    }

    public boolean putAlarm(int id, ReqDTO reqDTO){
        System.out.println("Controller :: putAlarm :: id는 " + id + " manager는 " + reqDTO.getManager() + " password는 " + reqDTO.getPassword());

        if(alarms.containsKey(id)) {

            Alarm alarm = alarms.get(id);
            if (alarm.getPassword().equals(reqDTO.getPassword())) {
                alarm.setContent(reqDTO.getContent());
                alarm.setDate(reqDTO.getDate());
                alarm.setTitle(reqDTO.getTitle());
                alarm.setManager(reqDTO.getManager());

                return true;
            }else{
                try{
                    throw new Exception();
                }catch(Exception e) {
                    System.out.println("password가 일치하지 않습니다. ");
                }
            }
        }else{
            try{
                throw new Exception();
            }catch(Exception e){
                System.out.println("해당하는 id가 없습니다. ");
            }

        }
        return false;
    }

    public boolean deleteAlarm(int id, String password){

        if(alarms.containsKey(id)){

            Alarm alarm = alarms.get(id);
            if(alarm.getPassword().equals(password)){
                alarms.remove(id);

                return true;
            }else{
                try{
                    throw new Exception();
                }catch(Exception e){
                    System.out.println("비밀번호가 일치하지 않습니다. ");
                }
            }

        }else{
            try{
                throw new Exception();
            }catch(Exception e){
                System.out.println("해당하는 id가 없습니다. ");
            }
        }

        return false;
    }
}
