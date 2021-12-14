package com.example.pandemikent.Services;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.Query;
import com.example.pandemikent.Model.PCR;
import com.example.pandemikent.Model.Vaccine;
import com.example.pandemikent.Repo.HESCodeRepository;
import com.example.pandemikent.Repo.PCRRepository;
import com.example.pandemikent.Repo.VaccineRepository;

@Service
public class CovidHistoryService {
	
	@Autowired
	private PCRRepository pcrRepoitory;
	
	@Autowired
	private VaccineRepository vaccineRepository;
	
	@Autowired
	private HESCodeRepository hesCodeRepository;
	
	@Autowired 
	private EntityManager entityManager;
	
	public PCR savePCR(PCR pcr) {
		return pcrRepoitory.save(pcr);
	}
	
	public Boolean addVaccineAppointment(Vaccine vacApt) {
		vacApt.setSuccessful(false);
		vaccineRepository.save(vacApt);
		return true;
	}
	
	public Boolean addVaccineCertificate() {
		return true;
	}
	
	public Boolean getCovidHistory() {
		return true;
	}
	
	public List<PCR> listUserPCRs(String id) {
		Query q = entityManager.createNativeQuery("SELECT * FROM pandemikent.PCR WHERE patient_id = :pId;", PCR.class);
		q.setParameter("pId", id);
		
		return q.getResultList();
	}

}