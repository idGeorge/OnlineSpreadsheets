package ua.remzsolutions.onlinespreadsheets.domain.services;

import ua.remzsolutions.onlinespreadsheets.domain.entity.DocumentEntity;
import ua.remzsolutions.onlinespreadsheets.domain.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface DocumentService extends GenericService<DocumentEntity, Long> {

    Page<DocumentEntity> findByAuthor(String authorId);

    Page<DocumentEntity> findByCreationDateBetween(Date firstDate, Date secondDate);

    Page<DocumentEntity> findByModificationDateBetween(Date firstDate, Date secondDate);

    Page<DocumentEntity> findByTitleContainingOrAuthorOrArchived(String title, UserEntity author, Boolean archived, Pageable pageable);

}
