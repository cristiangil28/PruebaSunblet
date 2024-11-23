package com.cristian;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;

import com.cristian.service.ClienteService;

@SpringBootTest
@AutoConfigureMockMvc
class ApiSunbletApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ClienteService clienteService;
	
	@Test
	void testGetCliente() throws Exception {
		LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
				requestParams.add("tipoDocumento", "C");
				requestParams.add("documento", "10121314");

				mockMvc.perform(get("/api/cliente").params(requestParams)).andExpect(status().isOk());
	}
	
	@Test
	void fallatestGetCliente() throws Exception {
		LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
				requestParams.add("tipoDocumento", "C");
				requestParams.add("documento", "10121314");

				mockMvc.perform(get("/api/cliente").params(requestParams)).andExpect(status().isNotFound());
	}

}
