package org.jamieandtheboys.io;

import java.io.*;
import java.util.*;
import org.jamieandtheboys.persons.Person;

public class Logger {

	public ArrayList<String> log;
	
	public Logger() {
		log = new ArrayList<String>();
	}

	public void entry(String s) {
		log.add(s);
	}

	public void createLogFile(Person p) {
		Calendar cal = new GregorianCalendar();
		// Get the components of the time
		int hour24 = cal.get(Calendar.HOUR_OF_DAY); // 0..23
		int min = cal.get(Calendar.MINUTE); // 0..59
		String hour = Integer.toString(hour24);
		String minute = Integer.toString(min);
		String time = hour + minute;
		String path = p.getName() + time + ".txt";
		try {
			BufferedWriter out = null;
			File file = new File(path);
			out = new BufferedWriter(new FileWriter(file));
			for (String s : log) {
				out.write(s);
				out.newLine();
			}
			out.close();

		} catch (IOException x) {
			System.out.println("IO error for " + path + ": " + x.getMessage());
		}
	}
}
