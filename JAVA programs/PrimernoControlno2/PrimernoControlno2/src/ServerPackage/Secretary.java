 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerPackage;

import Student.Application;

/**
 *
 * @author yovo
 */
public class Secretary extends Thread{
    
    Application application;
    public Secretary(Application a){
     application = a;
    }
    
    /*Всеки студент има право да получи максимум 5 специални стипендии,
    при условие, че взима стипендия за успех и 4 специални стипендии,
    при условие, че не взима стипендия за успех.*/
    
    public boolean checkApplicationForSuccess(Application a){
       /*Стипендия за успех получават всички студенти,
        имащи успех над 5 и 50, и съответен
        доход на член от семейството – под 500лв.*/
       boolean approval = false;
       if(a.getAvSuccessOfStudent() > 5.50 && a.getAvIncomPerPerson() < 500 ){
           approval = true;
           a.setHaveSuccessScholarship(true);
       }
       a.setIsApplicationTaken(true);
       return approval; 
    }
    public boolean checkSpecialApplication(Application a){
        /*Специална стипендия получават всички студенти,
        имащи успех над 5,30 и съответно доход на член
        от семейството – под 300 лв.*/
        boolean approval = false;
        
        if(a.getAvSuccessOfStudent() > 5.30 && a.getAvIncomPerPerson() < 300 ){
           if(a.getNumberOfSpecialScholarships() < 4) {
               approval = true;
               a.setNumberOfSpecialScholarships
                                         (a.getNumberOfSpecialScholarships()+1);
           }
           else if(a.getNumberOfSpecialScholarships() == 4){
               if(a.getHaveSuccessScholarship()) approval = true; 
                a.setNumberOfSpecialScholarships
                                         (a.getNumberOfSpecialScholarships()+1);
           }
        }
        a.setIsApplicationTaken(true);
        return approval;
    }
    @Override
    public void run(){
        String typeOfApplication = application.getTypeOfApplication();
        boolean isItApproved;
        if(typeOfApplication.equals("success")){
            isItApproved = this.checkApplicationForSuccess(application);
        } 
        else if(typeOfApplication.equals("special")){
            isItApproved = this.checkSpecialApplication(application);
        } 
    }
}
