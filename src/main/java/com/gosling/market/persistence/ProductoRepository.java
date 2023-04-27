package com.gosling.market.persistence;

import com.gosling.market.domain.dto.ProductoDTO;
import com.gosling.market.domain.repository.IProductoRepositorio;
import com.gosling.market.persistence.crud.ProductoCrudRepository;
import com.gosling.market.persistence.entity.Producto;
import com.gosling.market.persistence.mapper.ProductoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements IProductoRepositorio {
    private ProductoCrudRepository productoCrudRepository;
    private ProductoMapper productoMapper;

    public ProductoRepository(ProductoCrudRepository productoCrudRepository, ProductoMapper productoMapper) {
        this.productoCrudRepository = productoCrudRepository;
        this.productoMapper = productoMapper;
    }

    @Override
    public List<ProductoDTO> getAll() {
        List<Producto>  productos = (List<Producto> )productoCrudRepository.findAll();
        return productoMapper.toProductosDTO(productos);
    }
    @Override
    public Optional<List<ProductoDTO>> getByCategoria(Integer idCategoria) {
        List<Producto>  productos = productoCrudRepository.findByIdCategoriaOrderByDescripcionAsc(idCategoria);
        return Optional.of(productoMapper.toProductosDTO(productos));
    }

    @Override
    public Optional<List<ProductoDTO>> getStockBajo(Integer cantidadStock) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanEstado(cantidadStock, true);
        //La operación map devuelve un Optional
        return productos.map(prods -> productoMapper.toProductosDTO(prods));
    }
   @Override
   public Optional<ProductoDTO> getProducto(Integer idProducto) {

        return productoCrudRepository.findById(idProducto)
                .map(producto -> productoMapper.toProductoDTO(producto));
   }

    @Override
    public void delete(Integer idProducto) {
        productoCrudRepository.deleteById(idProducto);
    }
    @Override
    public ProductoDTO save(ProductoDTO productoDTO) {
        Producto producto = productoMapper.toProducto(productoDTO);
        return productoMapper.toProductoDTO(productoCrudRepository.save(producto));
    }

}
