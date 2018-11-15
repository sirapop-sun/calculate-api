package calculate.controller;

import java.util.Collections;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class SumController {

  @GetMapping("/sum")
  @ResponseStatus(HttpStatus.OK)
  public Map<String, String> sum(@RequestParam(name = "first") int first,
      @RequestParam(name = "second") int second) {
    String sum = String.valueOf(first + second);
    return Collections.singletonMap("sum", sum);
  }
}
