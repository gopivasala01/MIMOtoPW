package mainPackage;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CommonMethods 
{
	public static String convertDate(String dateRaw) throws Exception
	{
		dateRaw = dateRaw.replaceAll(" \\/", " ");
		if(dateRaw.trim().equals("")||dateRaw.matches(".*[a-zA-Z]+.*")||dateRaw.trim().equals("0"))
			return " ";
		try
		{
			SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		    SimpleDateFormat format2 = new SimpleDateFormat("MM/dd/yyyy");
		    Date date = format1.parse(dateRaw.trim().replaceAll(" +", " "));
		    System.out.println(format2.format(date));
			return format2.format(date).toString();
		}
		catch(Exception m)
		{
		try
		{
		SimpleDateFormat format1 = new SimpleDateFormat("MM-dd-yy");
	    SimpleDateFormat format2 = new SimpleDateFormat("MM/dd/yyyy");
	    Date date = format1.parse(dateRaw.trim().replaceAll(" +", " "));
	    System.out.println(format2.format(date));
		return format2.format(date).toString();
		}
		catch(Exception e)
		{
			try
			{
			SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yy");
		    SimpleDateFormat format2 = new SimpleDateFormat("MM/dd/yyyy");
		    Date date = format1.parse(dateRaw.trim().replaceAll(" +", " "));
		    System.out.println(format2.format(date));
			return format2.format(date).toString();
			}
			catch(Exception e2)
			{
			  try
				{
				SimpleDateFormat format1 = new SimpleDateFormat("MM/dd//yy");
			    SimpleDateFormat format2 = new SimpleDateFormat("MM/dd/yyyy");
			    Date date = format1.parse(dateRaw.trim().replaceAll(" +", " "));
			    System.out.println(format2.format(date));
				return format2.format(date).toString();
				}
				catch(Exception e3)
				{
					try
					{
					SimpleDateFormat format1 = new SimpleDateFormat("MMMM dd,yyyy");
				    SimpleDateFormat format2 = new SimpleDateFormat("MM/dd/yyyy");
				    Date date = format1.parse(dateRaw.trim().replaceAll(" +", " "));
				    System.out.println(format2.format(date));
					return format2.format(date).toString();
					}
					catch(Exception e4)
					{
						try
						{
						SimpleDateFormat format1 = new SimpleDateFormat("MMMM dd. yyyy");
					    SimpleDateFormat format2 = new SimpleDateFormat("MM/dd/yyyy");
					    Date date = format1.parse(dateRaw.trim().replaceAll(" +", " "));
					    System.out.println(format2.format(date));
						return format2.format(date).toString();
						}
						catch(Exception e5)
						{
							try
							{
							SimpleDateFormat format1 = new SimpleDateFormat("MMMM dd ,yyyy");
						    SimpleDateFormat format2 = new SimpleDateFormat("MM/dd/yyyy");
						    Date date = format1.parse(dateRaw.trim().replaceAll(" +", " "));
						    System.out.println(format2.format(date));
							return format2.format(date).toString();
							}
							catch(Exception e6)
							{
							return dateRaw.split(" ")[0].replace("-", "/");
							}
						}
						
					}
				}
			  }
			}
		}
	}
	 public static String getCurrentDate()
	    {
	    	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");  
			 LocalDateTime now = LocalDateTime.now();  
			// System.out.println(dtf.format(now));
			return dtf.format(now);
	    }

}
