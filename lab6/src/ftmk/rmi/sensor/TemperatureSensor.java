package ftmk.rmi.sensor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

/**
 * This interface represents temperature sensor
 * 
 *
 */
public interface TemperatureSensor extends Remote {
	
	/**
	 * This method gets current temperature
	 * 
	 * @return current temperature
	 * 
	 * @throws RemoteException
	 */
	public int getTemperature() throws RemoteException;
	
	// get specific day temperature
	public HashMap<String, Integer> getTemperatureSpecificDay() 
			throws RemoteException;

	// get average
	public double getTemperatureAverage(HashMap<String, Integer> 
		temperaturesValues) throws RemoteException;


}
