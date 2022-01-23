package tech.jhipster.beer.dummy.infrastructure.primary.rest;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.beer.dummy.application.DummyApplicationService;
import tech.jhipster.beer.dummy.domain.Dummy;

@RestController
@RequestMapping("/api/dummy")
class DummyResource {

  private final DummyApplicationService dummyApplicationService;

  public DummyResource(DummyApplicationService dummyApplicationService) {
    this.dummyApplicationService = dummyApplicationService;
  }

  @GetMapping
  public List<Dummy> list() {
    return dummyApplicationService.list();
  }

  @PostMapping
  public void create(@RequestBody Dummy dummy) {
    dummyApplicationService.add(dummy);
  }

  @DeleteMapping
  public void clear() {
    dummyApplicationService.clear();
  }
}
