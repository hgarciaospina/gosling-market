package com.gosling.market.persistence.mapper;

import com.gosling.market.domain.dto.CategoriaDTO;
import com.gosling.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    @Mappings({
            //source = atributo entity
            //target = atributo dto
            @Mapping(source = "idCategoria", target = "idCategoria"),
            @Mapping(source = "descripcion", target = "descripcion"),
            @Mapping(source = "estado", target = "estado"),
    })
    //Recibe objeto tipo Categoria y lo convierte a CategoriaDTO
    CategoriaDTO toCategoriaDTO(Categoria categoria);

    /* La anotación InheritInverseConfiguration
    *  hace la operación inversa de toCategoriaDto evitando mapear
    *  cada uno de los atributos
    * */
    @InheritInverseConfiguration
    //@Mapping permite ignorar el atributo productos que no se va a manejar en CategoriaDTO
    @Mapping(target = "productos", ignore = true)
    //Recibe objeto tipo CategoriaDTO y lo convierte a Categoria
    Categoria toCategoria(CategoriaDTO categoriaDTO);
}