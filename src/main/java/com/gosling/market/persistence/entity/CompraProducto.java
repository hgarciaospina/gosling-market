package com.gosling.market.persistence.entity;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="Compras_productos")
public class CompraProducto {

    @EmbeddedId
    private CompraProductoPK id;
    private Integer cantidad;
    private Double total;
    private Boolean estado;


}
