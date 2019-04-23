package com.example.hospitalward.util;

import net.sf.json.JSONObject;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;


import java.util.Map;

public class LogHistoryUtils {

    public static ServerResult log(String relationKey, String description, Object o){
        JSONObject object = JSONObject.fromObject(o);
        String jsonstr = object.toString();
        HttpHeaders headers = new HttpHeaders();
        String url = "http://localhost:8080/log/log_history";
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
        bodyMap.add("relationKey", relationKey);
        bodyMap.add("description", description);
        bodyMap.add("remarks", jsonstr);
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ServerResult> responseEntity = null;
        responseEntity = restTemplate.postForEntity(url, requestEntity, ServerResult.class);
        return responseEntity.getBody();
    }
}
