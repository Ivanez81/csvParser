package ru.blinov.csvparser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.blinov.csvparser.entity.RecordOpenCSV;

@Repository
public interface RecordOpenCSVRepository extends JpaRepository<RecordOpenCSV, String> {
}
