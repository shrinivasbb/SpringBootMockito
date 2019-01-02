package com.mocks.sample.mockitoSample;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AllGetRequestsTests {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private AllGetRequests allGetRequests;
	
	@Before
	public void setUp() {
		mockMvc=MockMvcBuilders.standaloneSetup(allGetRequests)
				               .build();
	}

	@Test
	public void verifyGetRequestandVerifyContentInResponse() throws Exception  {
		mockMvc.perform(get("/get"))
		       .andExpect(status().isOk()).andExpect(content().string("H"));
	}
	
	@Test
	public void verifyGetRequestandExtractAValueAndVerify() throws Exception {
		mockMvc.perform(get("/get/json"))
		       .andExpect(status().isOk())
		       .andExpect(jsonPath("$.title").value("Hello"));
	}
	
	@Test
	public void verifyInvalidGetRequest() throws Exception {
		mockMvc.perform(get("/get/json1"))
		       .andExpect(status().is(404));
	}

}

