package com.project.hamroschool.service;

import com.project.hamroschool.model.Holiday;
import com.project.hamroschool.repository.HolidayRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class HolidayService {
    HolidayRepository holidayRepository;
    @Autowired
    public HolidayService(HolidayRepository holidayRepository){
        this.holidayRepository= holidayRepository;
    }

    public List<Holiday> getHolidays() {
     Iterable<Holiday>  holidays= holidayRepository.findAll(); // find all is returning Iterable
        List<Holiday> holidayList= StreamSupport.stream(holidays.spliterator(),false).
                collect(Collectors.toList());  // Converting Iterable to List

        return holidayList;
    }
    public boolean addHoliday(Holiday holiday) {
        Holiday holiday1 = holidayRepository.save(holiday);

        // Verify if the holiday was successfully added
        if (holiday1 != null && holiday1.getDay() != null && holiday1.getReason() != null && holiday1.getType() != null) {
            // Success: Holiday has been saved
            System.out.println("Holiday successfully added: " + holiday1);
            return true;
        } else {
            // Failure: Holiday not added
            System.out.println("Failed to add holiday.");
            return false;
        }
    }
    @Transactional
    public void removeHoliday(String reason){
        holidayRepository.deleteByReason(reason);
    }
}
