package com.gosling.market.persistence.crud;

import com.gosling.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    List<Producto> findByIdCategoriaOrderByDescripcionAsc(Integer idCategoria);

    //Equivalente al anterior método con @Query
    @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<Producto> getByIdCategoria(int idCategoria);

    //Lista productos cuya cantidad es menor a la ingreasada por parámetro y estánj activos
    Optional<List<Producto>> findByCantidadStockLessThanEstado(int cantidadStock, boolean estado);
}
