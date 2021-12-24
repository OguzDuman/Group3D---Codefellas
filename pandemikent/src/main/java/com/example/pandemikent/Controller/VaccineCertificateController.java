package com.example.pandemikent.Controller;

import com.example.pandemikent.Model.VaccineCertificate;
import com.example.pandemikent.Service.VaccineCertificateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
public class VaccineCertificateController {
    @Autowired
    private VaccineCertificateService vCertificateService;

    @PostMapping("/uploadCertificate")
    public @ResponseBody String uploadCertificate(@RequestParam("cert") MultipartFile file) {
        VaccineCertificate vac = vCertificateService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(vac.getUsername())
                .toUriString();

        return "saved";

    }

    @GetMapping("/doc")
    public String uploadCertificate() {

        return "doc";

    }
}
