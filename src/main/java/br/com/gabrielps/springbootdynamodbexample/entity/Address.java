package br.com.gabrielps.springbootdynamodbexample.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBDocument
public class Address implements Serializable {

    @DynamoDBAttribute
    private String city;

    @DynamoDBAttribute
    private String state;

    @DynamoDBAttribute
    private String pinCode;

}
