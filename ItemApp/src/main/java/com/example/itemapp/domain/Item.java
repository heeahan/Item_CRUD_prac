package com.example.itemapp.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity /* This annotation is from Jakarta Persistence (formerly JPA).
It marks the class as an entity, meaning it will be mapped to a database table.
Each instance of this class represents a row in the database table defined by @Table. */
@Table(name = "items") /////////////// 임시 사용, DB 이름 아직 미정 !!!!!!!!!!! //////////////
/* Specifies the table name (" ") in the database where this entity is mapped.
The name attribute specifies the actual name of the database table. */

public class Item {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY) // Id column
    private long id;

    @Column(name = "Title") // Title column, below are the columns in DB, too
    private String title;

    @Column(name = "Description")
    private String description;

    @Column(name = "Quantity")
    private Long quantity;

    public Item(String title, String description, long quantity){
        this.title = title;
        this.description = description;
        this.quantity = quantity;
    }

}
