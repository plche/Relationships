package com.codingdojo.peru.ft2022.relationships.models;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Temporal(TemporalType.TIMESTAMP)
    @Generated(value = GenerationTime.INSERT)
    @Column(name = "created",
            updatable = false, insertable = false, nullable = false,
            columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date created;
    @Temporal(TemporalType.TIMESTAMP)
    @Generated(value = GenerationTime.ALWAYS)
    @Column(name = "updated", updatable = false, insertable = false, nullable = false,
            columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date updated;
    // @OneToOne: Define la relación 1:1 con otra entidad.
    // @OneToOne(mappedBy="person"): Asignará el atributo de licencia en la clase Persona al atributo de persona en la clase Licencia.
    // Representa el campo que posee la relación. Este elemento solo se especifica en el lado inverso (no propietario) de la asociación.
    // @OneToOne(cascade=CascadeType.ALL): Asegurará que la integridad referencial se conserve en TODAS las acciones.
    // @OneToOne(fetch=FetchType.LAZY): Si la asociación debe cargarse de forma diferida o debe buscarse con entusiasmo.
    // LAZY: La asociación se recupera cuando es necesario. EAGER: La asociación se recupera inmediatamente.
    // @JoinColumn(name="person_id"): Define la asignación de claves foráneas compuestas.
    // Indica que la tabla correspondiente a esta entidad tiene una clave foránea a la tabla referenciada.
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private License license;

    public Person() {
    }

    public Person(String firstName, String lastName, License license) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.license = license;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }
}
