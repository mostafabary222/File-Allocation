/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contegious;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Mostafa
 */
public class Indexed {
    int nb;
    String fn;
    int fs;
    String blocks[];
    int allocated[];
    int id;
    int counter=0;
    int startindex;
    int endindex;
    int f=0;

    ArrayList<Integer> filesize = new ArrayList<Integer>();
    ArrayList<String> filename = new ArrayList<String>();
    ArrayList<Integer> ids = new ArrayList<Integer>();
    ArrayList<ArrayList<Integer> > aList =  
                  new ArrayList<ArrayList <Integer> >();

    
   public Indexed(int nb){
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
     
        Random rd = new Random();
        id = rd.nextInt()%nb;
        
     Boolean all=true;
     
        
                    
        
        while(all){id = rd.nextInt()&nb;
            while(id<0 || id>= nb){        
            id = rd.nextInt()&nb; 
        }
        if(allocated[id] == 0){
            allocated[id] = 1;  //makes the index of the indexarray to be 1
            blocks[id]="id +"+fn;             
            ids.add(id);  //puts indexblock no in an array list
            System.out.println("id is  "+ id);
            break;
        }
        
      
    }

        
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
            
            int no = rd.nextInt()%nb;
            
            
            
            while(no<0)
            {no = rd.nextInt()%nb;}
                                  
            
            if(allocated[no] == 0){
                allocated[no] = 1;
                blocks[no] = fn;
                count++;
               aList.add(new ArrayList<Integer>());
               aList.get(counter).add(no);
                
            }
            
            if(count == fs){     
             filesize.add(fs);
             filename.add(fn);
            break;           
            }
            
        }  
        counter++;
       
    }else{
            System.out.println("not enough free space to allocate");
        }
    }
    
    
    
    public void display(){
     for (int j = 0; j < nb; j++) {
            System.out.println("(" + j + ") " + allocated[j] + " " + blocks[j]);
        }
     
        
       System.out.println("FileName     IndexBlock    File Size   indexes in order");
       for(int i=0; i<filename.size();i++)
       {
           System.out.print(filename.get(i)+"           "+ ids.get(i)+"             " + filesize.get(i)+ "             ");
           for(int j=0; j<aList.get(i).size();j++)
           {
               System.out.print(aList.get(i).get(j) + " " );
           }
           
           System.out.println("");
           }
           
       }
    }

