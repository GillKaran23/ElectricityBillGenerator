/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricitybillgenerator;

/**
 *
 * @author Karandeep Singh
 */
public class Users {
    
    String user_name;
    String father_name;
    String user_email;
    String user_address;
    String user_unit;
    String user_bill;
    
    public Users(String user_name, String father_name, String user_email, String user_address, String user_unit, String user_bill){

        this.user_name = user_name;
        this.father_name = father_name;
        this.user_email = user_email;
        this.user_address = user_address;
        this.user_unit = user_unit;
        this.user_bill = user_bill;
    }
}
