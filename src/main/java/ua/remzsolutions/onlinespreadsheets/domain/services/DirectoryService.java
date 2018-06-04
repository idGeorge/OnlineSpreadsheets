package ua.remzsolutions.onlinespreadsheets.domain.services;

import ua.remzsolutions.onlinespreadsheets.domain.entity.DirectoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DirectoryService extends GenericService<DirectoryEntity, Long> {

    Page<DirectoryEntity> findDirectoriesCreatedBy(String authorId);

    DirectoryEntity findFirstByName(String name);

    Page<DirectoryEntity> findByNameContainingOrParentDirectory(String name, DirectoryEntity parentDirectory, Pageable pageable);


}
