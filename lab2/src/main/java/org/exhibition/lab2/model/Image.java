package org.exhibition.lab2.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

@Data
@Entity
@Table (name = "images")
public class Image implements Model{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id", nullable = false)
    private int id;

    @Column(name = "image_execution")
    private String execution;

    @Column(name = "image_creation_date")
    private String creationDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "author_id", referencedColumnName = "author_id")
    private Author author;

}
