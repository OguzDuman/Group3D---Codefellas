// package com.example.pandemikent.Controller;

// import com.example.pandemikent.Repo.VaccineRepository;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.ResponseBody;

// @Controller
// public class VaccineController {
//     @Autowired
//     private final CovidHistoryService vaccineInfo;

//     @GetMapping("/displayVaccineHistory")
//     public @ResponseBody String displayVaccineTrackerPage() {
//         // url of the page
        
//         return vaccineInfo.getVaccineHistory(); // add this method 
//     }

//     @PostMapping("/addVaccineCertificate")
//     public @ResponseBody String displayAddVaccineCertificatePage() {
//         // url of the page
//         return "the page name";
//     }

//     @PostMapping("/addVaccineCertificate")
//     public @ResponseBody String displayAddVaccineAppointmentPage() {
//         // url of the page
//         return "the page name";
//     }
// }
