package com.gosling.market.domain.service;

import com.gosling.market.domain.dto.ProductoDTO;
import com.gosling.market.domain.repository.IProductoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private IProductoRepositorio iProductoRepositorio;

    public ProductService(IProductoRepositorio iProductoRepositorio) {
        this.iProductoRepositorio = iProductoRepositorio;
    }
    public List<ProductoDTO> getAll() {
        return iProductoRepositorio.getAll();
    }
    public Optional<ProductoDTO> getProductoDTO(int idProducto){
        return iProductoRepositorio.getProducto(idProducto);
    }
    public Optional<List<ProductoDTO>> getByCategoriaDTO(int idCategoria){
        return iProductoRepositorio.getByCategoria(idCategoria);
    }
    public ProductoDTO save(ProductoDTO productoDTO) {
        return iProductoRepositorio.save(productoDTO);
    }
    public boolean delete(int idProducto) {
        return getProductoDTO(idProducto)
                .map(productoDTO -> {
                    iProductoRepositorio.delete(idProducto);
                    return true;
                }).orElse(false);
    }
}
