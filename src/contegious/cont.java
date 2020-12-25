/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contegious;

import java.util.ArrayList;

/**
 *
 * @author Mostafa
 */
public class cont {
    int nb;
    String fn;
    int fs;
    String blocks[];
    int allocated[];
    int startindex;
    int endindex;

    ArrayList<Integer> startind = new ArrayList<Integer>();
    ArrayList<Integer> filesize = new ArrayList<Integer>();
    ArrayList<String> filename = new ArrayList<String>();
    
   public cont(int nb){
     this.nb = nb;
     blocks = new String[nb];
     allocated = new int[nb];
     for (int j = 0; j < nb; j++) {
            allocated[j] = 0;
        }            
     }
   
   
    public void insert(String fn, int fs){
    
        
        this.fn = fn;
        this.fs = fs;
        int count = 0;
        int emp = 0;
        
        
        for (int i = 0; i < nb; i++) {
            if(allocated[i] == 0){
            emp++;
            }
        }
        
        
        if(fs<=emp){
        for (int j = 0; j < nb; j++){
            if(fs>allocated.length){
            System.out.println("File size is bigger than the block");
        break;
            }
            if(count == fs){     
             startind.add(startindex);
             filesize.add(fs);
             filename.add(fn);
            break;           
            }
            
            if(allocated[j] == 0){
                allocated[j] = 1;
                blocks[j] = fn;
                count++;
                if(count == 1){
                startindex = j;               
                }
                
                if(j==(nb-1))
                        {
                            System.out.println("YOU REACHED THE END OF THE BLOCK");
                            break;
                        }
   
            }  
        }            
       
    }else{
            System.out.println("not enough free space to allocate");
        }
    }
    
    
    
    public void display(){
     for (int j = 0; j < nb; j++) {
            System.out.println("(" + j + ") " + allocated[j] + " " + blocks[j]);
        }
     
        
       System.out.println("FileName     StartInd.   EndInd.   File Size");
       for(int i=0; i<filename.size();i++)
       {
           System.out.println(filename.get(i)+"           "+ startind.get(i)+"             " + (startind.get(i)+filesize.get(i)-1)+"            " + filesize.get(i));
       }
    }
    
    
}
