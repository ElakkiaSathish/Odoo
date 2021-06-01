
 
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import java.sql.*;
 
public class Time_Delay_Results {
    public static void main(String[] args) {
        
    

  int count=0;
  int count1=0;
  double c1=0.0;
  double c2=0.0;
  double c3=0.0;
  double c4=0.0;
  double c5=0.0;
  double c6=0.0;
  double c7=0.0;
  double c8=0.0;
  
  
  
    	try
    	{
    		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    		Connection con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};Dbq=src\\Database.mdb");
    		Statement st=con.createStatement();
    		ResultSet rs=st.executeQuery("select * from Results");
    		
    		while(rs.next()==true)
    		{
    			count++;
    			if(count==1)
    			{
    				c1=Double.valueOf(rs.getInt("tp"));
    			}
    			
    			if(count==2)
    			{
    			c2=Double.valueOf(rs.getInt("tp"));
    			}
    			if(count==3)
    			{
    				c3=Double.valueOf(rs.getInt("tp"));
    			}
    			if(count==4)
    			{
    				c4=Double.valueOf(rs.getInt("tp"));
    			}
    			if(count==5)
    			{
    				c5=Double.valueOf(rs.getInt("tp"));
    			}
    			if(count==6)
    			{
    				c6=Double.valueOf(rs.getInt("tp"));
    			}
    			if(count==7)
    			{
    				c7=Double.valueOf(rs.getInt("tp"));
    			}
    			if(count==8)
    			{
    				c8=Double.valueOf(rs.getInt("tp"));
    			}	
    		}
    		    DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
    	        dataSet.setValue(c1, "Throughput1", "Tp1");
    	        dataSet.setValue(c2, "Throughput2", "Tp2");
    	        dataSet.setValue(c3, "Throughput3", "Tp3");
    	        dataSet.setValue(c4, "Throughput4", "Tp4");
    	        dataSet.setValue(c5, "Throughput5", "Tp5");
    	        dataSet.setValue(c6, "Throughput6", "Tp6");
    	        dataSet.setValue(c7, "Throughput7", "Tp7");
    	        dataSet.setValue(c8, "Throughput8", "Tp8");
    	 
    	        JFreeChart chart = ChartFactory.createBarChart3D("Data Driven Faulty Node Detection Scheme for Wireless Sensor Networks", "Throughput(MS) ", "Total Throughput (MS)",
    	                dataSet, PlotOrientation.VERTICAL, true, true, true);
    	        ChartFrame chartFrame=new ChartFrame("An Efficient Online Algorithm for Dynamic SDN Controller Assignment in Data Center Networks",chart);
    	        chartFrame.setVisible(true);
    	     
    	        chartFrame.setSize(800,500);
    	        
        
    	}
    	catch(Exception ex)
    	{
    	System.out.println(ex);	
    		
    	}
    
}
}