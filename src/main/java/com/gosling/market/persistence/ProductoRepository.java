package com.gosling.market.persistence;

import com.gosling.market.persistence.crud.ProductoCrudRepository;
import com.gosling.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(Integer idCategoria) {
        return productoCrudRepository.findByIdCategoriaOrderByDescripcionAsc(idCategoria);
    }

    public Optional<List<Producto>> getStockBajo(int cantidadStock) {
        return productoCrudRepository.findByCantidadStockLessThanEstado(cantidadStock, true);
    }

   public Optional<Producto> getProducto(int idProducto) {
        return productoCrudRepository.findById(idProducto);
   }

   public Producto save(Producto producto) {
        return productoCrudRepository.save(producto);
   }

   public void delete(int idProducto) {
        productoCrudRepository.deleteById(idProducto);
   }
}
