package ua.remzsolutions.onlinespreadsheets.domain.services.impl;

import ua.remzsolutions.onlinespreadsheets.domain.repository.AccessLevelRepository;
import ua.remzsolutions.onlinespreadsheets.domain.entity.AccessLevelEntity;
import ua.remzsolutions.onlinespreadsheets.domain.services.AccessLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccessLevelServiceImpl implements AccessLevelService {

    @Autowired
    private AccessLevelRepository repository;

    @Override
    public List<AccessLevelEntity> save(Iterable<AccessLevelEntity> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public AccessLevelEntity save(AccessLevelEntity entity) {
        return repository.save(entity);
    }

    @Override
    public List<AccessLevelEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public AccessLevelEntity findOne(Long aLong) {
        return repository.findById(aLong).get();
    }

    @Override
    public void delete(AccessLevelEntity entity) {
        repository.delete(entity);
    }

    @Override
    public Page<AccessLevelEntity> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public AccessLevelEntity findWithSmallestPriority() {
        return repository.findWithSmallestPriority();
    }
}
