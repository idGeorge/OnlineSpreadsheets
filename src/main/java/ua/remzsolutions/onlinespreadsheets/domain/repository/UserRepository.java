package ua.remzsolutions.onlinespreadsheets.domain.repository;

import ua.remzsolutions.onlinespreadsheets.domain.entity.AccessLevelEntity;
import ua.remzsolutions.onlinespreadsheets.domain.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    UserEntity findByUsernameEquals(String username);

    @Query("SELECT u FROM UserEntity u WHERE (u.firstName LIKE %:firstName% AND u.lastName LIKE %:lastName%) " +
            "or (u.firstName LIKE %:lastName% AND u.lastName LIKE %:firstName%)")
    Page<UserEntity> findByFirstAndLastName(@Param("firstName") String firstName,
                                            @Param("lastName") String lastName,
                                            Pageable pageable);

    Page<UserEntity> findByUsernameContainingOrFirstNameContainingOrLastNameContainingOrFiredOrAccessLevel(String username,
                                                                                                           String firstName,
                                                                                                           String lastName,
                                                                                                           boolean fired,
                                                                                                           AccessLevelEntity accessLevel,
                                                                                                           Pageable pageable);
}
