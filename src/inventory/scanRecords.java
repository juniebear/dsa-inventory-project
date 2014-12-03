import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * Scans the csv file
 * 
 */
public class scanRecords
{
   ArrayList<ItemRecord> recordArray; 
    
   public scanRecords(){
       
    Scanner scan = null;
    recordArray = new ArrayList<ItemRecord>(); 
    BufferedReader br = null;
    String InputLine = "";
    String salesfileLoc;
    String splitBy = ",";
    int row = 0;
    int x = 0;
    int rowsInFile = 0;
    
    salesfileLoc = "file name goes here";
    
   try
   {
       //setup a scanner
       br = new BufferedReader(new FileReader(salesfileLoc));
       scan = new Scanner(br);
       
           
       //while the CSV file has lines,
       while (scan.hasNextLine())
       //for(int i = 0; i < rowsInFile; i++)
       {
           //Read line in from file
           InputLine = scan.nextLine();
           
           //split the Inputline into an array at the commas
           String[] InArray = InputLine.split(splitBy);
           
          //Create a new itemRecord    
           ItemRecord itemRecord = new ItemRecord();
           itemRecord.setSKU(InArray[0]); 
           itemRecord.setName(InArray[1]);
           itemRecord.setDescription(InArray[2]);
           itemRecord.setInStock(InArray[3]);
           
           //etc....copy the contents into each ItemRecord object.
          
          
           //Then add to List Array
           recordArray.add(itemRecord);
           
          x++;
        }
        
       
        System.out.println(recordArray);
       
    }
    catch (Exception e)
    {
        System.out.println(e);
    }
  }
  
  public ArrayList<ItemRecord> getRecords(){
     return recordArray; 
    }
  
 
  
}
