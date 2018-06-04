package ua.remzsolutions.onlinespreadsheets.domain.services;

import ua.remzsolutions.onlinespreadsheets.domain.entity.AccessLevelEntity;

public interface AccessLevelService extends GenericService<AccessLevelEntity, Long> {

    AccessLevelEntity findWithSmallestPriority();
}
