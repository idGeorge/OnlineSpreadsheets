package ua.remzsolutions.onlinespreadsheets.domain.repository;

import ua.remzsolutions.onlinespreadsheets.domain.entity.AccessLevelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessLevelRepository extends JpaRepository<AccessLevelEntity, Long> {

    @Query("SELECT al FROM AccessLevelEntity al WHERE al.priority = (SELECT MAX(al.priority) FROM AccessLevelEntity)")
    AccessLevelEntity findWithSmallestPriority();

}
