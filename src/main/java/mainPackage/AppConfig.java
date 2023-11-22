package mainPackage;

public class AppConfig 
{
	 public static boolean saveButtonOnAndOff= false;
		
	   public static String URL ="https://app.propertyware.com/pw/login.jsp";
	   public static String username ="mds0418@gmail.com";
	   public static String password ="KRm#V39fecMDGg#";
	   
	   public static String excelFileLocation = "E:\\Automation\\Gopi\\MIMO to PW";
	   public static String downloadFilePath = "C:\\SantoshMurthyP\\Initial Rents Update";
	   //Mail credentials
	   public static String fromEmail = "bireports@beetlerim.com";
	   public static String fromEmailPassword = "Welcome@123";
	   
	   public static String toEmail = "gopi.v@beetlerim.com";
	   public static String CCEmail = "santosh.p@beetlerim.com";
	   
	   public static String mailSubject = "MIMO to PW Report  ";
	   
	   public static String[] LeaseAgreementFileNames = {"REVISED_Lease_","Lease_","Leases_"};
	   
	   public static String connectionUrl = "jdbc:sqlserver://azrsrv001.database.windows.net;databaseName=HomeRiverDB;user=service_sql02;password=xzqcoK7T;encrypt=true;trustServerCertificate=true;";
	   
	  // public static String leaseFetchQuery  = "Select Company, Building,leaseName from Automation.InitialRentsUpdate where Status ='Pending' and Company ='Georgia'";
	   
	   public static String pendingLeasesQuery = "EXEC Automation_MIMOtoPWListPull 3"
				    ;
			   


			public static String failedLeasesQuery = "SELECT \n"
					+ "    ID,\n"
					+ "    Unit_Entity_ID,\n"
					+ "    Vacating_Resident_Lease_Entity_ID,\n"
					+ "    Status,\n"
					+ "    Address,\n"
					+ "    Current_Resident_First_Name,\n"
					+ "    Current_Resident_Last_Name,\n"
					+ "    Company_Name,\n"
					+ "    Last_Chance_Save_Renewal_Call_RC,\n"
					+ "    Utility_Connection_Request_RC,\n"
					+ "    Set_Construction_Lockbox_Code_To_TC,\n"
					+ "    Filter_Size_FI,\n"
					+ "    Possession_Confirmed_Date,\n"
					+ "    Turn_Over_Handled_By_TC,\n"
					+ "    Turn_Estimate_Submission_Date,\n"
					+ "    Turn_Estimated_Cost_TC,\n"
					+ "    Turn_Approval_Date_TC,\n"
					+ "    Turn_Start_Date_TC,\n"
					+ "    Turn_Estimated_Completion_Date_TC,\n"
					+ "    Turn_Actual_Completion_Date_TC,\n"
					+ "    Turn_Actual_Cost_TC,\n"
					+ "    Turn_QC_Scheduled_Date_TC,\n"
					+ "    Turn_QC_Completed_Date_FI,\n"
					+ "    Leasing_Lockbox_Serial_Number_FI,\n"
					+ "    Last_vacant_visit,\n"
					+ "    AutomationStatus\n"
					+ "FROM Automation.MIMOToPw_Prod\n"
					+ "WHERE AutomationStatus = 'Pending'\n"
					+ "    AND Note = 'Building not found';\n"
					+ "";


			public static String getLeasesWithStatusforCurrentDay = "SELECT \n"
					+ "    ID,\n"
					+ "    Unit_Entity_ID,\n"
					+ "    Vacating_Resident_Lease_Entity_ID,\n"
					+ "    Status,\n"
					+ "    Address,\n"
					+ "    Current_Resident_First_Name,\n"
					+ "    Current_Resident_Last_Name,\n"
					+ "    Company_Name,\n"
					+ "    Last_Chance_Save_Renewal_Call_RC,\n"
					+ "    Utility_Connection_Request_RC,\n"
					+ "    Set_Construction_Lockbox_Code_To_TC,\n"
					+ "    Filter_Size_FI,\n"
					+ "    Possession_Confirmed_Date,\n"
					+ "    Turn_Over_Handled_By_TC,\n"
					+ "    Turn_Estimate_Submission_Date,\n"
					+ "    Turn_Estimated_Cost_TC,\n"
					+ "    Turn_Approval_Date_TC,\n"
					+ "    Turn_Start_Date_TC,\n"
					+ "    Turn_Estimated_Completion_Date_TC,\n"
					+ "    Turn_Actual_Completion_Date_TC,\n"
					+ "    Turn_Actual_Cost_TC,\n"
					+ "    Turn_QC_Scheduled_Date_TC,\n"
					+ "    Turn_QC_Completed_Date_FI,\n"
					+ "    Leasing_Lockbox_Serial_Number_FI,\n"
					+ "    Last_vacant_visit,\n"
					+ "    AutomationStatus\n"
					+ "FROM Automation.MIMOToPw_Prod;\n"
					+ "";


	   
	   public static String buildingPageURL = "https://app.propertyware.com/pw/properties/building_detail.do?entityID=";
	   
	   
	   public static String[] companyNames = {"Alabama","Arizona","Arkansas","Austin","Boise","California","California pfw","Chattanooga","Chicago","Chicago pfw","Colorado Springs","Dallas/Fort Worth","Delaware","Florida","Hawaii","Georgia","Houston","Idaho Falls","Indiana","Institutional Accounts","Kansas City","Lake Havasu","Little Rock","Maine","Maryland","Montana","New Jersey","New Mexico","North Carolina","OKC","Ohio","Pennsylvania","Saint Louis","San Antonio","Savannah","South Carolina","Spokane","Tennessee","Tulsa","Utah","Virginia","Washington DC"};
	   


}
