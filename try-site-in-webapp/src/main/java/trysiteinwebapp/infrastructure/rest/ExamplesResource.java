package trysiteinwebapp.infrastructure.rest;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
    value="/examples",
    consumes=MediaType.APPLICATION_JSON_VALUE,
    produces=MediaType.APPLICATION_JSON_VALUE
)
public class ExamplesResource {

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<?> get() {
    return ResponseEntity.ok("Hello world");
  }
  
}
