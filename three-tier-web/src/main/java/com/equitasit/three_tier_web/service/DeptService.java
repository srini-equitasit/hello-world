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

import com.equitasit.three_tier_web.dto.DeptDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DeptService {

	@Value("${dept.url}")
	private String deptUrl;

	private RestTemplate restTemplate = new RestTemplate();

	private ObjectMapper mapper = new ObjectMapper();

	public DeptDTO save(DeptDTO deptDTO) throws Exception {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		String jsonBody = mapper.writeValueAsString(deptDTO);

		HttpEntity<String> request = new HttpEntity<String>(jsonBody, headers);

		ResponseEntity<DeptDTO> responseEntity = restTemplate.postForEntity(deptUrl + "/save", request, DeptDTO.class);

		return responseEntity.getBody();
	}

	public void remove(Integer deptNo) {

		String finalUrl = UriComponentsBuilder.fromHttpUrl(deptUrl + "/remove").queryParam("deptId", deptNo).encode()
				.toUriString();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		restTemplate.delete(finalUrl);

	}

	public DeptDTO get(Integer deptno) {
		String finalUrl = UriComponentsBuilder.fromHttpUrl(deptUrl + "/get").queryParam("deptId", deptno).encode()
				.toUriString();
		ResponseEntity<DeptDTO> responseEntity = restTemplate.getForEntity(finalUrl, DeptDTO.class);
		return responseEntity.getBody();
	}

	public List<DeptDTO> getAll() {
		
		ResponseEntity<List<DeptDTO>> responseEntity = restTemplate.exchange(deptUrl + "/list", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<DeptDTO>>() {
				});
		
		return responseEntity.getBody();
	}
}
