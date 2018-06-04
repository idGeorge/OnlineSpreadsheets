package ua.remzsolutions.onlinespreadsheets.web.controllers;


import ua.remzsolutions.onlinespreadsheets.domain.entity.SheetEntity;
import ua.remzsolutions.onlinespreadsheets.domain.services.SheetService;
import ua.remzsolutions.onlinespreadsheets.web.exception.ResourceNotFoundException;
import ua.remzsolutions.onlinespreadsheets.web.request.EditSpreadsheetRequest;
import ua.remzsolutions.onlinespreadsheets.web.request.UpdateSpreadsheetStructureRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spreadsheet")
public class SpreadsheetController {

    @Autowired
    private SheetService sheetService;

    @PatchMapping("/content")
    public ResponseEntity updateSheet(@RequestBody EditSpreadsheetRequest request) {
        SheetEntity entity = sheetService.findOne(request.getId());
        if (entity == null) {
            throw new ResourceNotFoundException();
        }

        entity.set(request.getRow(), request.getCol(), request.getNewValue());
        sheetService.save(entity);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/structure")
    public ResponseEntity updateStructure(@RequestBody UpdateSpreadsheetStructureRequest request) {
        SheetEntity entity = sheetService.findOne(request.getId());
        if (entity == null) {
            throw new ResourceNotFoundException();
        }

        switch (request.getOperation()) {
            case "createCol": {
                entity.insertEmptyCol(request.getRow());
                break;
            }
            case "removeCol": {
                entity.removeCol(request.getCol());
                break;
            }
            case "createRow": {
                entity.insertEmptyRow(request.getRow());
                break;
            }
            case "removeRow": {
                entity.removeRow(request.getRow());
                break;
            }
        }

        sheetService.save(entity);
        return ResponseEntity.ok().build();
    }
}
