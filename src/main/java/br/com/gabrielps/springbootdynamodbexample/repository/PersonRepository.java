package br.com.gabrielps.springbootdynamodbexample.repository;

import br.com.gabrielps.springbootdynamodbexample.entity.Person;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PersonRepository {

    @Autowired
    private DynamoDBMapper mapper;

    public Person addPerson(Person person){
        mapper.save(person);
        return person;
    }

    public Person findById(String personId){
        return mapper.load(Person.class, personId);
    }

    public void deletePerson(Person person){
        mapper.delete(person);
    }

    public void editPerson(Person person){
        mapper.save(person, buildExpression(person));
    }

    private DynamoDBSaveExpression buildExpression(Person person){
        DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
        Map<String, ExpectedAttributeValue> expectedAttributeValueMap = new HashMap<>();
        expectedAttributeValueMap.put("personId", new ExpectedAttributeValue(new AttributeValue().withS(person.getPersonId())));
        dynamoDBSaveExpression.setExpected(expectedAttributeValueMap);
        return dynamoDBSaveExpression;
    }

}
