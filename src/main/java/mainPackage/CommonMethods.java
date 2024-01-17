package mainPackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CommonMethods 
{
	public static String convertDate(String dateRaw) {
	    dateRaw = dateRaw.replaceAll(" /", " ");

	    if (dateRaw.trim().isEmpty() || dateRaw.matches(".*[a-zA-Z]+.*") || dateRaw.trim().equals("0")) {
	        return " ";
	    }

	    String[] dateFormats = {
	        "dd-MM-yyyy hh:mm:ss",
	        "dd-MM-yy",
	        "MM/dd/yy",
	        "MM/dd//yy",
	        "MMMM dd,yyyy",
	        "MMMM dd. yyyy",
	        "MMMM dd ,yyyy"
	    };

	    for (String format : dateFormats) {
	        try {
	            SimpleDateFormat inputFormat = new SimpleDateFormat(format);
	            SimpleDateFormat outputFormat = new SimpleDateFormat("MM/dd/yyyy");
	            Date date = inputFormat.parse(dateRaw.trim().replaceAll(" +", " "));
	            System.out.println(outputFormat.format(date));
	            return outputFormat.format(date);
	        } catch (ParseException ignored) {
	            // Continue to the next format
	        }
	    }

	    // If none of the formats match, extract the date part
	    return dateRaw.split(" ")[0].replace("-", "/");
	}

	 public static String getCurrentDate()
	    {
	    	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");  
			 LocalDateTime now = LocalDateTime.now();  
			// System.out.println(dtf.format(now));
			return dtf.format(now);
	    }

}