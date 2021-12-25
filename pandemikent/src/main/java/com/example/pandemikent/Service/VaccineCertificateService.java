package com.example.pandemikent.Service;

import java.util.Optional;

import com.example.pandemikent.Model.VaccineCertificate;
import com.example.pandemikent.Repo.VaccineCertificateRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

@Service
public class VaccineCertificateService {
    
    @Autowired
    private VaccineCertificateRepo vacCerRepository;
    @Autowired
    private UserProfileAccessService accessService;

    public VaccineCertificate storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = accessService.getCurrentUser() + "_vacccine_certificate";
        String username = accessService.getCurrentUser(); /// get the username here
        System.out.println("fadjlkfaljfgks");
        try {
            // // Check if the file's name contains invalid characters
            // if(fileName.contains("..")) {
            //     throw new Exception("Sorry! Filename contains invalid path sequence " + fileName);
            // }
        System.out.println("fadjlkfaljfgks");
        VaccineCertificate vac = new VaccineCertificate( username, fileName, file.getContentType(), file.getBytes());
            System.out.println("fadjlkfaljfgks");
            return vacCerRepository.save(vac);
        } 
        finally {
            return null;
        }// catch (Exception ex) {
        //     // throw new Exception("Could not store file " + fileName + ". Please try again!", ex);
        //     System.out.print("Exception during file upload.");
        // }

        // return null;
    }

    public VaccineCertificate getFile(String fileId) {
        if (vacCerRepository.findById(fileId).isPresent());
            return vacCerRepository.findById(fileId).get();
    }
}
