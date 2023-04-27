package com.gosling.market.domain.repository;

import com.gosling.market.domain.dto.ProductoDTO;

import java.util.List;
import java.util.Optional;

public interface IProductoRepositorio {

    List<ProductoDTO> getAll();
    Optional <List<ProductoDTO>> getByCategoria(Integer idCategoria);
    Optional<List<ProductoDTO>> getStockBajo(Integer cantidadStock);
    Optional<ProductoDTO> getProducto(Integer idProducto);
    ProductoDTO save(ProductoDTO productoDTO);
    void delete(Integer idProducto);
}
