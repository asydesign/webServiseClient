package fmi.st;


import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import net.webservicex.www.OFACSDNStub;
import net.webservicex.www.OFACSDNStub.ArrayOfSDN;
import net.webservicex.www.OFACSDNStub.IsSDNAndBlockedPersons;
import net.webservicex.www.OFACSDNStub.IsSDNAndBlockedPersonsResponse;
import net.webservicex.www.OFACSDNStub.SDN;
import net.webservicex.www.OFACSDNStub.SDNList;


public class WsClient2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			IsSDNAndBlockedPersons person = new IsSDNAndBlockedPersons();
			person.setNames("Alex");
			
						
			OFACSDNStub client = new OFACSDNStub();
			IsSDNAndBlockedPersonsResponse response = client.isSDNAndBlockedPersons(person);
			
			SDNList list = response.getSDNLists();
			ArrayOfSDN arr = list.getSDNLists();
			
			SDN[] sdn = arr.getSDN();
			if(sdn != null){
				
			
			
			for (int i=0; i< sdn.length; i++){
				System.out.println("Name: " + sdn[i].getNameOfSDN());
			}
			}else{
				System.out.println("Niama namereni zapisi.");
			}
			
		
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			System.out.println("Error when call web service" + e.getMessage());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	

	}

}
