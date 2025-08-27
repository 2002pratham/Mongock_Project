package com.example.demo.changelog;

import entity.User;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.ArrayList;
import java.util.List;

@ChangeUnit(order = "001", id = "DataChange", author = "me")
public class changelogs {

    @Execution
    public void databaseChange(MongoTemplate mongoTemplate) {
        List<User> userList = new ArrayList<>();

        User user1 = new User();
        user1.setName("Pratham");
        user1.setEmail("abc@gmail.com");

        User user2 = new User();
        user2.setName("Reaper");
        user2.setEmail("qwe@gmail.com");

        userList.add(user1);
        userList.add(user2);

        mongoTemplate.insert(userList, "users");
    }

    @RollbackExecution
    public void rollbackDatabaseChange(MongoTemplate mongoTemplate) {
        mongoTemplate.remove(
                Query.query(Criteria.where("email").in("abc@gmail.com", "qwe@gmail.com")),
                User.class,
                "users"
        );
    }

}

