package com.example.pandemikent.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.example.pandemikent.Model.Class;
import com.example.pandemikent.Model.Instructor;
import com.example.pandemikent.Model.Section;
import com.example.pandemikent.Model.Student;
import com.example.pandemikent.Model.UserProfile;
import com.example.pandemikent.Repo.ClassRepository;
import com.example.pandemikent.Repo.InstructorRepository;
import com.example.pandemikent.Repo.QuarantineRepository;
import com.example.pandemikent.Repo.SectionRepository;
import com.example.pandemikent.Repo.StudentRepository;

@Service
public class ClassService {
	@Autowired
  	private StudentRepository studentRepository;
	
  	@Autowired
  	private InstructorRepository instructorRepository;
	
  	@Autowired
  	private ClassRepository classRepository;
	
  	@Autowired
  	private SectionRepository sectionRepository; 
	
  	@Autowired
  	private QuarantineRepository quarantineRepository;
	
  	public Class save(String classId, String sectionId, String instrId) {
		Optional<Instructor> temp = instructorRepository.findById(instrId);
		System.out.println("Rajlkjfa1323");
		if (temp.isEmpty())
			return null;
		System.out.println("Rajlkjfa1323");
		Instructor instr = temp.get();
		
  		if(classRepository.findById(classId).isEmpty()) {

			System.out.println("gjlkaeooqp");
			instr.getClasses().add(classId);
			instructorRepository.save(instr);
  			Class newClass = new Class();
  			newClass.setName(classId);
  			Section newSection = new Section();
  			newSection.setInstructor(instr.getUsername());
  			newSection.setSectionNumber(sectionId);
  			ArrayList<Section> sections = new ArrayList<Section>();
  			sections.add(newSection);
			ArrayList<String> t = new ArrayList<String>();
			t.add(sectionId);
  			newClass.setSections(t);
  			return classRepository.save(newClass);
  		}
  		else {
  			Boolean b = false;
  			for( String s : classRepository.getById(classId).getSections()) {
  				if(s == sectionId) {
  					b = true;
  					break;
  				}
  			}
			  System.out.println("fqipiro14");
  			if(b)
  				return null;
  			else {
				System.out.println("dlkqjtq");
				instr.getClasses().add(classId);
				instructorRepository.save(instr);
  				Section newSection = new Section();
  	  			newSection.setInstructor(instr.getUsername());
  	  			newSection.setSectionNumber(sectionId);
				sectionRepository.save(newSection);
	  	  		ArrayList<String> sections = (ArrayList<String>)classRepository.getById(classId).getSections();
				sectionRepository.save(newSection);
	  			sections.add(sectionId);
	  			classRepository.getById(classId).setSections(sections);
				Class c = classRepository.findById(classId).get();
				c.setSections(sections);
	  			return classRepository.save(c);
  			}
  		}
  	}
	
  	public List<String> listUserClasses(String userId) {
		System.out.println("Efjalkjflal");
  		if(studentRepository.findById(userId).isPresent()) {
			System.out.println("Efjalkjflal");
  			return studentRepository.findById(userId).get().getClasses();
  		}
  		else if(instructorRepository.findById(userId).isPresent()) {
  			return instructorRepository.findById(userId).get().getClasses();
  		}
  		else 
  			return null;
  	}
	
  	// public List<Section> listUserSections(String userId, String classId) {
  	// 	List<Section> sections = classRepository.getById(classId).getSections();
  	// 	for(Section section: sections) {
  	// 		if(section.getInstructor().getUsername() != userId) {
  	// 			sections.remove(section);
  	// 		}
  	// 	}
  	// 	return sections;
  	// }
	
  	public Class addClass(Class newClass) {
  		return classRepository.save(newClass);
  	}
	
  	// public Boolean joinClass(Class joinClass, Section joinSection, String userId) {
  	// 	Class c = classRepository.findById(joinClass.getName()).get();
  	// 	if(c == null) {
  	// 		return false;
  	// 	}
  	// 	else {
  	// 		for(String s : c.getSections()) {
  	// 			if(s == joinSection.getSectionNumber()) {
  	// 				joinSection = s;
  	// 				break;
  	// 			}
  	// 		}
  	// 		if(joinSection.getInstructor() == null) {
  	// 			return false;
  	// 		}
  	// 		else {
  	// 			Student stu = studentRepository.findById(userId).get();
  	// 			stu.getClasses().add(c.getName());
  	// 			c.getStudents().add(stu);
  	// 			joinSection.getStudents().add(stu);
  	// 			return true;
  	// 		}
  	// 	}
  	// }
	
  	public ArrayList<Student> listParticipants(Long sectionId) {
  		return (ArrayList<Student>) sectionRepository.getById(sectionId).getStudents();
  	}
	
  	public List<Date> getMissedClasses() {
  		return null;
  	}
	
  	// public Instructor getSectionInstr(Long sectionId) {
  	// 	return sectionRepository.findById(sectionId).get().getInstructor();
  	// }
	
  	public Boolean getUserAccess(String userId) {
  		//return studentRepository.findById(userId).get().getCampusAccess();
  		return true;
  	}
	
  	public ArrayList<Student> listQuarantinedStudents(String classId, String instrId) {
  		return null;
  	}
  	
  	public String getUserId() {
  		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

  		String username;
  		if (principal instanceof UserDetails) {
  		  username = ((UserDetails)principal).getUsername();
  		} else {
  		  username = principal.toString();
  		}
  		
  		return username;
  	}
}
