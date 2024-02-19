package com.vikram.awsWebServiceTest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


//@Document
@Entity

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    //@MongoId
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //private String id;
    private Long id;
    private String title;

    private String author;
}
