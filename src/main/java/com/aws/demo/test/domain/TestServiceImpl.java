package com.aws.demo.test.domain;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.aws.demo.test.model.TestEntity;
import com.aws.demo.test.model.TestRequest;
import com.aws.demo.test.model.TestResponse;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@XRayEnabled
public class TestServiceImpl implements TestService {

  private TestRepository testRepository;

  public TestServiceImpl(TestRepository testRepository) {
    this.testRepository = testRepository;
  }

  @Override
  public TestResponse add(TestRequest request) {
    TestEntity entity = TestEntity.builder()
        .name(request.getName())
        .lastName(request.getLastName())
        .build();

    TestEntity savedEntity = testRepository.save(entity);

    return TestResponse.builder()
        .name(savedEntity.getName())
        .lastName(savedEntity.getLastName())
        .build();
  }

  @Override
  public TestResponse get(String id) {
    TestEntity foundEntity = testRepository.findById(new ObjectId(id))
        .orElse(TestEntity.builder()//todo should throw exception
            .name("--")
            .lastName("--")
            .build());

    return TestResponse.builder()
        .name(foundEntity.getName())
        .lastName(foundEntity.getLastName())
        .build();
  }

  @Override
  public List<TestResponse> getAll() {
    return testRepository.findAll()
        .stream()
        .map(entity -> TestResponse.builder()
            .name(entity.getName())
            .lastName(entity.getLastName())
            .build())
        .collect(Collectors.toList());
  }
}
