package calculate.controller;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class SumControllerTest {

  private MockMvc mockMvc;

  private ObjectMapper objectMapper;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(new SumController()).alwaysDo(print()).build();
    objectMapper = new ObjectMapper();
  }

  @Test
  public void sum_whenValidParam_thenSumCorrect() throws Exception {
    MockHttpServletResponse response = mockMvc.perform(get("/v1/sum")
        .param("first", "5")
        .param("second", "10"))
        .andExpect(status().isOk()).andReturn().getResponse();

    Map actualResponse = objectMapper.readValue(response.getContentAsString(), Map.class);
    assertThat(actualResponse.get("sum"), is("15"));
  }
}
