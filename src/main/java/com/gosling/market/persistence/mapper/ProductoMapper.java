package com.gosling.market.persistence.mapper;

import com.gosling.market.domain.dto.ProductoDTO;
import com.gosling.market.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    @Mappings({
            //source = atributo entity
            //target = atributo dto
            @Mapping(source = "idProducto", target = "idProducto"),
            @Mapping(source = "descripcion", target = "descripcion"),
            @Mapping(source = "idCategoria", target = "idCategoria"),
            @Mapping(source = "precioVenta" , target = "precioVenta"),
            @Mapping(source = "cantidadStock" , target = "cantidadStock"),
            @Mapping(source = "estado" , target = "estado"),
            @Mapping(source = "categoria" , target = "categoria"),
    })
    //Recibe objeto tipo Producto y lo convierte a ProductoDTO
    ProductoDTO toProductoDTO(Producto producto);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    //Recibe objeto tipo ProductoDTO y lo convierte a Producto
    Producto toProducto(ProductoDTO productoDTO);

    //Recibe una lista de productos y la convierte a una lista de ProductoDTO
    List<ProductoDTO> toProductos(List<Producto> productos);






}
