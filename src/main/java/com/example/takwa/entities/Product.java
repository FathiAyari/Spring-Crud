package com.example.takwa.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "bar_code", nullable = false)
    private String bar_code;
    @Column(name = "price", nullable = false)
    private Long price;
    @Column(name = "rate", nullable = false)
    private Long rate;
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;
}
