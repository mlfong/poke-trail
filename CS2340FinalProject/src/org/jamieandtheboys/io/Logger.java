package org.jamieandtheboys.io;
import java.io.*;
import java.util.*;
import org.jamieandtheboys.persons.Person;
public class Logger {
	
	public String log[];
	public static int logIndex;
	
	public Logger() {
		log= new String[200];
		logIndex= 0;
	}
	
	public void entry(String s) {
		log[logIndex]= s;
		logIndex++;
	}
	public void createLogFile(Person p)
	{
	try {
		Calendar cal = new GregorianCalendar();
		// Get the components of the time
		int hour24 = cal.get(Calendar.HOUR_OF_DAY);     // 0..23
		int min = cal.get(Calendar.MINUTE);             // 0..59
		String hour= Integer.toString(hour24);
		String minute= Integer.toString(min);
		String time= hour+":"+minute;
		
		  FileOutputStream buf = new FileOutputStream(new File (p.getName()+time+".txt"), true);
		  ObjectOutputStream oos = new ObjectOutputStream(buf);
		   
		  oos.writeObject(log); // Write the String array to a file
		  oos.close();
		 
		  // Read it in??
		  FileInputStream fis = new FileInputStream(new File ("StringArray_demo.txt"));
		  ObjectInputStream ois = new ObjectInputStream(fis);
		  String[] sAI = (String[])ois.readObject();
		  System.out.println("sAI=" + Arrays.toString(sAI)); //sAI=[string 1, second string, third Str]
		 
		} catch(Exception x) {
		  x.printStackTrace();
		  return;
		}
	}
}
