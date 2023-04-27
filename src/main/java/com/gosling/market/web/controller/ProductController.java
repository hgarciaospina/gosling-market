package com.gosling.market.web.controller;

import com.gosling.market.domain.dto.ProductoDTO;
import com.gosling.market.domain.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductoDTO> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<ProductoDTO> getProductoDTO(@PathVariable("id") Integer idProducto){
        return  productService.getProductoDTO(idProducto);
    }

    @GetMapping("/categoria/{id}")
    public Optional<List<ProductoDTO>> getByCategoriaDTO(@PathVariable("id") Integer idCategoria){
        return productService.getByCategoriaDTO(idCategoria);
    }

    @PostMapping
    public ProductoDTO save(@Valid @RequestBody ProductoDTO productoDTO) {
        return productService.save(productoDTO);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Integer idProducto) {
        return productService.delete(idProducto);
    }

}
