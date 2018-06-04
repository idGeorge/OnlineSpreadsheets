package ua.remzsolutions.onlinespreadsheets.web.controllers;


import ua.remzsolutions.onlinespreadsheets.domain.entity.SheetEntity;
import ua.remzsolutions.onlinespreadsheets.domain.services.SpreadsheetService;
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

    private final SpreadsheetService spreadsheetService;

    @Autowired
    public SpreadsheetController(SpreadsheetService spreadsheetService) {
        this.spreadsheetService = spreadsheetService;
    }

    @PatchMapping("/content")
    public ResponseEntity updateSheet(@RequestBody EditSpreadsheetRequest request) {
        SheetEntity entity = spreadsheetService.findOne(request.getId());
        if (entity == null) {
            throw new ResourceNotFoundException();
        }

        entity.set(request.getRow(), request.getCol(), request.getNewValue());
        spreadsheetService.save(entity);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/structure")
    public ResponseEntity updateStructure(@RequestBody UpdateSpreadsheetStructureRequest request) {
        SheetEntity entity = spreadsheetService.findOne(request.getId());
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

        spreadsheetService.save(entity);
        return ResponseEntity.ok().build();
    }
}
