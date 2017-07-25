/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaji;

/**
 *
 * @author abhu
 */
public class GAJI {

    /**
     * @param args the command line arguments
     */
    
    
    
}



      class Staff {
        StaffMember[] staffList;

        public Staff() {
            staffList = new StaffMember[6];
            
            staffList[0] = new Executive("Sam","123 Main Line","555-0469","123-45-6789",1923.07);
            staffList[1] = new Employee("Carla","456 Off Line","555-0101","987-65-4321",846.15);
            staffList[2] = new Employee("Woody","789 Off Rocker","555-0000","010-20-3040",769.23);
            staffList[3] = new Hourly("Diane","678 Fifth Ave.","555-0690","958-47-3625",8.55);
            staffList[4] = new Volunteer("Norm","987 Suds Blvd","555-8374");
            staffList[5] = new Volunteer("Cliffi","321 Duds Lane","555-7282");
            
            
            ((Executive)staffList[0]).awardBonus(5000.00);
            ((Hourly)staffList[3]).addHours(40);
            
        }

        public void payday() {
            double amount;
            
            for(int count=0; count<staffList.length; count++){
                System.out.println(staffList[count]);
                
                amount = staffList[count].pay();
                
                if(amount == 0.0)
                    System.out.println("Thanks!");
                else
                    System.out.println("Paid : " +amount);
                System.out.println("-------------------------------------");
            }
           //To change body of generated methods, choose Tools | Templates.
        }
    }

    abstract class StaffMember {
        protected String name;
        protected String address;
        protected String phone;
        protected String socialSecurityNumber;
        protected double payRate;
        
      
        public StaffMember(String name, String address, String phone) {
            this.name = name;
            this.address = address;
            this.phone = phone;
               
        }
       
           
        
        public String toString(){
           String result="Name      : "+ name + "\n";
           result +="Address : "+address + "\n";
           result +="Phone   : "+phone + "\n";
          
           
           return result;
           
           
        }
        public abstract double pay();
    }
    
    class Volunteer extends StaffMember{
        
        public Volunteer(String name, String address, String phone){
            super(name, address, phone);
            
        }

        @Override
        public double pay() {
            return 0.0; //To change body of generated methods, choose Tools | Templates.
        }
        
        
    }
    class Employee extends StaffMember{
        
        protected String socialSecurityNumber;
        protected double payRate;
        
        public Employee(String name, String address, String phone, String socialSecurityNumber, double payRate){
            super(name, address, phone);
            
            this.socialSecurityNumber = socialSecurityNumber;
            this.payRate = payRate;
        }

        
        public String toString(){
            String result = super.toString();
                result += "\nSocial Security Number : "+socialSecurityNumber;
                result += "\nPay Rate               : "+payRate;
                
                return result;
        }
        @Override
        public double pay() {
            return payRate; //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    class Executive extends Employee{
        private double bonus;
        
        public Executive(String name, String address, String phone, String socialSecurityNumber, double payRate) {
            super(name, address, phone, socialSecurityNumber, payRate);
            bonus = 0;
        }
        public void awardBonus(double execBonus){
            bonus = execBonus;
        }
        
        public double pay(){
            double payment = super.pay() + bonus;
            
            bonus = 0;
            
            return payment;
        }
        
    }
    class Hourly extends Employee{
        private int hoursWorked;
        
        public Hourly(String name, String address, String phone, String socialSecurityNumber, double payRate) {
            super(name, address, phone, socialSecurityNumber, payRate);
            
            hoursWorked = 0;
        }
        
        public void addHours(int moreHours){
            hoursWorked += moreHours;
        }
        
        public double pay(){
            double payment = payRate * hoursWorked;
            hoursWorked =0;
            return payment;
        }
        public String toString(){
            String result = super.toString();
            result += "\nCurrent hours : " + hoursWorked;
            
            return result;
        }
        
    }

    



