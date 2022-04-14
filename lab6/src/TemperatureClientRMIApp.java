import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import ftmk.rmi.sensor.TemperatureSensor;

/**
 * This class represent the client-side of RMI application
 * 
 * 
 *
 */
public class TemperatureClientRMIApp {

	public static void main(String[] args) {
		
		
		try {
			
			// Get registry
			Registry rmiRegistry = LocateRegistry.getRegistry();
			
			// Look-up for the remote object
			TemperatureSensor remoteSensorJasin 
				= (TemperatureSensor) rmiRegistry.lookup("SensorJasin");
			TemperatureSensor remoteSensorAyerKeroh 
				= (TemperatureSensor) rmiRegistry.lookup("SensorAyerKeroh");
			
			// Invoke method from the remote object
			int currentTemperature = remoteSensorJasin.getTemperature();
			
			// Display temperature
			System.out.println("Current temperature in Jasin is " 
					+ currentTemperature + " Celcius");
					
			// Invoke method from the remote object
			HashMap<String, Integer> temperatures = 
				remoteSensorAyerKeroh.getTemperatureSpecificDay();
			
			// Display temperature using loop
			System.out.println("Temperatures in Ayer Keroh is " );
			temperatures.forEach((k,v) -> {
			    System.out.println(k + " = " + v + " Celcius");
			});

			// Invoke method from the remote object
			double average 
				= remoteSensorAyerKeroh.getTemperatureAverage(temperatures);
			
			// Display average temperature
			System.out.println("The average temperatures in Ayer Keroh is "
					+ average+ " Celcius");
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
