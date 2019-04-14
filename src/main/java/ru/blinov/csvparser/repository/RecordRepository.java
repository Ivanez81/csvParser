package ru.blinov.csvparser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.blinov.csvparser.entity.Record;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, String> {

    List<Record> findAllByEventGroupContains(String string);

    @Query(value = "SELECT DISTINCT r.ssoID FROM Record r WHERE r.timeStamp BETWEEN :time1 AND :time2")
    List<String> findUniqueSsoIDsByTimeStampBetween(@Param("time1")Long time1, @Param("time2")Long time2);

    @Query(value = "SELECT DISTINCT r.ssoID FROM Record r WHERE r.eventGroup LIKE :eventGroup")
    List<String> findUniqueSsoIDsByEventGroupContains(@Param("eventGroup") String eventGroup);

}
