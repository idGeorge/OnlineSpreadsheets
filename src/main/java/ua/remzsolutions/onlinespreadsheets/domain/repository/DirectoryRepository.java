package ua.remzsolutions.onlinespreadsheets.domain.repository;

import ua.remzsolutions.onlinespreadsheets.domain.entity.DirectoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectoryRepository extends JpaRepository<DirectoryEntity, Long> {

    DirectoryEntity findFirstByName(String name);

    Page<DirectoryEntity> findByNameContainingOrParentDirectory(String name, DirectoryEntity parentDirectory, Pageable pageable);
}
