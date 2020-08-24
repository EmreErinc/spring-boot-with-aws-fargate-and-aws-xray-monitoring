package com.aws.demo.test.api;

import com.aws.demo.test.domain.TestService;
import com.aws.demo.test.model.TestRequest;
import com.aws.demo.test.model.TestResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

  private TestService testService;

  public TestController(TestService testService) {
    this.testService = testService;
  }

  @PostMapping()
  public TestResponse add(@RequestBody TestRequest request) {
    return testService.add(request);
  }

  @GetMapping("{id}")
  public TestResponse get(@PathVariable String id) {
    return testService.get(id);
  }


  @GetMapping()
  public List<TestResponse> getAll() {
    return testService.getAll();
  }
}
