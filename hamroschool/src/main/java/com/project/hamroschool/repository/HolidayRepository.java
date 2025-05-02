package com.project.hamroschool.repository;

import com.project.hamroschool.model.Holiday;
import com.project.hamroschool.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HolidayRepository extends CrudRepository<Holiday,String> {
  /*  JdbcTemplate jdbcTemplate;
    RowMapper<Holiday> holidayRowMapper = (rs, rowNum) -> {
       return new Holiday(
                rs.getString("Day"),
                rs.getString("Reason"),
                Holiday.Type.valueOf(rs.getString("Type"))
        );
    };

    @Autowired
    public HolidayRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate= jdbcTemplate;
    }
    public List<Holiday> getHolidays() {
        String sql="SELECT * FROM holidays";
        return jdbcTemplate.query(sql,holidayRowMapper);
    }
   */
    void deleteByReason(String reason);
}
