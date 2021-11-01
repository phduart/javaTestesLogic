package br.com.projectSpringForTest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ptrr01")
public class Ptrr01 {

    @Id
    @Column(name = "POLIZA")
    private Integer poliza;
    @Column(name = "APLICA")
    private Integer aplica;

    public Integer getPoliza() {
        return poliza;
    }

    public void setPoliza(Integer poliza) {
        this.poliza = poliza;
    }

    public Integer getAplica() {
        return aplica;
    }

    public void setAplica(Integer aplica) {
        this.aplica = aplica;
    }
}
