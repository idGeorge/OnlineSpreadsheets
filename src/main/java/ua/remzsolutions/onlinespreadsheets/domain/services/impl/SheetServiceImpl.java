package ua.remzsolutions.onlinespreadsheets.domain.services.impl;

import ua.remzsolutions.onlinespreadsheets.domain.repository.SheetRepository;
import ua.remzsolutions.onlinespreadsheets.domain.entity.SheetEntity;
import ua.remzsolutions.onlinespreadsheets.domain.services.SheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SheetServiceImpl implements SheetService {

    @Autowired
    private SheetRepository repository;

    @Override
    public Page<SheetEntity> findByContent(String content) {
        // TODO: implement
        return null;
    }

    @Override
    public List<SheetEntity> save(Iterable<SheetEntity> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public SheetEntity save(SheetEntity entity) {
        return repository.save(entity);
    }

    @Override
    public List<SheetEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public SheetEntity findOne(Long aLong) {
        return repository.findById(aLong).get();
    }

    @Override
    public void delete(SheetEntity entity) {
        repository.delete(entity);
    }

    @Override
    public Page<SheetEntity> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
