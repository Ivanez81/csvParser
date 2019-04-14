package ru.blinov.csvparser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.blinov.csvparser.dto.UserForms;
import ru.blinov.csvparser.entity.Record;

import java.util.List;

@Repository
public interface UserFormsRepository extends JpaRepository<Record, String> {

    @Query(value = "SELECT new ru.blinov.csvparser.dto.UserForms(r.ssoID, r.formID, r.timeStamp) FROM Record r" +
            " WHERE r.timeStamp BETWEEN :time1 AND :time2")
    List<UserForms> findUserActivityByTimeStampBetween(@Param("time1")Long time1, @Param("time2")Long time2);

}
