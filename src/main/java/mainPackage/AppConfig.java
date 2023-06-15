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
	   public static String CCEmail = "gopi.v@beetlerim.com";
	   
	   public static String mailSubject = "MIMO to PW Report  ";
	   
	   public static String[] LeaseAgreementFileNames = {"REVISED_Lease_","Lease_","Leases_"};
	   
	   public static String connectionUrl = "jdbc:sqlserver://azrsrv001.database.windows.net;databaseName=HomeRiverDB;user=service_sql02;password=xzqcoK7T;encrypt=true;trustServerCertificate=true;";
	   
	  // public static String leaseFetchQuery  = "Select Company, Building,leaseName from Automation.InitialRentsUpdate where Status ='Pending' and Company ='Georgia'";
	   
	   public static String pendingLeasesQuery = "Select ID,\r\n"
	   		+ "CompanyName,\r\n"
	   		+ "Unit_Entity_ID,\r\n"
	   		+ "Address,\r\n"
	   		+ "Current_Resident_FirstName,\r\n"
	   		+ "Current_Resident_LastName,\r\n"
	   		+ "Utility_ConnectionRequest,\r\n"
	   		+ "SetConstruction_Codeto,\r\n"
	   		+ "FilterSize,\r\n"
	   		+ "PossesionConfirmedDate,\r\n"
	   		+ "TurnOver_HandledBy,\r\n"
	   		+ "TurnEstimate_SubmissionDate,\r\n"
	   		+ "TurnEstimatedCost,\r\n"
	   		+ "TurnApprovalDate,\r\n"
	   		+ "TurnStateDate,\r\n"
	   		+ "TurnEstimated_CompletionDate,\r\n"
	   		+ "TurnActual_CompletionDate,\r\n"
	   		+ "TurnActualCost,\r\n"
	   		+ "Turn_QCCompletedDate,\r\n"
	   		+ "LeasingLockbox_SerialNumber,\r\n"
	   		+ "Last_vacantVisit from Automation.MIMOtoPW \r\n"
	   		+ "	   where CompanyName is not NULL and companyName <>'' and Automation_Status='Pending'  \r\n" //and CompanyName like '%Home%'
	   		+ "	   and  CompanyName <>'HomeRiver Group'";
	   	//	+ "	   and AsofDate = (Select MAX(AsofDate) from Automation.MIMOToPw)  order by CompanyName";
	   
	   
	   
	   public static String failedLeasesQuery = "Select ID,\r\n"
		   		+ "CompanyName,\r\n"
		   		+ "Unit_Entity_ID,\r\n"
		   		+ "Address,\r\n"
		   		+ "Current_Resident_FirstName,\r\n"
		   		+ "Current_Resident_LastName,\r\n"
		   		+ "Utility_ConnectionRequest,\r\n"
		   		+ "SetConstruction_Codeto,\r\n"
		   		+ "FilterSize,\r\n"
		   		+ "PossesionConfirmedDate,\r\n"
		   		+ "TurnOver_HandledBy,\r\n"
		   		+ "TurnEstimate_SubmissionDate,\r\n"
		   		+ "TurnEstimatedCost,\r\n"
		   		+ "TurnApprovalDate,\r\n"
		   		+ "TurnStateDate,\r\n"
		   		+ "TurnEstimated_CompletionDate,\r\n"
		   		+ "TurnActual_CompletionDate,\r\n"
		   		+ "TurnActualCost,\r\n"
		   		+ "Turn_QCCompletedDate,\r\n"
		   		+ "LeasingLockbox_SerialNumber,\r\n"
		   		+ "Last_vacantVisit from Automation.MIMOtoPW \r\n"
		   		+ "	   where Automation_Status='Pending' and Automation_Notes='Building not found' "; 
	   
	   public static String getLeasesWithStatusforCurrentDay = "Select CompanyName,Unit_Entity_ID,Address,Current_Resident_FirstName,Current_Resident_LastName\r\n"
		   		+ ",Utility_ConnectionRequest,SetConstruction_Codeto,FilterSize,PossesionConfirmedDate,TurnOver_HandledBy,TurnEstimate_SubmissionDate,TurnEstimatedCost,\r\n"
		   		+ "TurnApprovalDate, TurnStateDate,TurnEstimated_CompletionDate,TurnActual_CompletionDate,TurnActualCost,Turn_QCCompletedDate,LeasingLockbox_SerialNumber,Last_vacantVisit,Automation_Status,Automation_Notes\r\n"
		   		+ "from Automation.MIMOToPw  ";
	   
	   public static String buildingPageURL = "https://app.propertyware.com/pw/properties/building_detail.do?entityID=";
	   
	   
	   public static String[] companyNames = {"Alabama","Arizona","Arkansas","Austin","Boise","California","California pfw","Chattanooga","Chicago","Chicago pfw","Colorado Springs","Dallas/Fort Worth","Delaware","Florida","Hawaii","Georgia","Houston","Idaho Falls","Indiana","Institutional Accounts","Kansas City","Lake Havasu","Little Rock","Maine","Maryland","Montana","New Jersey","New Mexico","North Carolina","OKC","Ohio","Pennsylvania","Saint Louis","San Antonio","Savannah","South Carolina","Spokane","Tennessee","Tulsa","Utah","Virginia","Washington DC"};
	   


}
