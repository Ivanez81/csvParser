package ru.blinov.csvparser.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.blinov.csvparser.dto.UserProgress;
import ru.blinov.csvparser.entity.Record;

import java.util.List;

@Repository
public interface UserProgressRepository extends JpaRepository<Record, String> {

    //  Тут все ясно из названия, но для поска по базе будет использовано то количество запросов,
    //  которое будет получено при получении уникальных ssoid в RecordRepository, было решено отказаться от этого способа.
    @Query(value = "SELECT new ru.blinov.csvparser.dto.UserProgress(r.ssoID, r.formID, r.timeStamp," +
            " r.eventGroup, r.eventSubType) FROM Record r WHERE r.eventGroup LIKE :eventGroup" +
            " AND r.ssoID = :ssoID AND r.eventSubType <> 'send' ORDER BY r.timeStamp DESC")
    List<UserProgress> findUserProgressBySsoIDAAndEventGroupContains(
            @Param("ssoID") String ssoID, @Param("eventGroup") String eventGroup, Pageable pageable
    );


    // Тут хотел переделать все в одном запросе, но сталкнулся с проблемой, что JPA не позволяет получать при использовнии
    // (r.ssoid, r.timeStamp) IN... MultiColumn ответы.

//    @Query(value = "SELECT new ru.blinov.csvparser.dto.UserProgress(r.ssoID, r.formID, r.timeStamp," +
//            " r.eventGroup, r.eventSubType) FROM Record r WHERE r.eventGroup LIKE :eventGroup" +
//            " AND r.ssoID IN (SELECT r2.ssoID FROM Record r2 WHERE r2.eventGroup LIKE :eventGroup GROUP BY r2.ssoID)" +
//            " AND r.eventSubType <> 'send'")
//    List<UserProgress> findUserProgressBySsoIDAAndEventGroupContains2(
//            @Param("eventGroup") String eventGroup
//    );


    //  И тут было решено попробывать нативный запрос к базу.
    @Query(value = "SELECT s1.ssoid, s1.formid, s1.ts, s1.grp, s1.subtype " +
            "FROM public.ssdb4 s1 " +
            "WHERE s1.grp " +
            "LIKE 'dszn_%' " +
            "AND (s1.ssoid, s1.ts) " +
            "IN (SELECT ssoid, MAX(ts) FROM public.ssdb4 WHERE grp LIKE 'dszn_%' GROUP BY ssoid) " +
            "AND s1.subtype <> 'send' " +
            "ORDER BY s1.ssoid, s1.ts",
            nativeQuery = true)
    List<UserProgress> findUserProgressBySsoIDAAndEventGroupContains2(
            @Param("eventGroup") String eventGroup
    );

    interface UserProgress{
        String getSsoID();
        String getFormID();
        Long getTs();
        String getGrp();
        String getSubtype();
    }

}
