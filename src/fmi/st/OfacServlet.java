package fmi.st;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.webservicex.www.OFACSDNStub;
import net.webservicex.www.OFACSDNStub.ArrayOfSDN;
import net.webservicex.www.OFACSDNStub.IsSDNAndBlockedPersons;
import net.webservicex.www.OFACSDNStub.IsSDNAndBlockedPersonsResponse;
import net.webservicex.www.OFACSDNStub.SDN;
import net.webservicex.www.OFACSDNStub.SDNList;

import org.apache.axis2.AxisFault;


public class OfacServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public OfacServlet() {
       
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = (String)request.getAttribute("name");
		
		try {

			IsSDNAndBlockedPersons person = new IsSDNAndBlockedPersons();
			person.setNames(name);
			
						
			OFACSDNStub client = new OFACSDNStub();
			IsSDNAndBlockedPersonsResponse SOAPresponse = client.isSDNAndBlockedPersons(person);
			
			SDNList list = SOAPresponse.getSDNLists();
			ArrayOfSDN arr = list.getSDNLists();
			
			SDN[] sdn = arr.getSDN();

				request.setAttribute("sdn",sdn);
				RequestDispatcher d = request.getRequestDispatcher("listSDN.jsp"); 
				d.forward(request, response);
					
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			System.out.println("Error when call web service" + e.getMessage());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
