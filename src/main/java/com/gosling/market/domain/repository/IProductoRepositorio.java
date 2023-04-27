package com.gosling.market.domain.repository;

import com.gosling.market.domain.dto.ProductoDTO;
import com.gosling.market.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoRepositorio {

    List<ProductoDTO> getAll();
    Optional <List<ProductoDTO>> getByCategoria(int idCategoria);
    Optional<List<ProductoDTO>> getStockBajo(int cantidadStock);
    Optional<ProductoDTO> getProducto(int idProducto);
    ProductoDTO save(ProductoDTO productoDTO);
    void delete(int idProducto);
}
