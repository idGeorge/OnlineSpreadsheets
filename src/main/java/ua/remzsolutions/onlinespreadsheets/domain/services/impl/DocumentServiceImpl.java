package ua.remzsolutions.onlinespreadsheets.domain.services.impl;

import ua.remzsolutions.onlinespreadsheets.domain.entity.UserEntity;
import ua.remzsolutions.onlinespreadsheets.domain.repository.DocumentRepository;
import ua.remzsolutions.onlinespreadsheets.domain.entity.DocumentEntity;
import ua.remzsolutions.onlinespreadsheets.domain.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository repository;

    @Override
    public Page<DocumentEntity> findByAuthor(String authorId) {
        // TODO: implement
        return null;
    }

    @Override
    public Page<DocumentEntity> findByCreationDateBetween(Date firstDate, Date secondDate) {
        // TODO: implement
        return null;
    }

    @Override
    public Page<DocumentEntity> findByModificationDateBetween(Date firstDate, Date secondDate) {
        // TODO: implement
        return null;
    }

    @Override
    public Page<DocumentEntity> findByTitleContainingOrAuthorOrArchived(String title, UserEntity author, Boolean archived, Pageable pageable) {
        return repository.findByTitleContainingOrAuthorOrArchived(title, author, archived, pageable);
    }

    @Override
    public List<DocumentEntity> save(Iterable<DocumentEntity> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public DocumentEntity save(DocumentEntity entity) {
        return repository.save(entity);
    }

    @Override
    public List<DocumentEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public DocumentEntity findOne(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(DocumentEntity entity) {
        repository.delete(entity);
    }

    @Override
    public Page<DocumentEntity> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
