package ua.remzsolutions.onlinespreadsheets.domain.services.impl;

import ua.remzsolutions.onlinespreadsheets.domain.entity.AccessLevelEntity;
import ua.remzsolutions.onlinespreadsheets.domain.repository.UserRepository;
import ua.remzsolutions.onlinespreadsheets.domain.entity.UserEntity;
import ua.remzsolutions.onlinespreadsheets.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserEntity findByUsername(String username) {
        return repository.findByUsernameEquals(username);
    }


    @Override
    public Page<UserEntity> findByFirstAndLastName(String firstName, String lastName, Pageable pageable) {
        return repository.findByFirstAndLastName(firstName, lastName, pageable);
    }

    @Override
    public Page<UserEntity> findByRolesIn(List<Long> roleIds) {
        // TODO: implement
        return null;
    }

    @Override
    public Page<UserEntity> findByFields(String username, String firstName, String lastName, boolean fired, AccessLevelEntity accessLevel, Pageable pageable) {
        return repository.findByUsernameContainingOrFirstNameContainingOrLastNameContainingOrFiredOrAccessLevel(username, firstName, lastName, fired, accessLevel, pageable);
    }

    @Override
    public List<UserEntity> save(Iterable<UserEntity> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public UserEntity save(UserEntity entity) {
        return repository.save(entity);
    }

    @Override
    public List<UserEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public UserEntity findOne(String id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(UserEntity entity) {
        repository.delete(entity);
    }

    @Override
    public Page<UserEntity> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
