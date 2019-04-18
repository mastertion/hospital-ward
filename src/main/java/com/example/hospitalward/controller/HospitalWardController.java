package com.example.hospitalward.controller;

import com.example.hospitalward.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class HospitalWardController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/index_v1")
    public String index() {
        return  "index_v1";
    }
    @GetMapping("/staff")
    public String staff() {
        return  "staffList";
    }
    @GetMapping("/medicinal")
    public String medicinal() {
        return  "medicinalList";
    }
    @GetMapping("/careRecord")
    public String careRecord() {
        return  "careRecordList";
    }
    @GetMapping("/carePlan")
    public String carePlan() {
        return  "carePlanList";
    }
    @GetMapping("/patient")
    public String patient() {
        return  "patientList";
    }
    @GetMapping("/account")
    public String account() {
        return  "accountList";
    }
    @RequestMapping("/upload")
    @ResponseBody
    public Map uploadFile(@RequestParam("smfile") MultipartFile smfile)throws Exception{
        HttpHeaders headers = new HttpHeaders();
        String url = "https://api.yum6.cn/sinaimg.php/sinaimg.php";
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
        bodyMap.add("type", "multipart");
        bodyMap.add("file", new FileSystemResource(convert(smfile)));
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> responseEntity = null;

             responseEntity = restTemplate.postForEntity(url, requestEntity, Map.class);


        return responseEntity.getBody();


}
    public static File convert(MultipartFile file)
    {
        File convFile = new File(file.getOriginalFilename());
        try {
            convFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return convFile;
    }


}
