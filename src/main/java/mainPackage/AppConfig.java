package mainPackage;

public class AppConfig 
{
	 public static boolean saveButtonOnAndOff= false;
		
	   public static String URL ="https://app.propertyware.com/pw/login.jsp";
	   public static String username ="mds0418@gmail.com";
	   public static String password ="HomeRiver1#";
	   
	   public static String excelFileLocation = "E:\\Automation\\Initial Rents Update";
	   public static String downloadFilePath = "C:\\SantoshMurthyP\\Initial Rents Update";
	   //Mail credentials
	   public static String fromEmail = "bireports@beetlerim.com";
	   public static String fromEmailPassword = "Welcome@123";
	   
	   public static String toEmail = "gopi.v@beetlerim.com";
	   public static String CCEmail = "gopi.v@beetlerim.com";
	   
	   public static String mailSubject = "Initial Rents Update for  ";
	   
	   public static String[] LeaseAgreementFileNames = {"REVISED_Lease_","Lease_","Leases_"};
	   
	   public static String connectionUrl = "jdbc:sqlserver://azrsrv001.database.windows.net;databaseName=HomeRiverDB;user=service_sql02;password=xzqcoK7T;encrypt=true;trustServerCertificate=true;";
	   
	  // public static String leaseFetchQuery  = "Select Company, Building,leaseName from Automation.InitialRentsUpdate where Status ='Pending' and Company ='Georgia'";
	   
	   public static String pendingLeasesQuery = "Select ID,CompanyName,Unit_Entity_ID,Address,Current_Resident_FirstName,Current_Resident_LastName\r\n"
	   		+ ",Utility_ConnectionRequest,SetConstruction_Codeto,FilterSize,PossesionConfirmedDate,TurnOver_HandledBy,TurnEstimate_SubmissionDate,TurnEstimatedCost,\r\n"
	   		+ "TurnApprovalDate, TurnStateDate,TurnEstimated_CompletionDate,TurnActual_CompletionDate,TurnActualCost,Turn_QCCompletedDate,LeasingLockbox_SerialNumber,Last_vacantVisit\r\n"
	   		+ "from Automation.MIMOToPw where CompanyName is not NULL and Automation_Status='Pending' \r\n"
	   		+ "and AsofDate = (Select MAX(AsofDate) from Automation.MIMOToPw) \r\n"
	   		+ "order by CompanyName";
	   
	   public static String failedLeasesQuery = "Select Company, Building,leaseName from Automation.InitialRentsUpdate where Status ='Failed' and Company ='North Carolina' and (Notes ='Building Not Found' or  Notes = ',Unable to Click Lease Onwer Name')"; 
	   
	   public static String getLeasesWithStatusforCurrentDay = "Select Company, Building,ThirdPartyUnitID, Leaseidnumber, LeaseName,leaseExecutionDate, StartDate, EndDate, MonthlyRent, MonthlyRentFromPW, PetRent, PetRentFromPW,Status, Notes from Automation.InitialRentsUpdate where Format(convert(datetime, CompletedDate, 101),'dd MM yyyy') = format(getdate(),'dd MM yyyy')";
	   
	   public static String buildingPageURL = "https://app.propertyware.com/pw/properties/building_detail.do?entityID=";
	   


}
