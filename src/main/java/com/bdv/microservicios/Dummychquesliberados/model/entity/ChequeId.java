package com.bdv.microservicios.Dummychquesliberados.model.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@NoArgsConstructor

@Getter
@Setter
@Embeddable
public class ChequeId implements Serializable {
    String serial;
    String banco;
    String oficina;
    String dv;
    String cuenta;

    public ChequeId(String serial, String banco, String oficina, String dv, String cuenta) {
        this.serial = serial;
        this.banco = banco;
        this.oficina = oficina;
        this.dv = dv;
        this.cuenta = cuenta;
    }
}
