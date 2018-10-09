/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

/**
 *
 * @author yovo
 */

/*chete se faila bait po bait prashtame kym syrvarabait po bait i go 
zapiswame w masiw */

public class Application {
   private String name;
   private String typeOfApplication;
   private Double AvSuccessOfStudent; 
   private Double AvIncomPerPerson;
   private String faculty;
   private Boolean haveSuccessScholarship;
   private Integer numberOfSpecialScholarships;
   private Boolean isApplicationTaken;
 

    public Application(String name,String typeOfApplication,
            Double AvSuccessOfStudent,Double AvIncomPerPerson, String faculty,
            Boolean haveSuccessScholarship,
            Integer numberOfSpecialScholarships,Boolean isApplicationTaken){
        this.name = name;
        this.AvSuccessOfStudent = AvSuccessOfStudent;
        this.AvIncomPerPerson = AvIncomPerPerson;
        this.faculty = faculty;
        this.isApplicationTaken = isApplicationTaken;
        this.haveSuccessScholarship = haveSuccessScholarship;
        this.typeOfApplication = typeOfApplication;
        this.numberOfSpecialScholarships = numberOfSpecialScholarships;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
     public String getTypeOfApplication() {
        return typeOfApplication;
    }

    public void setTypeOfApplication(String typeOfApplication) {
        this.typeOfApplication = typeOfApplication;
    }


    public Double getAvSuccessOfStudent() {
        return AvSuccessOfStudent;
    }

    public void setAvSuccessOfStudent(Double AvSuccessOfStudent) {
        this.AvSuccessOfStudent = AvSuccessOfStudent;
    }

    public Double getAvIncomPerPerson() {
        return AvIncomPerPerson;
    }

    public void setAvIncomPerPerson(Double AvIncomPerPerson) {
        this.AvIncomPerPerson = AvIncomPerPerson;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
    public Integer getNumberOfSpecialScholarships() {
        return numberOfSpecialScholarships;
    }

    public void setNumberOfSpecialScholarships(Integer numberOfSpecialScholarships) {
        this.numberOfSpecialScholarships = numberOfSpecialScholarships;
    }
   
    public Boolean getIsApplicationTaken() {
        return isApplicationTaken;
    }

    public void setIsApplicationTaken(Boolean isAppointmentTaken) {
        this.isApplicationTaken = isApplicationTaken;
    }
   
    public Boolean getHaveSuccessScholarship() {
        return haveSuccessScholarship;
    }

    public void setHaveSuccessScholarship(Boolean haveSuccessScholarship) {
        this.haveSuccessScholarship = haveSuccessScholarship;
    }
}
