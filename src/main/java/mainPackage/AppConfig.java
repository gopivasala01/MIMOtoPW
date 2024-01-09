package mainPackage;

public class AppConfig 
{
	 public static boolean saveButtonOnAndOff= true;
		
	   public static String URL ="https://app.propertyware.com/pw/login.jsp";
	   public static String username ="mds0418@gmail.com";
	   public static String password ="KRm#V39fecMDGg#";
	   public static String homeURL = "https://app.propertyware.com/pw/home/home.do";
	   public static String excelFileLocation = "C:\\SantoshMurthyP\\MIMOTOPW";
	   public static String downloadFilePath = "C:\\SantoshMurthyP\\Initial Rents Update";
	   //Mail credentials
	   public static String fromEmail = "bireports@beetlerim.com";
	   public static String fromEmailPassword = "Welcome@123";
	   
	   public static String toEmail = "cdupre@homeriver.com, jsmith@homeriver.com";
	   public static String CCEmail = "santosh.p@beetlerim.com, gopi.v@beetlerim.com";
	   
	   public static String mailSubject = "MIMO to PW Report  ";
	   
	   public static String[] LeaseAgreementFileNames = {"REVISED_Lease_","Lease_","Leases_"};
	   
	   public static String connectionUrl = "jdbc:sqlserver://azrsrv001.database.windows.net;databaseName=HomeRiverDB;user=service_sql02;password=xzqcoK7T;encrypt=true;trustServerCertificate=true;";
	   
	  // public static String leaseFetchQuery  = "Select Company, Building,leaseName from Automation.InitialRentsUpdate where Status ='Pending' and Company ='Georgia'";

	   //  "EXEC Automation_MIMOtoPWListPull 1";
	   public static String pendingLeasesQuery = "EXEC Automation_MIMOtoPWListPull 2";
			   
			   /*"SELECT ID, Unit_Entity_ID, Vacating_Resident_Lease_Entity_ID, Status, Address, " +
               "Current_Resident_First_Name, Current_Resident_Last_Name, Company_Name, " +
               "Last_Chance_Save_Renewal_Call_RC, Utility_Connection_Request_RC, " +
               "Set_Construction_Lockbox_Code_To_TC, Filter_Size_FI, Possession_Confirmed_Date, " +
               "Turn_Over_Handled_By_TC, Turn_Estimate_Submission_Date, Turn_Estimated_Cost_TC, " +
               "Turn_Approval_Date_TC, Turn_Start_Date_TC, Turn_Estimated_Completion_Date_TC, " +
               "Turn_Actual_Completion_Date_TC, Turn_Actual_Cost_TC, Turn_QC_Scheduled_Date_TC, " +
               "Turn_QC_Completed_Date_FI, Leasing_Lockbox_Serial_Number_FI, Last_vacant_visit, " +
               "AutomationStatus, AsOfDate, Note " +
               "FROM Automation.MIMOToPw_Prod " +
               "WHERE Unit_Entity_ID in ('1661405237','3468558368') AND AsOfDate = '2023-12-19 13:00:50' ORDER BY AsOfDate DESC";*/
			   
			 /* "SELECT top 1 ID,\r\n"
			  + "    Unit_Entity_ID,\r\n"
			  + "    Vacating_Resident_Lease_Entity_ID,\r\n"
			  + "    Status,\r\n"
			  + "    Address,\r\n"
			  + "    Current_Resident_First_Name,\r\n"
			  + "    Current_Resident_Last_Name,\r\n"
			  + "    Company_Name,\r\n"
			  + "    Last_Chance_Save_Renewal_Call_RC,\r\n"
			  + "    Utility_Connection_Request_RC,\r\n"
			  + "    Set_Construction_Lockbox_Code_To_TC,\r\n"
			  + "    Filter_Size_FI,\r\n"
			  + "    Possession_Confirmed_Date,\r\n"
			  + "    Turn_Over_Handled_By_TC,\r\n"
			  + "    Turn_Estimate_Submission_Date,\r\n"
			  + "    Turn_Estimated_Cost_TC,\r\n"
			  + "    Turn_Approval_Date_TC,\r\n"
			  + "    Turn_Start_Date_TC,\r\n"
			  + "    Turn_Estimated_Completion_Date_TC,\r\n"
			  + "    Turn_Actual_Completion_Date_TC,\r\n"
			  + "    Turn_Actual_Cost_TC,\r\n"
			  + "    Turn_QC_Scheduled_Date_TC,\r\n"
			  + "    Turn_QC_Completed_Date_FI,\r\n"
			  + "    Leasing_Lockbox_Serial_Number_FI,\r\n"
			  + "    Last_vacant_visit,\r\n"
			  + "    AutomationStatus,\r\n"
			  + "	AsOfDate,\r\n"
			  + "	Note,BuildingAbbreviation,RowRank = ROW_NUMBER() OVER(order by ID ) --INTO #Temp \r\n"
			  + "	FROM Automation.MIMOToPw_Prod\r\n"
			  + "	WHERE Company_Name IS NOT NULL\r\n"
			  + "    AND Company_Name <> ''\r\n"
			  + "    AND (AutomationStatus = 'Pending' or ( AutomationStatus = 'Failed' And Note = 'Building Not Found'))\r\n"
			  + "    AND Company_Name <> 'HomeRiver Group'\r\n"
			  + "    AND Vacating_Resident_Lease_Entity_ID IS NOT NULL\r\n"
			  + "    AND Last_vacant_visit IS NOT NULL \r\n"
			  + "	AND Asofdate = '2024-01-08 13:01:31' \r\n"
			  + "	--AND Asofdate = (Select MAX(ASofdate) from Automation.MIMOToPw_Prod)" ;       */    
				    

	   


			   


			public static String failedLeasesQuery =   "	SELECT  ID,\r\n"
					+ "    Unit_Entity_ID,\r\n"
					+ "    Vacating_Resident_Lease_Entity_ID,\r\n"
					+ "    Status,\r\n"
					+ "    Address,\r\n"
					+ "    Current_Resident_First_Name,\r\n"
					+ "    Current_Resident_Last_Name,\r\n"
					+ "    Company_Name,\r\n"
					+ "    Last_Chance_Save_Renewal_Call_RC,\r\n"
					+ "    Utility_Connection_Request_RC,\r\n"
					+ "    Set_Construction_Lockbox_Code_To_TC,\r\n"
					+ "    Filter_Size_FI,\r\n"
					+ "    Possession_Confirmed_Date,\r\n"
					+ "    Turn_Over_Handled_By_TC,\r\n"
					+ "    Turn_Estimate_Submission_Date,\r\n"
					+ "    Turn_Estimated_Cost_TC,\r\n"
					+ "    Turn_Approval_Date_TC,\r\n"
					+ "    Turn_Start_Date_TC,\r\n"
					+ "    Turn_Estimated_Completion_Date_TC,\r\n"
					+ "    Turn_Actual_Completion_Date_TC,\r\n"
					+ "    Turn_Actual_Cost_TC,\r\n"
					+ "    Turn_QC_Scheduled_Date_TC,\r\n"
					+ "    Turn_QC_Completed_Date_FI,\r\n"
					+ "    Leasing_Lockbox_Serial_Number_FI,\r\n"
					+ "    Last_vacant_visit,\r\n"
					+ "    AutomationStatus,\r\n"
					+ "	AsOfDate,\r\n"
					+ "	Note\r\n"
					+ "FROM Automation.MIMOToPw_Prod\r\n"
					+ "WHERE Company_Name IS NOT NULL\r\n"
					+ "    AND Company_Name <> ''\r\n"
					+ "    AND (AutomationStatus = 'Pending' or ( AutomationStatus = 'Failed' And Note = 'Building Not Found'))\r\n"
					+ "    AND Company_Name <> 'HomeRiver Group'\r\n"
					+ "    AND Vacating_Resident_Lease_Entity_ID IS NOT NULL\r\n"
					+ "    AND Last_vacant_visit IS NOT NULL \r\n"
					+ "	--AND Asofdate = '2023-12-05 13:00:54' \r\n"
					+ "	AND Asofdate = (Select MAX(ASofdate) from Automation.MIMOToPw_Prod)"  ;

			public static String getLeasesWithStatusforCurrentDay = "SELECT ID,\r\n"
					+ "    Unit_Entity_ID,\r\n"
					+ "    Vacating_Resident_Lease_Entity_ID,\r\n"
					+ "    Status,\r\n"
					+ "    Address,\r\n"
					+ "    Current_Resident_First_Name,\r\n"
					+ "    Current_Resident_Last_Name,\r\n"
					+ "    Company_Name,\r\n"
					+ "    Last_Chance_Save_Renewal_Call_RC,\r\n"
					+ "    Utility_Connection_Request_RC,\r\n"
					+ "    Set_Construction_Lockbox_Code_To_TC,\r\n"
					+ "    Filter_Size_FI,\r\n"
					+ "    Possession_Confirmed_Date,\r\n"
					+ "    Turn_Over_Handled_By_TC,\r\n"
					+ "    Turn_Estimate_Submission_Date,\r\n"
					+ "    Turn_Estimated_Cost_TC,\r\n"
					+ "    Turn_Approval_Date_TC,\r\n"
					+ "    Turn_Start_Date_TC,\r\n"
					+ "    Turn_Estimated_Completion_Date_TC,\r\n"
					+ "    Turn_Actual_Completion_Date_TC,\r\n"
					+ "    Turn_Actual_Cost_TC,\r\n"
					+ "    Turn_QC_Scheduled_Date_TC,\r\n"
					+ "    Turn_QC_Completed_Date_FI,\r\n"
					+ "    Leasing_Lockbox_Serial_Number_FI,\r\n"
					+ "    Last_vacant_visit,\r\n"
					+ "    AutomationStatus,\r\n"
					+ "	AsOfDate,\r\n"
					+ "	 Note\r\n"
					+ "FROM Automation.MIMOToPw_Prod\r\n"
					+ "WHERE Company_Name IS NOT NULL\r\n"
					+ "    AND Company_Name <> ''\r\n"
					+ "   -- AND (AutomationStatus = 'Pending' or (AutomationStatus = 'Failed' AND Note = 'Building Not Found'))\r\n"
					+ "    AND Company_Name <> 'HomeRiver Group'\r\n"
					+ "    AND Vacating_Resident_Lease_Entity_ID IS NOT NULL\r\n"
					+ "    AND Last_vacant_visit IS NOT NULL\r\n"
					+ "    AND Asofdate = (SELECT MAX(Asofdate) FROM Automation.MIMOToPw_Prod);\r\n"
					+ "		--AND Asofdate = '2023-12-05 13:00:54' \r\n"
					+ "";

			
			public static String checkAutomationPendingLeases = //"EXEC Automation_MIMOtoPWListPull 1";
					   
					  "SELECT *"
					  + "	FROM Automation.MIMOToPw_Prod\r\n"
					  + "	WHERE Company_Name IS NOT NULL\r\n"
					  + "    AND Company_Name <> ''\r\n"
					  + "    AND AutomationStatus = 'Pending'\r\n"
					  + "    AND Company_Name <> 'HomeRiver Group'\r\n"
					  + "    AND Vacating_Resident_Lease_Entity_ID IS NOT NULL\r\n"
					  + "    AND Last_vacant_visit IS NOT NULL \r\n"
					  + "	--AND Asofdate = '2023-12-05 13:00:54' \r\n"
					  + "	AND Asofdate = (Select MAX(ASofdate) from Automation.MIMOToPw_Prod)" ;               

	   
	   public static String buildingPageURL = "https://app.propertyware.com/pw/properties/building_detail.do?entityID=";
	   
	   
	   public static String[] companyNames = {"Alabama","Arizona","Arkansas","Austin","Boise","California","California pfw","Chattanooga","Chicago","Chicago pfw","Colorado Springs","Dallas/Fort Worth","Delaware","Florida","Hawaii","Georgia","Houston","Idaho Falls","Indiana","Institutional Accounts","Kansas City","Lake Havasu","Little Rock","Maine","Maryland","Montana","New Jersey","New Mexico","North Carolina","OKC","Ohio","Pennsylvania","Saint Louis","San Antonio","Savannah","South Carolina","Spokane","Tennessee","Tulsa","Utah","Virginia","Washington DC"};
	   


}