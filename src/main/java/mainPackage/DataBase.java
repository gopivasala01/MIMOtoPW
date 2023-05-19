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
		            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            con = DriverManager.getConnection(AppConfig.connectionUrl);
		            String SQL = pendingLeasesQuery;
		            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		           // stmt = con.createStatement();
		            rs = stmt.executeQuery(SQL);
		            int rows =0;
		            if (rs.last()) 
		            {
		            	rows = rs.getRow();
		            	// Move to beginning
		            	rs.beforeFirst();
		            }
		            System.out.println("No of Rows = "+rows);
		            RunnerClass.pendingLeases = new String[rows][21];
		           int  i=0;
		            while(rs.next())
		            {
		            	String 	ID =  rs.getObject(1).toString();
		            	String 	company =  (String) rs.getObject(2);
		                String  unitEntityID = (String) rs.getObject(3);
		                String  Address = (String) rs.getObject(4);
		                String  current_Resident_FirstName = (String) rs.getObject(5);
		                String  Current_Resident_LastName = (String) rs.getObject(6);
		                String  Utility_ConnectionRequest = (String) rs.getObject(7);
		                String  SetConstruction_Codeto = (String) rs.getObject(8);
		                String  FilterSize = (String) rs.getObject(9);
		                String  PossesionConfirmedDate = (String) rs.getObject(10);
		                String  TurnOver_HandledBy = (String) rs.getObject(11);
		                String  TurnEstimate_SubmissionDate = (String) rs.getObject(12);
		                String  TurnEstimatedCost = (String) rs.getObject(13);
		                String  TurnApprovalDate = (String) rs.getObject(14);
		                String  TurnStateDate = (String) rs.getObject(15);
		                String  TurnEstimated_CompletionDate = (String) rs.getObject(16);
		                String  TurnActual_CompletionDate = (String) rs.getObject(17);
		                String  TurnActualCost = (String) rs.getObject(18);
		                String  Turn_QCCompletedDate = (String) rs.getObject(19);
		                String  LeasingLockbox_SerialNumber = (String) rs.getObject(20);
		                String  Last_vacantVisit = (String) rs.getObject(21);
		               // System.out.println(company +" |  "+buildingAbbreviation+"  --> "+ownerName);
		                
		    			//ID
		                try 
		                {
		    				RunnerClass.pendingLeases[i][0] = ID;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][0] = "";
		                }
		              //Company
		                try 
		                {
		    				RunnerClass.pendingLeases[i][1] = company;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][1] = "";
		                }
		              //unitEntityID
		                try 
		                {
		    				RunnerClass.pendingLeases[i][2] = unitEntityID;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][2] = "";
		                }
		              //Address
		                try 
		                {
		    				RunnerClass.pendingLeases[i][3] = Address;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][3] = "";
		                }
		              //current_Resident_FirstName
		                try 
		                {
		    				RunnerClass.pendingLeases[i][4] = current_Resident_FirstName;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][4] = "";
		                }
		              //Current_Resident_LastName
		                try 
		                {
		    				RunnerClass.pendingLeases[i][5] = Current_Resident_LastName;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][5] = "";
		                }
		              //Utility_ConnectionRequest
		                try 
		                {
		    				RunnerClass.pendingLeases[i][6] = Utility_ConnectionRequest;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][6] = "";
		                }
		              //SetConstruction_Codeto
		                try 
		                {
		    				RunnerClass.pendingLeases[i][7] = SetConstruction_Codeto;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][7] = "";
		                }
		              //FilterSize
		                try 
		                {
		    				RunnerClass.pendingLeases[i][8] = FilterSize;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][8] = "";
		                }
		              //PossesionConfirmedDate
		                try 
		                {
		    				RunnerClass.pendingLeases[i][9] = PossesionConfirmedDate;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][9] = "";
		                }
		              //TurnOver_HandledBy
		                try 
		                {
		    				RunnerClass.pendingLeases[i][10] = TurnOver_HandledBy;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][10] = "";
		                }
		              //TurnEstimate_SubmissionDate
		                try 
		                {
		    				RunnerClass.pendingLeases[i][11] = TurnEstimate_SubmissionDate;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][11] = "";
		                }
		              //TurnEstimatedCost
		                try 
		                {
		    				RunnerClass.pendingLeases[i][12] = TurnEstimatedCost;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][12] = "";
		                }
		              //TurnApprovalDate
		                try 
		                {
		    				RunnerClass.pendingLeases[i][13] = TurnApprovalDate;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][13] = "";
		                }
		              //TurnStateDate
		                try 
		                {
		    				RunnerClass.pendingLeases[i][14] = TurnStateDate;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][14] = "";
		                }
		              //TurnEstimated_CompletionDate
		                try 
		                {
		    				RunnerClass.pendingLeases[i][15] = TurnEstimated_CompletionDate;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][15] = "";
		                }
		              //TurnActual_CompletionDate
		                try 
		                {
		    				RunnerClass.pendingLeases[i][16] = TurnActual_CompletionDate;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][16] = "";
		                }
		              //TurnActualCost
		                try 
		                {
		    				RunnerClass.pendingLeases[i][17] = TurnActualCost;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][17] = "";
		                }
		              //Turn_QCCompletedDate
		                try 
		                {
		    				RunnerClass.pendingLeases[i][18] = Turn_QCCompletedDate;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][18] = "";
		                }
		              //LeasingLockbox_SerialNumber
		                try 
		                {
		    				RunnerClass.pendingLeases[i][19] = LeasingLockbox_SerialNumber;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][19] = "";
		                }
		              //Last_vacantVisit
		                try 
		                {
		    				RunnerClass.pendingLeases[i][20] = Last_vacantVisit;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][20] = "";
		                }
		    				i++;
		            }	
		            System.out.println("Total Pending Leases  = " +RunnerClass.pendingLeases.length);
		            rs.close();
		            stmt.close();
		            con.close();
		 return true;
		}
		catch(Exception e) 
		{
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

}
