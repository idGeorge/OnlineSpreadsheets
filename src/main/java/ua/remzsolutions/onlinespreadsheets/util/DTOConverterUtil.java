package ua.remzsolutions.onlinespreadsheets.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class that generalize functional of DTO converters.
 * <p>
 * E - as Entity class
 * D - as DTO class
 */
public class DTOConverterUtil<E, D> {

    private Class<E> entityType;

    private Class<D> dtoType;

    private final ModelMapper modelMapper;

    @Autowired
    public DTOConverterUtil(Class<E> entityType, Class<D> dtoType, ModelMapper modelMapper) {
        this.entityType = entityType;
        this.dtoType = dtoType;
        this.modelMapper = modelMapper;
    }

    public D convertToDto(E entity) {
        return modelMapper.map(entity, dtoType);
    }

    public E convertToEntity(D dto) {
        return modelMapper.map(dto, entityType);
    }

    public List<D> convertToDto(List<E> entityList) {
        return entityList.stream().map(this::convertToDto)
                .collect(Collectors.toCollection(() -> new ArrayList<>(entityList.size())));
    }

    public List<E> convertToEntity(List<D> dtoList) {
        return dtoList.stream().map(this::convertToEntity)
                .collect(Collectors.toCollection(() -> new ArrayList<>(dtoList.size())));
    }

    public Page<D> convertToDto(Page<E> entityPage, PageRequest pageRequest) {
        return new PageImpl<>(convertToDto(entityPage.getContent()),
                pageRequest, entityPage.getTotalElements());
    }

    public Page<E> convertToEntity(Page<D> dtoPage, PageRequest pageRequest) {
        return new PageImpl<>(convertToEntity(dtoPage.getContent()),
                pageRequest, dtoPage.getTotalElements());
    }
}