package tech.jhipster.beer.dummy.infrastructure.primary.rest;

import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tech.jhipster.beer.IntegrationTest;
import tech.jhipster.beer.TestUtil;
import tech.jhipster.beer.dummy.application.DummyApplicationService;
import tech.jhipster.beer.dummy.domain.Dummy;

@IntegrationTest
@AutoConfigureMockMvc
class DummyResourceIT {

  @Autowired
  DummyApplicationService dummyApplicationService;

  @Autowired
  MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    dummyApplicationService.clear();
  }

  @Test
  void shouldList() throws Exception {
    dummyApplicationService.add(Dummy.of("beer"));

    mockMvc
      .perform(get("/api/dummy"))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
      .andExpect(jsonPath("$.[*].name").value(hasItem("beer")));
  }

  @Test
  void shouldCreate() throws Exception {
    mockMvc
      .perform(post("/api/dummy").contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(Dummy.of("beer"))))
      .andExpect(status().isOk());

    List<Dummy> result = dummyApplicationService.list();
    assertThat(result).isNotEmpty();
    assertThat(result.get(0).name()).isEqualTo("beer");
  }

  @Test
  void shouldClear() throws Exception {
    mockMvc.perform(delete("/api/dummy")).andExpect(status().isOk());

    List<Dummy> result = dummyApplicationService.list();
    assertThat(result).isEmpty();
  }
}
