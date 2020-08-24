package com.aws.demo.test.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("test")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TestEntity {

  ObjectId id;
  String name;
  String lastName;
}
