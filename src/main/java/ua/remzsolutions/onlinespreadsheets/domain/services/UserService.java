package ua.remzsolutions.onlinespreadsheets.domain.services;

import ua.remzsolutions.onlinespreadsheets.domain.entity.AccessLevelEntity;
import ua.remzsolutions.onlinespreadsheets.domain.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService extends GenericService<UserEntity, String>{

    UserEntity findByUsername(String username);

    Page<UserEntity> findByFirstAndLastName(String firstName,
                                            String lastName,
                                            Pageable pageable);

    Page<UserEntity> findByRolesIn(List<Long> roleIds);

    Page<UserEntity> findByFields(String username,
                                  String firstName,
                                  String lastName,
                                  boolean fired,
                                  AccessLevelEntity accessLevel,
                                  Pageable pageable);
}
