package com.mocks.sample.mockitoSample;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AllPostRequestsTests {
	
	private MockMvc mockMvc;

	@InjectMocks
	private AllPostRequests allPostRequests;
	
	@Before
	public void setUp() {
		mockMvc=MockMvcBuilders.standaloneSetup(allPostRequests).build();
	}
	
	
	@Test
	public void verifyCreateRecordPostAPI() throws Exception{
		
		String request=new CreateJsonForPostPojo().getPojo("George", "Design Engineer", "Canada", "Ontario", "873383", "34", "B.E");
		mockMvc.perform(post("/post/postjson")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(request)).andExpect(status().isCreated());
	}

	@Test
	public void verifyCreateRecordPostAPIWithnoBody() throws Exception{
		
		String request="";
		mockMvc.perform(post("/post/postjson")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(request)).andExpect(status().is(400));
	}
	
	
	@Test
	public void verifyCreateRecordPostAPIWithInvalidURL() throws Exception{
		String request="";
		mockMvc.perform(post("/post/postjson1")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(request)).andExpect(status().is(404));
	}
}
