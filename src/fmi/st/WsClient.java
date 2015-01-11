package fmi.st;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import net.webservicex.www.GeoIPServiceStub;
import net.webservicex.www.GeoIPServiceStub.GeoIP;
import net.webservicex.www.GeoIPServiceStub.GetGeoIP;
import net.webservicex.www.GeoIPServiceStub.GetGeoIPResponse;


public class WsClient {


	public static void main(String[] args) {
		
		try {
			GetGeoIP param = new GetGeoIP();
			param.setIPAddress("194.141.99.24");
			
			GeoIPServiceStub client = new GeoIPServiceStub();
			GetGeoIPResponse response = client.getGeoIP(param);
			
			GeoIP geoIP = response.getGetGeoIPResult();
			
			System.out.println("Country name  : " + geoIP.getCountryName());
			System.out.println("Country code  : " + geoIP.getCountryCode());
			System.out.println("IP            : " + geoIP.getIP());
			System.out.println("Return code   : " + geoIP.getReturnCode());
			System.out.println("Return details: " + geoIP.getReturnCodeDetails());
			
		
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			System.out.println("Error when call web service" + e.getMessage());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
