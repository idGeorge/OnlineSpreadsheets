package ua.remzsolutions.onlinespreadsheets.domain.services.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.remzsolutions.onlinespreadsheets.domain.repository.DirectoryRepository;
import ua.remzsolutions.onlinespreadsheets.domain.entity.DirectoryEntity;
import ua.remzsolutions.onlinespreadsheets.domain.services.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DirectoryServiceImpl implements DirectoryService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private DirectoryRepository repository;

    @Override
    public Page<DirectoryEntity> findDirectoriesCreatedBy(String authorId) {
        // TODO: implement
        return null;
    }

    @Override
    public DirectoryEntity findFirstByName(String name) {
        return repository.findFirstByName(name);
    }

    @Override
    public Page<DirectoryEntity> findByNameContainingOrParentDirectory(String name, DirectoryEntity parentDirectory, Pageable pageable) {
        return repository.findByNameContainingOrParentDirectory(name, parentDirectory, pageable);
    }

    @Override
    public List<DirectoryEntity> save(Iterable<DirectoryEntity> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public DirectoryEntity save(DirectoryEntity entity) {
        return repository.save(entity);
    }

    @Override
    public List<DirectoryEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public DirectoryEntity findOne(Long aLong) {
        return repository.findById(aLong).get();
    }

    @Override
    public void delete(DirectoryEntity entity) {
        repository.delete(entity);
    }

    @Override
    public Page<DirectoryEntity> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}