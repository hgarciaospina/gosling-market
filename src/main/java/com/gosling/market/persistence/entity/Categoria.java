package com.gosling.market.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private String idCategoria;
    @Column(nullable = false)
    private String descripcion;
    private Boolean estado;

    /* Relaciones */

    /* mappedBy corresponde al nombre del atributo de la entity
       Categoria en la entity Producto --> categoria.
    */
    @OneToMany(mappedBy = "categoria" )
    private List<Producto> productos;

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}