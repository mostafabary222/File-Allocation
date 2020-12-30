/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contegious;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Contegious {

    /**
     * @param args the command line arguments
     */
   
    
    public int nob;
    public String fn;
    public int fs;
  

public static void menu1(){
Scanner i = new Scanner(System.in);
        Scanner x = new Scanner(System.in);
        int choice;
        System.out.println("*************************************");
        System.out.println("Enter number of blocks");
        int nb = i.nextInt();
        
        cont y = new cont(nb);
        Linked e = new Linked(nb);
        Indexed f = new Indexed(nb);
        
        
            System.out.println("*************************************");
            System.out.println("Do you want to use:");
            System.out.println("1.Contiguous allocation");
            System.out.println("2.Linked allocation");
            System.out.println("3.Indexed allocation");
            System.out.println("*************************************");  
        
            int way = i.nextInt();
            
       
        do{
        
        
        System.out.println("Enter file name");
        String fn = x.nextLine();
        System.out.println("Enter file size");
        int fs = i.nextInt();
      
       
        if(way == 1){ y.insert(fn, fs);}
        else if(way == 2){ e.insert(fn, fs);}
        else if(way == 3){f.insert(fn, fs);}
        
            System.out.println("*************************************");
            System.out.println("Do you want to :");
            System.out.println("1.Enter another file");
            System.out.println("2.Exit out of the program");
            System.out.println("3.Display the blocks");
            System.out.println("4.rerun the program");
            System.out.println("*************************************");
            choice = i.nextInt();
            if(choice == 2){break;}
            else if(choice == 3 && way == 1){y.display(); menu2();}
            else if(choice == 3 && way == 2){e.display(); menu2();}
            else if(choice == 3 && way == 3){f.display(); menu2();}
            else if(choice == 4){menu1();}
        }while(choice == 1);
                
}
    

public static void menu2(){
System.out.println("*************************************");
            System.out.println("Do you want to :");         
            System.out.println("1.Exit out of the program");
            System.out.println("2.rerun the program");
            System.out.println("*************************************");
            Scanner x = new Scanner(System.in);
            int c = x.nextInt();
            if (c == 1) {System.exit(0);}
            else if (c == 2) {menu1();}

    
           
}
    public static void main(String[] args) {
        
        menu1();
    }

    
}
