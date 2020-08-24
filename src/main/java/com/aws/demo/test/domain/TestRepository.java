package com.aws.demo.test.domain;

import com.aws.demo.test.model.TestEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends MongoRepository<TestEntity, ObjectId> {
}
