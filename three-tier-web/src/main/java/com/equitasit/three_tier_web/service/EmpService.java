package com.equitasit.three_tier_web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.equitasit.three_tier_web.dto.EmpDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmpService {

	@Value("${emp.url}")
	private String empUrl;

	private RestTemplate restTemplate = new RestTemplate();

	private ObjectMapper mapper = new ObjectMapper();

	public EmpDto save(EmpDto empDto) throws Exception {

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);

		String jsonBody = mapper.writeValueAsString(empDto);

		HttpEntity<String> request = new HttpEntity<String>(jsonBody, headers);

		ResponseEntity<EmpDto> responseEntity = restTemplate.postForEntity(empUrl + "/save", request, EmpDto.class);

		return responseEntity.getBody();
	}

	public void remove(Integer empId) {

		String finalUrl = UriComponentsBuilder.fromHttpUrl(empUrl + "/remove").queryParam("empId", empId).encode()
				.toUriString();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		restTemplate.delete(finalUrl);

	}

	public EmpDto getEmp(Integer empId) {
		String finalUrl = UriComponentsBuilder.fromHttpUrl(empUrl + "/get").queryParam("empId", empId).encode()
				.toUriString();
		ResponseEntity<EmpDto> responseEntity = restTemplate.getForEntity(finalUrl, EmpDto.class);
		return responseEntity.getBody();
	}

	public List<EmpDto> getAll() {

		ResponseEntity<List<EmpDto>> responseEntity = restTemplate.exchange(empUrl + "/list", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<EmpDto>>() {
				});

		return responseEntity.getBody();
	}

}
