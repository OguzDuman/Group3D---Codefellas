package com.example.pandemikent.Controller;


import com.example.pandemikent.Model.VaccineCertificate;
import com.example.pandemikent.Service.UserProfileAccessService;
import com.example.pandemikent.Service.VaccineCertificateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
public class VaccineCertificateController {
    @Autowired
    private VaccineCertificateService vCertificateService;

    @Autowired
    private UserProfileAccessService accessService;

    @PostMapping("/uploadFile")
    public @ResponseBody String uploadCertificate(@RequestParam("file") MultipartFile file) {
        System.out.println("djfakljfkakljg");
        vCertificateService.storeFile(file);

        return "saved";

    }

    @GetMapping("/doc")
    public String uploadCertificate() {

        return "doc";

    }
}
