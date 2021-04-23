package com.example.courseWork.models;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreatedDate
    @Column(name="created")
    private Date created;

    @LastModifiedDate
    @Column(name = "update")
    private Date update;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private String status;
}
