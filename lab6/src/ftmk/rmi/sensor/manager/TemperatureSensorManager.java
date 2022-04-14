package ftmk.rmi.sensor.manager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import ftmk.rmi.sensor.TemperatureSensor;

/**
 * This class manage the value of temperature from the sensor.
 * 
 *
 */
public class TemperatureSensorManager extends UnicastRemoteObject 
	implements TemperatureSensor {

	public TemperatureSensorManager() throws RemoteException {
		super();
	}

	@Override
	public int getTemperature() throws RemoteException {
		
		return 35;
	}
	
	@Override
	public HashMap<String, Integer> getTemperatureSpecificDay() 
			throws RemoteException{
		
		// create a hashmap
		HashMap<String, Integer> temperatures = new HashMap<>();
		
		// put() method to add elements
		temperatures.put("Monday", 1);
		temperatures.put("Tuesday", 2);
		temperatures.put("wednesday", 3);
		temperatures.put("Thursday", 1);
		temperatures.put("Friday", 2);
		temperatures.put("Saturday", 3);
		temperatures.put("Sunday", 3);
		
		return temperatures;
	}
	public double getTemperatureAverage(HashMap<String, Integer>  temperatures) 
			throws RemoteException{
		
		// calculate average
		double average = 0;
		for (Integer temperature :temperatures.values() ){
			average +=  temperature;
		}
		average = average/ temperatures.size();
		
		
		return average;
	}
	
}
