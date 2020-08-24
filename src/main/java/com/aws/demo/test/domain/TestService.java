package com.aws.demo.test.domain;

import com.aws.demo.test.model.TestRequest;
import com.aws.demo.test.model.TestResponse;

import java.util.List;

public interface TestService {

  TestResponse add(TestRequest request);

  TestResponse get(String id);

  List<TestResponse> getAll();
}
