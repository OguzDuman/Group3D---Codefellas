package com.example.pandemikent.Model;

        import java.util.ArrayList;
        import java.util.List;

        import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
        import javax.persistence.ElementCollection;
        import javax.persistence.Entity;
        import javax.persistence.Table;

@Entity
@Table(name="student")
@DiscriminatorValue("Student")
public class Student extends UserProfile {

    public Student(String username, int id, String email, Boolean accessStatus) {
        super(username, id, email);
    }

    @ElementCollection
    @CollectionTable(name ="classList")
    private List<String> classes = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name ="history")
    private List<String> history = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name ="closeContacts")
    private List<String> closeContacts = new ArrayList<>();
    
    @Column(name = "access_status")
    private Boolean accessStatus;

    public List<String> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<String> classes) {
        this.classes = classes;
    }

    public List<String> getHistory() {
        return history;
    }

    public void setHistory(List<String> history) {
        this.history = history;
    }

    public void setCloseContacts(List<String> closeContacts) {
        this.closeContacts = closeContacts;
    }

    public List<String> getCloseContacts(){
        return closeContacts;
    }

    public void addHistory(String historyText) {
        history.add(historyText);
    }

    public Student() {
    }

	public void setClasses(List<String> classes) {
		this.classes = classes;
	}
	
	public String toString() {
		return"name = " +getUsername() + "id= " + getId();
	}

	public Boolean getAccessStatus() {
		return accessStatus;
	}

	public void setAccessStatus(Boolean accessStatus) {
		this.accessStatus = accessStatus;
	}
}
