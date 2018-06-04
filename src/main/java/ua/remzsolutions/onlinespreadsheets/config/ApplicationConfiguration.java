package ua.remzsolutions.onlinespreadsheets.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.*;
import ua.remzsolutions.onlinespreadsheets.domain.dto.DirectoryDTO;
import ua.remzsolutions.onlinespreadsheets.domain.dto.DocumentDTO;
import ua.remzsolutions.onlinespreadsheets.domain.dto.UserDTO;
import ua.remzsolutions.onlinespreadsheets.domain.entity.DirectoryEntity;
import ua.remzsolutions.onlinespreadsheets.domain.entity.DocumentEntity;
import ua.remzsolutions.onlinespreadsheets.domain.entity.UserEntity;
import ua.remzsolutions.onlinespreadsheets.util.DTOConverterUtil;
import ua.remzsolutions.onlinespreadsheets.util.JwtTokenUtil;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public JwtTokenUtil tokenUtil() {
        return new JwtTokenUtil();
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        return mapper;
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public DTOConverterUtil<DirectoryEntity, DirectoryDTO> directoryConverterUtil() {
        return new DTOConverterUtil<>(DirectoryEntity.class, DirectoryDTO.class, modelMapper());
    }

    @Bean
    public DTOConverterUtil<UserEntity, UserDTO> userConverterUtil() {
        return new DTOConverterUtil<>(UserEntity.class, UserDTO.class, modelMapper());
    }

    @Bean
    public DTOConverterUtil<DocumentEntity, DocumentDTO> documentConverterUtil() {
        return new DTOConverterUtil<>(DocumentEntity.class, DocumentDTO.class, modelMapper());
    }
}