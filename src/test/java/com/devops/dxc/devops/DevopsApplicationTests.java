package com.devops.dxc.devops;

import com.devops.dxc.devops.model.RespuestaServicioRetiroDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class DevopsApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	WebApplicationContext webApplicationContext;

	@Autowired
	ObjectMapper objectMapper;

	protected void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void cuandoSueldoEs1000000Ahorro10000000RetiroEs1000000() throws Exception {
		String uri = "/rest/msdxc/dxc";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).queryParam("sueldo", "1000000").
				queryParam("ahorro", "10000000").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		RespuestaServicioRetiroDTO respuestaServicioRetiroDTO = objectMapper.
				readValue(mvcResult.getResponse().getContentAsByteArray(), RespuestaServicioRetiroDTO.class);

		int status = mvcResult.getResponse().getStatus();
		Assertions.assertEquals(200, status);
		Assertions.assertEquals("1000000.0", respuestaServicioRetiroDTO.getRetiro());
		Assertions.assertEquals("9000000.0", respuestaServicioRetiroDTO.getSaldo());
		Assertions.assertEquals("0.0", respuestaServicioRetiroDTO.getImpuesto());
	}

	@Test
	public void cuandoSueldoEs2000000Ahorro10000000RetiroEs8254690() throws Exception {
		String uri = "/rest/msdxc/dxc";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).queryParam("sueldo", "2000000").
				queryParam("ahorro", "10000000").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		RespuestaServicioRetiroDTO respuestaServicioRetiroDTO = objectMapper.
				readValue(mvcResult.getResponse().getContentAsByteArray(), RespuestaServicioRetiroDTO.class);

		int status = mvcResult.getResponse().getStatus();
		Assertions.assertEquals(200, status);
		Assertions.assertEquals("825469.0", respuestaServicioRetiroDTO.getRetiro());
		Assertions.assertEquals("9174531.0", respuestaServicioRetiroDTO.getSaldo());
		Assertions.assertEquals("174531.0", respuestaServicioRetiroDTO.getImpuesto());
	}

	@Test
	public void cuandoSueldoEs2700000Ahorro10000000RetiroEs635914() throws Exception {
		String uri = "/rest/msdxc/dxc";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).queryParam("sueldo", "2700000").
				queryParam("ahorro", "10000000").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		RespuestaServicioRetiroDTO respuestaServicioRetiroDTO = objectMapper.
				readValue(mvcResult.getResponse().getContentAsByteArray(), RespuestaServicioRetiroDTO.class);

		int status = mvcResult.getResponse().getStatus();
		Assertions.assertEquals(200, status);
		Assertions.assertEquals("635914.0", respuestaServicioRetiroDTO.getRetiro());
		Assertions.assertEquals("9364086.0", respuestaServicioRetiroDTO.getSaldo());
		Assertions.assertEquals("364086.0", respuestaServicioRetiroDTO.getImpuesto());
	}

	@Test
	public void cuandoSueldoEs3400000Ahorro10000000RetiroEs387604() throws Exception {
		String uri = "/rest/msdxc/dxc";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).queryParam("sueldo", "3400000").
				queryParam("ahorro", "10000000").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		RespuestaServicioRetiroDTO respuestaServicioRetiroDTO = objectMapper.
				readValue(mvcResult.getResponse().getContentAsByteArray(), RespuestaServicioRetiroDTO.class);

		int status = mvcResult.getResponse().getStatus();
		Assertions.assertEquals(200, status);
		Assertions.assertEquals("387604.0", respuestaServicioRetiroDTO.getRetiro());
		Assertions.assertEquals("9612396.0", respuestaServicioRetiroDTO.getSaldo());
		Assertions.assertEquals("612396.0", respuestaServicioRetiroDTO.getImpuesto());
	}

	@Test
	public void cuandoSueldoEs4700000Ahorro10000000RetiroEs19643() throws Exception {
		String uri = "/rest/msdxc/dxc";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).queryParam("sueldo", "4700000").
				queryParam("ahorro", "10000000").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		RespuestaServicioRetiroDTO respuestaServicioRetiroDTO = objectMapper.
				readValue(mvcResult.getResponse().getContentAsByteArray(), RespuestaServicioRetiroDTO.class);

		int status = mvcResult.getResponse().getStatus();
		Assertions.assertEquals(200, status);
		Assertions.assertEquals("19643.0", respuestaServicioRetiroDTO.getRetiro());
		Assertions.assertEquals("9980357.0", respuestaServicioRetiroDTO.getSaldo());
		Assertions.assertEquals("980357.0", respuestaServicioRetiroDTO.getImpuesto());
	}

	@Test
	public void cuandoSueldoEs5100000Ahorro20000000RetiroEs705948() throws Exception {
		String uri = "/rest/msdxc/dxc";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).queryParam("sueldo", "5100000").
				queryParam("ahorro", "20000000").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		RespuestaServicioRetiroDTO respuestaServicioRetiroDTO = objectMapper.
				readValue(mvcResult.getResponse().getContentAsByteArray(), RespuestaServicioRetiroDTO.class);

		int status = mvcResult.getResponse().getStatus();
		Assertions.assertEquals(200, status);
		Assertions.assertEquals("705948.0", respuestaServicioRetiroDTO.getRetiro());
		Assertions.assertEquals("1.9294052E7", respuestaServicioRetiroDTO.getSaldo());
		Assertions.assertEquals("1294052.0", respuestaServicioRetiroDTO.getImpuesto());
	}

	@Test
	public void cuandoSueldoEs6100000Ahorro20000000RetiroEs508958() throws Exception {
		String uri = "/rest/msdxc/dxc";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).queryParam("sueldo", "6100000").
				queryParam("ahorro", "20000000").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		RespuestaServicioRetiroDTO respuestaServicioRetiroDTO = objectMapper.
				readValue(mvcResult.getResponse().getContentAsByteArray(), RespuestaServicioRetiroDTO.class);

		int status = mvcResult.getResponse().getStatus();
		Assertions.assertEquals(200, status);
		Assertions.assertEquals("508958.0", respuestaServicioRetiroDTO.getRetiro());
		Assertions.assertEquals("1.9491042E7", respuestaServicioRetiroDTO.getSaldo());
		Assertions.assertEquals("1491042.0", respuestaServicioRetiroDTO.getImpuesto());
	}
}
