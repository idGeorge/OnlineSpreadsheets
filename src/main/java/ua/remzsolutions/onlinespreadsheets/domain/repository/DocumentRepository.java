package ua.remzsolutions.onlinespreadsheets.domain.repository;

import ua.remzsolutions.onlinespreadsheets.domain.entity.DocumentEntity;
import ua.remzsolutions.onlinespreadsheets.domain.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<DocumentEntity, Long> {

    Page<DocumentEntity> findByTitleContainingOrAuthorOrArchived(String title, UserEntity author, Boolean archived, Pageable pageable);
}
