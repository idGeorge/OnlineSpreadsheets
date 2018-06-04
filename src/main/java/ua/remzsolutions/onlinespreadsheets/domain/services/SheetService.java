package ua.remzsolutions.onlinespreadsheets.domain.services;

import ua.remzsolutions.onlinespreadsheets.domain.entity.SheetEntity;
import org.springframework.data.domain.Page;

public interface SheetService extends GenericService<SheetEntity, Long> {

    Page<SheetEntity> findByContent(String content);
}
