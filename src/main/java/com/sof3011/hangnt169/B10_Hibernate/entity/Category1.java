package com.sof3011.hangnt169.B10_Hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "category") // ten bang trong CSDL
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Category1 {
    /**
     * J3: JDBC (Java Database Conectivity)
     *      => Truy van tren dua vao cau SQL trong DB
     * J4: Hibernate
     *      C1: Truy van dung cau SQL
     *      C2: Truy van dung HQL(Hibernate Query Language)
     *          => Truy van tren thuc the (Truy van tren CLASS)
     * J5: JPA
     *      C1: Truy van cau SQL (native query)
     *      C2: Truy van bang JPQL(JPA Query Language)
     *          => Van la truy van tren thuc the (tren class)\
     *      C3: rawsql
     *  ORM(Object Relationship Mapping)
     *  1. Table:
     *      + Bien class => Thanh table de truy van
     *      + Bien thuoc tinh => Thanh column trong table
     *          + cot binh thuong => column
     *          + Khoa chinh
     *          + khoa ngoai
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Ten trong CSDL. Neu ten khac => Bat buoc them name
    private Long id123;

    @Column(name = "category_code")
    private String categoryCode;

    @Column(name = "category_name")
    private String categoryName;

}
