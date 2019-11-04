package com.example.service.domain;

import com.example.service.domain.validation.HasGoodName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */
@Entity
@Data
@Builder
@JsonDeserialize(using = CustomerDeserializer.class)
public class Customer{
    @Id
    @GeneratedValue
    private long id;
    @HasGoodName(value = "inputValue")
    private String customerName;
    @Min(5)
    // @NotNull this does not work on primitives
    private int test;

}
