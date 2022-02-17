package com.planningInspectorate;

import com.planningInspectorate.security.securityConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class PlanningInspectorateApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testLogin(){
		@RunWith(SpringRunner.class)
		@WebMvcTest(securityConfig.class)
		class SecuredControllerWebMvcIntegrationTest {

//			@Configuration
//			@EnableWebSecurity
//			class Config extends WebSecurityConfigurerAdapter {
//				@Autowired
//				public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////					auth.inMemoryAuthentication().withUser("user").password("sion");
//					auth.inMemoryAuthentication().withUser("nonuser").password("pa$$");
//				}
//			}

			@Autowired
			private MockMvc mvc;

			@WithMockUser(value = "nonuser")
			@Test
			public void givenAuthRequestOnPrivateService_shouldSucceedWith200() throws Exception {
				mvc.perform(get("/login").contentType(APPLICATION_JSON))
						.andExpect(status().isOk())
						.andDo(print());
			}
		}


	}

}
