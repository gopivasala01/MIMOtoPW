package mainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase 
{
	public static boolean getBuildingsList(String pendingLeasesQuery) 
	{
	    try 
	    {
	        Connection con = null;
	        Statement stmt = null;
	        ResultSet rs = null;
	        con = DriverManager.getConnection(AppConfig.connectionUrl);
	        String SQL = pendingLeasesQuery;
	        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	        rs = stmt.executeQuery(SQL);
	        int rows = 0;
	        if (rs.last()) 
	        {
	            rows = rs.getRow();
	            // Move to beginning
	            rs.beforeFirst();
	        }
	        System.out.println("No of Rows = " + rows);
	        RunnerClass.pendingLeases = new String[rows][24];
	        int i = 0;
	        while (rs.next()) 
	        {
	        	 String ID;
	            String unitEntityID;
	            String company;
	            String leaseEntityID;
	            String address;
	            String current_Resident_FirstName;
	            String current_Resident_LastName;
	            String utility_ConnectionRequest;
	            String setConstruction_Codeto;
	            String filterSize;
	            String possesionConfirmedDate;
	            String turnOver_HandledBy;
	            String turnEstimate_SubmissionDate;
	            String turnEstimatedCost;
	            String turnApprovalDate;
	            String turnStateDate;
	            String turnEstimated_CompletionDate;
	            String turnActual_CompletionDate;
	            String turnActualCost;
	            String turn_QCCompletedDate;
	            String leasingLockbox_SerialNumber;
	            String last_vacantVisit;
	            String automationStatus;
	            String buildingAbbrevation;

	           
	            try {
	                ID = rs.getString("ID");
	            } catch (Exception e) {
	                ID = "";
	            }
	            try 
	            {
	                unitEntityID = rs.getString("Unit_Entity_ID");
	            } catch (Exception e) 
	            {
	                unitEntityID = "";
	            }

	            try 
	            {
	                company = rs.getString("Company_Name");
	            } catch (Exception e) 
	            {
	                company = "";
	            }

	            try 
	            {
	                leaseEntityID = rs.getString("New_Resident_Lease_Entity_ID");
	            } catch (Exception e) 
	            {
	                leaseEntityID = "";
	            }

	            try 
	            {
	                address = rs.getString("Address");
	            } catch (Exception e) 
	            {
	                address = "";
	            }

	            try 
	            {
	                current_Resident_FirstName = rs.getString("Current_Resident_First_Name");
	            } catch (Exception e)
	            {
	                current_Resident_FirstName = "";
	            }

	            try 
	            {
	                current_Resident_LastName = rs.getString("Current_Resident_Last_Name");
	            } catch (Exception e) 
	            {
	                current_Resident_LastName = "";
	            }

	            try {
	                utility_ConnectionRequest = rs.getString("Utility_Connection_Request_RC");
	            } catch (Exception e) 
	            {
	                utility_ConnectionRequest = "";
	            }

	            try 
	            {
	                setConstruction_Codeto = rs.getString("Set_Construction_Lockbox_Code_To_TC");
	            } catch (Exception e) 
	            {
	                setConstruction_Codeto = "";
	            }

	            try 
	            {
	                filterSize = rs.getString("Filter_Size_FI");
	            } catch (Exception e) 
	            {
	                filterSize = "";
	            }

	            try 
	            {
	                possesionConfirmedDate = rs.getString("Possession_Confirmed_Date");
	            } catch (Exception e) 
	            {
	                possesionConfirmedDate = "";
	            }

	            try 
	            {
	                turnOver_HandledBy = rs.getString("Turn_Over_Handled_By_TC");
	            } catch (Exception e) 
	            {
	                turnOver_HandledBy = "";
	            }

	            try 
	            {
	                turnEstimate_SubmissionDate = rs.getString("Turn_Estimate_Submission_Date");
	            } catch (Exception e) 
	            {
	                turnEstimate_SubmissionDate = "";
	            }

	            try 
	            {
	                turnEstimatedCost = rs.getString("Turn_Estimated_Cost_TC");
	            } catch (Exception e) 
	            {
	                turnEstimatedCost = "";
	            }

	            try 
	            {
	                turnApprovalDate = rs.getString("Turn_Approval_Date_TC");
	            } catch (Exception e)
	            {
	                turnApprovalDate = "";
	            }

	            try 
	            {
	                turnStateDate = rs.getString("Turn_Start_Date_TC");
	            } catch (Exception e) 
	            {
	                turnStateDate = "";
	            }

	            try 
	            {
	                turnEstimated_CompletionDate = rs.getString("Turn_Estimated_Completion_Date_TC");
	            } catch (Exception e)
	            {
	                turnEstimated_CompletionDate = "";
	            }

	            try 
	            {
	                turnActual_CompletionDate = rs.getString("Turn_Actual_Completion_Date_TC");
	            } catch (Exception e) 
	            {
	                turnActual_CompletionDate = "";
	            }

	            try 
	            {
	                turnActualCost = rs.getString("Turn_Actual_Cost_TC");
	            } catch (Exception e) 
	            {
	                turnActualCost = "";
	            }

	            try 
	            {
	                turn_QCCompletedDate = rs.getString("Turn_QC_Completed_Date_FI");
	            } catch (Exception e) 
	            {
	                turn_QCCompletedDate = "";
	            }

	            try 
	            {
	                leasingLockbox_SerialNumber = rs.getString("Leasing_Lockbox_Serial_Number_FI");
	            } catch (Exception e)
	            {
	                leasingLockbox_SerialNumber = "";
	            }

	            try 
	            {
	                last_vacantVisit = rs.getString("Last_vacant_visit");
	            } catch (Exception e) 
	            {
	                last_vacantVisit = "";
	            }
	            try 
	            {
	                automationStatus = rs.getString("AutomationStatus");
	            } catch (Exception e)
	            {
	            	automationStatus = "";
	            }
	            try 
	            {
	            	buildingAbbrevation = rs.getString("BuildingAbbreviation");
	            } catch (Exception e)
	            {
	            	buildingAbbrevation = "";
	            }
	            

	            
	            RunnerClass.pendingLeases[i][0] = ID;
	            RunnerClass.pendingLeases[i][1] = unitEntityID;
	            RunnerClass.pendingLeases[i][2] = company;
	            RunnerClass.pendingLeases[i][3] = leaseEntityID;
	            RunnerClass.pendingLeases[i][4] = address;
	            RunnerClass.pendingLeases[i][5] = current_Resident_FirstName;
	            RunnerClass.pendingLeases[i][6] = current_Resident_LastName;
	            RunnerClass.pendingLeases[i][7] = utility_ConnectionRequest;
	            RunnerClass.pendingLeases[i][8] = setConstruction_Codeto;
	            RunnerClass.pendingLeases[i][9] = filterSize;
	            RunnerClass.pendingLeases[i][10] = possesionConfirmedDate;
	            RunnerClass.pendingLeases[i][11] = turnOver_HandledBy;
	            RunnerClass.pendingLeases[i][12] = turnEstimate_SubmissionDate;
	            RunnerClass.pendingLeases[i][13] = turnEstimatedCost;
	            RunnerClass.pendingLeases[i][14] = turnApprovalDate;
	            RunnerClass.pendingLeases[i][15] = turnStateDate;
	            RunnerClass.pendingLeases[i][16] = turnEstimated_CompletionDate;
	            RunnerClass.pendingLeases[i][17] = turnActual_CompletionDate;
	            RunnerClass.pendingLeases[i][18] = turnActualCost;
	            RunnerClass.pendingLeases[i][19] = turn_QCCompletedDate;
	            RunnerClass.pendingLeases[i][20] = leasingLockbox_SerialNumber;
	            RunnerClass.pendingLeases[i][21] = last_vacantVisit;
	            RunnerClass.pendingLeases[i][22] = automationStatus;
	            RunnerClass.pendingLeases[i][23] = buildingAbbrevation;
	            
	            i++;
	        }
	        System.out.println("Total Pending Leases = " + RunnerClass.pendingLeases.length);
	        rs.close();
	        stmt.close();
	        con.close();
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	public static void updateTable(String query)
	 {
		    try (Connection conn = DriverManager.getConnection(AppConfig.connectionUrl);
		        Statement stmt = conn.createStatement();) 
		    {
		      stmt.executeUpdate(query);
		      System.out.println("Record Updated");
		      stmt.close();
	            conn.close();
		    } catch (SQLException e) 
		    {
		      e.printStackTrace();
		    }
	 }
	
	public static boolean getCompletedBuildingsList() 
	{
	    try 
	    {
	        Connection con = null;
	        Statement stmt = null;
	        ResultSet rs = null;
	        con = DriverManager.getConnection(AppConfig.connectionUrl);
	        String SQL = AppConfig.getLeasesWithStatusforCurrentDay;
	        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	        rs = stmt.executeQuery(SQL);
	        int rows = 0;
	        if (rs.last()) 
	        {
	            rows = rs.getRow();
	            // Move to beginning
	            rs.beforeFirst();
	        }
	        System.out.println("No of buildings with status = " + rows);
	        RunnerClass.completedLeasesList = new String[rows][28];
	        int i = 0;
	        while (rs.next()) 
	        {
	        	String ID = rs.getString("ID");
	        	String unitEntityID = rs.getString("Unit_Entity_ID");
	        	String leaseEntityID = rs.getString("Vacating_Resident_Lease_Entity_ID");
	        	String status = rs.getString("Status");
	        	String address = rs.getString("Address");
	        	String current_Resident_FirstName = rs.getString("Current_Resident_First_Name");
	        	String current_Resident_LastName = rs.getString("Current_Resident_Last_Name");
	        	String company = rs.getString("Company_Name");
	        	String last_Chance_Save_Renewal_Call_RC = rs.getString("Last_Chance_Save_Renewal_Call_RC");
	        	String utility_ConnectionRequest = rs.getString("Utility_Connection_Request_RC");
	        	String setConstruction_Codeto = rs.getString("Set_Construction_Lockbox_Code_To_TC");
	        	String filterSize = rs.getString("Filter_Size_FI");
	        	String possesionConfirmedDate = rs.getString("Possession_Confirmed_Date");
	        	String turnOver_HandledBy = rs.getString("Turn_Over_Handled_By_TC");
	        	String turnEstimate_SubmissionDate = rs.getString("Turn_Estimate_Submission_Date");
	        	String turnEstimatedCost = rs.getString("Turn_Estimated_Cost_TC");
	        	String turnApprovalDate = rs.getString("Turn_Approval_Date_TC");
	        	String turnStateDate = rs.getString("Turn_Start_Date_TC");
	        	String turnEstimated_CompletionDate = rs.getString("Turn_Estimated_Completion_Date_TC");
	        	String turnActual_CompletionDate = rs.getString("Turn_Actual_Completion_Date_TC");
	        	String turnActualCost = rs.getString("Turn_Actual_Cost_TC");
	        	String turn_QC_Scheduled_Date_TC = rs.getString("Turn_QC_Scheduled_Date_TC");
	        	String turn_QCCompletedDate = rs.getString("Turn_QC_Completed_Date_FI");
	        	String leasingLockbox_SerialNumber = rs.getString("Leasing_Lockbox_Serial_Number_FI");
	        	String last_vacantVisit = rs.getString("Last_vacant_visit");
	        	String automationStatus = rs.getString("AutomationStatus");
	        	String asOfDate = rs.getString("AsOfDate");
	        	String automation_Notes = rs.getString("Note");
	            String buildingAbbrevation = rs.getString("BuildingAbbreviation");

	        	// Populate the array
	        	RunnerClass.completedLeasesList[i][0] = ID;
	        	RunnerClass.completedLeasesList[i][1] = unitEntityID;
	        	RunnerClass.completedLeasesList[i][2] = leaseEntityID;
	        	RunnerClass.completedLeasesList[i][3] = status;
	        	RunnerClass.completedLeasesList[i][4] = address;
	        	RunnerClass.completedLeasesList[i][5] = current_Resident_FirstName;
	        	RunnerClass.completedLeasesList[i][6] = current_Resident_LastName;
	        	RunnerClass.completedLeasesList[i][7] = company;
	        	RunnerClass.completedLeasesList[i][8] = last_Chance_Save_Renewal_Call_RC;
	        	RunnerClass.completedLeasesList[i][9] = utility_ConnectionRequest;
	        	RunnerClass.completedLeasesList[i][10] = setConstruction_Codeto;
	        	RunnerClass.completedLeasesList[i][11] = filterSize;
	        	RunnerClass.completedLeasesList[i][12] = possesionConfirmedDate;
	        	RunnerClass.completedLeasesList[i][13] = turnOver_HandledBy;
	        	RunnerClass.completedLeasesList[i][14] = turnEstimate_SubmissionDate;
	        	RunnerClass.completedLeasesList[i][15] = turnEstimatedCost;
	        	RunnerClass.completedLeasesList[i][16] = turnApprovalDate;
	        	RunnerClass.completedLeasesList[i][17] = turnStateDate;
	        	RunnerClass.completedLeasesList[i][18] = turnEstimated_CompletionDate;
	        	RunnerClass.completedLeasesList[i][19] = turnActual_CompletionDate;
	        	RunnerClass.completedLeasesList[i][20] = turnActualCost;
	        	RunnerClass.completedLeasesList[i][21] = turn_QC_Scheduled_Date_TC;
	        	RunnerClass.completedLeasesList[i][22] = turn_QCCompletedDate;
	        	RunnerClass.completedLeasesList[i][23] = leasingLockbox_SerialNumber;
	        	RunnerClass.completedLeasesList[i][24] = last_vacantVisit;
	        	RunnerClass.completedLeasesList[i][25] = automationStatus;
	        	RunnerClass.completedLeasesList[i][26] = asOfDate;
	        	RunnerClass.completedLeasesList[i][27] = automation_Notes;
	        	RunnerClass.completedLeasesList[i][28] = buildingAbbrevation;
	            i++;
	        }
	        rs.close();
	        stmt.close();
	        con.close();
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	
	public static boolean getPendingLeases() 
	{
	    try 
	    {
	        Connection con = null;
	        Statement stmt = null;
	        ResultSet rs = null;
	        con = DriverManager.getConnection(AppConfig.connectionUrl);
	        String SQL = AppConfig.checkAutomationPendingLeases;
	        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	        rs = stmt.executeQuery(SQL);
	        int rows = 0;
	        if (rs.last()) 
	        {
	            rows = rs.getRow();
	            // Move to beginning
	            if(rows == 0) {
	            	return true;
	            }
	            else {
	            	return false;
	            }
	        }
	        System.out.println("No of Rows = " + rows);
	    }
	    catch(Exception e) {
	    	return false;
	    }
		return true;
		
	}
}