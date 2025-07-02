package com.eazybytes.eazyschool.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "roles")
@Data
public class RoleEntity extends BaseEntity{
    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @Column(length = 255)
    private String description;


    @ManyToMany(mappedBy = "roleEntities")
    private Set<UserEntity> userEntities = new HashSet<>();
}
