package calenderexample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo {

	public static void main(String[] args) throws ParseException {

		String datetoSelect = "12-10-2021";
	    SimpleDateFormat formatter =new SimpleDateFormat("MM-d-yyyy");  
	    Date d = formatter.parse(datetoSelect);
	    System.out.println(d);
	    SimpleDateFormat formatter2 = new SimpleDateFormat("MMMM-d-yyyy");
	    String date = formatter2.format(d);
	    System.out.println(date);
		

	}

}
