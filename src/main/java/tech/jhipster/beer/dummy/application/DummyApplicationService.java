package tech.jhipster.beer.dummy.application;

import java.util.List;
import org.springframework.stereotype.Service;
import tech.jhipster.beer.dummy.domain.Dummy;
import tech.jhipster.beer.dummy.domain.DummyRepository;

@Service
public class DummyApplicationService {

  private final DummyRepository dummyRepository;

  public DummyApplicationService(DummyRepository dummyRepository) {
    this.dummyRepository = dummyRepository;
  }

  public List<Dummy> list() {
    return dummyRepository.list();
  }

  public void add(Dummy dummy) {
    dummyRepository.add(dummy);
  }

  public void clear() {
    dummyRepository.clear();
  }
}
