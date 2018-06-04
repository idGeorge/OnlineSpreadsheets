package ua.remzsolutions.onlinespreadsheets.web.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.remzsolutions.onlinespreadsheets.domain.dto.DirectoryDTO;
import ua.remzsolutions.onlinespreadsheets.domain.dto.DirectoryTreeDTO;
import ua.remzsolutions.onlinespreadsheets.domain.entity.DirectoryEntity;
import ua.remzsolutions.onlinespreadsheets.domain.services.DirectoryService;
import ua.remzsolutions.onlinespreadsheets.util.DTOConverterUtil;
import ua.remzsolutions.onlinespreadsheets.web.request.GetDocumentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Test {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private DirectoryService directoryService;

    @Autowired
    private DTOConverterUtil<DirectoryEntity, DirectoryDTO> converter;

    @RequestMapping(value = "/q", method = RequestMethod.GET)
    public ResponseEntity<DirectoryTreeDTO> treeStructure() {
        DirectoryEntity entity = directoryService.findOne(1L);

        DirectoryTreeDTO tree = new DirectoryTreeDTO();
        tree.setRoot(converter.convertToDto(entity));

        return ResponseEntity.ok(tree);
    }

    @GetMapping("/g")
    public ResponseEntity<String> stringResponseEntity(GetDocumentRequest request) {
        LOGGER.info("Request: {} ", request);
        return ResponseEntity.ok("s");
    }

    @GetMapping("/s")
    public Page<DirectoryEntity> responseEntity() {
        DirectoryEntity parentDirectory = directoryService.findOne(1L);
        return directoryService.findByNameContainingOrParentDirectory("stuff", parentDirectory, new PageRequest(0, 25));
    }
}