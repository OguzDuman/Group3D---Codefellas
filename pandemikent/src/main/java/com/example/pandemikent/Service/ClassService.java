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
		if (temp.isEmpty())
			return null;
		Instructor instr = temp.get();
		
  		if(classRepository.findById(classId).isEmpty()) {
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
			  
  			if(b)
  				return null;
  			else {
				instructorRepository.save(instr);
  				Section newSection = new Section();
  	  			newSection.setInstructor(instr.getUsername());
  	  			newSection.setSectionNumber(sectionId);
				sectionRepository.save(newSection);
	  	  		List<String> sections = classRepository.getById(classId).getSections();
				sectionRepository.save(newSection);
	  			sections.add(sectionId);
	  			classRepository.getById(classId).setSections(sections);
				Class c = classRepository.findById(classId).get();
				c.setSections(sections);
	  			return update(c);
  			}
  		}
  	}
  	
  	public Class update(Class entity) {
  		if(!classRepository.existsById(entity.getName()))
			return null;
		else {
			Class exit = classRepository.findById(entity.getName()).orElse(null);
			
			exit.setName(entity.getName() != null ? entity.getName() : exit.getName());
			exit.setStudents(entity.getStudents() != null ? entity.getStudents() : exit.getStudents());
			exit.setTimeSlots(entity.getTimeSlots() != null ? entity.getTimeSlots() : exit.getTimeSlots());
			exit.setSections(entity.getSections() != null ? entity.getSections() : exit.getSections());
			exit.setMakeUpExam(entity.getMakeUpExam() != null ? entity.getMakeUpExam() : exit.getMakeUpExam());
		
			return classRepository.save(exit);
		}
  	}
	
  	public List<String> listUserClasses(String userId) {
  		if(studentRepository.findById(userId).isPresent()) {
  			return studentRepository.findById(userId).get().getClasses();
  		}
  		else if(instructorRepository.findById(userId).isPresent()) {
  			return instructorRepository.findById(userId).get().getClasses();
  		}
  		else {
  			return null;
  		}
  			
  	}
	
  	 public List<String> listUserSections(String userId, String classId) {
  	 	List<String> sections = classRepository.getById(classId).getSections();
  	 	for(String section: sections) {
  	 		if(instructorRepository.findById(sectionRepository.findBySectionNumber(section).getInstructor()).get().getUsername() != userId) {
  	 			sections.remove(section);
  	 		}
  	 	}
  	 	return sections;
  	 }
	
  	public Class addClass(Class newClass) {
  		return classRepository.save(newClass);
  	}
	
  	public Student joinClass(String joinClass, String userId) {
		System.out.println("Hellooooooooofnakjl");
		// find class
		Optional<Class> c = classRepository.findById(joinClass);
		
		if (c.isEmpty()) {
			System.out.println("fkldafjka");
  			return null;
  		}
  		else {
			// find student
			System.out.println("fkldafjka");
			Optional<Student> t = studentRepository.findById(userId);
			List<String> students = c.get().getStudents(); 
			if (t.isEmpty()) 
				return null;

			Student student = t.get();
			System.out.println("fkldafjka");
			List<String> temp = (List<String>) student.getClasses();
			if (temp.contains(joinClass))
				return student;

			temp.add(joinClass);
			students.add(userId);
			studentRepository.save(student);
			classRepository.save(c.get());
  			return student;
  		}
  	}
	
  	public ArrayList<Student> listParticipants(Long sectionId) {
  		return (ArrayList<Student>) sectionRepository.getById(sectionId).getStudents();
  	}
	
  	public List<Date> getMissedClasses() {
  		return null;
  	}
	
  	// public Instructor getSectionInstr(Long sectionId) {
  	// 	return sectionRepository.findById(sectionId).get().getInstructor();
  	// }
	
  	// public Boolean getUserAccess(String userId) {
  	// 	//return studentRepository.findById(userId).get().getCampusAccess();
  	// 	return true;
  	// }
	
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
	
	public List<Student> getClassParticipants(String classId) {
		Optional<Class> c = classRepository.findById(classId);
		if (c.isEmpty())
			return null;
		
		List<String> classList = c.get().getStudents();
		List<Student> students = new ArrayList<>();  
		for (String s : classList) {
			Student temp = studentRepository.findById(s).get();
			students.add(temp);
		}

		return students;
	}

	
}
