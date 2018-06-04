package ua.remzsolutions.onlinespreadsheets.domain.repository;

import ua.remzsolutions.onlinespreadsheets.domain.entity.SheetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SheetRepository extends JpaRepository<SheetEntity, Long> {
}
