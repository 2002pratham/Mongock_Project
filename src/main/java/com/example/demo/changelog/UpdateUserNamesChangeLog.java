package com.example.demo.changelog;


import entity.User;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;

import org.springframework.data.mongodb.core.query.Query;

@ChangeUnit(order = "002", id = "UpdateUserNames", author = "me")
public class UpdateUserNamesChangeLog {

    @Execution
    public void updateNames(MongoTemplate mongoTemplate) {
        Query query = new Query();
        Update update = new Update().set("name", "Sharma");

        mongoTemplate.updateMulti(query, update, User.class);
    }

    @RollbackExecution
    public void rollbackUpdateNames(MongoTemplate mongoTemplate) {
    }
}