package ru.blinov.csvparser.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.blinov.csvparser.dto.TopForms;
import ru.blinov.csvparser.entity.Record;

import java.util.List;

@Repository
public interface TopFormsRepository extends JpaRepository<Record, String> {

    @Query(value = "SELECT new ru.blinov.csvparser.dto.TopForms(r.formID, COUNT (r.formID)) " +
            "FROM Record r GROUP BY r.formID ORDER BY COUNT (r.formID) DESC")
    List<TopForms> findTopFiveForms(Pageable pageable);

}
