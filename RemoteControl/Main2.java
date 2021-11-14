import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main2 
{
	public static void main(String[] args)
	{
		System.out.println("================UNIVERSAL REMOTE CONTROL PROGRAM================");
		System.out.println("                       BROUGHT TO YOU BY                        ");
		System.out.println("                      FEMME FATALE TEAM                         ");
		System.out.println("================================================================");
		System.out.println("=========NAME=================================STUDENT ID========");
		System.out.println("     Weendy Loo                                 20001351        ");
		System.out.println("   Nur Istiqarah                                20001486        ");
		System.out.println("=================================================================");
		
		//WE ARE TO DECLARE THAT ALL OF THESE CODES ARE OURS AND OURS ALONE.
		//WE DID NOT COPY/PLAGIRIZE/MODIFY ANY SOURCE CODE OR ALGORITHM FROM GOOGLE 
		/*OUR REFERENCES INCLUDE:
		 * Absolute Java by Walter Teich
		 * Starting Out With Java (6th Ed) by Tony Gaddis
		 * w3schools.com/java
		 * tutorialspoint.com/java
		 * Lecture Notes
		 */
		
		//Because we're not really good with GUI programming, we dont know how to remove the error message in the console
		//everytime user exit the window pane
		//but rest assured, we have thoroughly debugged this program
		//and this program should run perfectly fine.
		
		
		int response = 0; //monitor input of switching on device
		int response1 = 0; //monitor input of switching off device
		int mainresponse = 0; //monitor input choosing remote function 
		
		
		
		RemoteControl RadioRemote = new Radio("Khind Radio");
		RemoteControl TVRemote = new Television("Samsung TV");
		RemoteControl ACRemote = new AirCon("Toshiba Aircon");
		RemoteControl AlexaRemote = new VoiceAssistant();
		RemoteControl LightsRemote = new Lights("Sushiko");
		
		//array list add object as called.
		ArrayList<Object> RemoteControl = new ArrayList<Object>();
		
		//user's input will prompt the device to be turned on and subsequently, each devices' method will appear
		
		JOptionPane.showMessageDialog(null, "powered by Weendy Loo 20001351 and Nur Istiqarah 20001486");
		
		
		while (mainresponse == 0)
		{
		//ask user whether they want to switch on or switch off devices
		
		String ONOROFF = JOptionPane.showInputDialog("TO SWITCH ON OR OFF? \n [1]ON \n [2]OFF");
				
				//store user's input
				int ONOROFF_OPTION = Integer.parseInt(ONOROFF);
				
				//to validate input
				while (ONOROFF_OPTION < 1 || ONOROFF_OPTION >2)
				{
					ONOROFF = JOptionPane.showInputDialog("TO SWITCH ON OR OFF? \n [1]ON \n [2]OFFa");
					ONOROFF_OPTION = Integer.parseInt(ONOROFF);
				}
		
		if (ONOROFF_OPTION == 1)
		{
		//ask user which device do they want to switch on
		String REMOTEOPERATIONMENU = JOptionPane.showInputDialog("CHOOSE YOUR BUTTONS, WHICH DEVICE TO CONNECT TO?" +
		"\n[1] RADIO" + "\n[2] TELEVISION" + "\n[3] AIRCON" + "\n[4] VOICE ASSISTANT" + "\n[5] LIGHTS");
		
		//store user's input
		int USERREMOTEOPERATION = Integer.parseInt(REMOTEOPERATIONMENU);
		
		//validating input
		while (USERREMOTEOPERATION < 1 || USERREMOTEOPERATION > 5 ) 
		{
			REMOTEOPERATIONMENU = JOptionPane.showInputDialog("CHOOSE YOUR BUTTONS, WHICH DEVICE TO CONNECT TO?" +
					"\n[1] RADIO" + "\n[2] TELEVISION" + "\n[3] AIRCON" + "\n[4] VOICE ASSISTANT" + "\n[5] LIGHTS");
			USERREMOTEOPERATION = Integer.parseInt(REMOTEOPERATIONMENU); 
		}
		
		// to ensure loop but alas, this while response == 0 doesn't work at all.
		if  (response == 0)
		{
		if (USERREMOTEOPERATION == 1) //if user chose radio
		{
			response = 1;
			mainresponse = 1;
			// the add method will be used to turn on the Radio from the Remote Contro and adding in into the Remote Arraylist above
			RemoteControl.add(RadioRemote);
			RadioRemote.powerOn();
			
			//increments the volume of the radio by 10 units
			RadioRemote.pressPlus(10);
			RadioRemote.pressNumber(USERREMOTEOPERATION);
	
			//to keep the loop going so that there will be no breaking
			//but the response == 0 is not working. so if sir hitham wish to explore the other devices, sir will need to run the program 5 times.
			//but sir please check out the other devices and each of their methods! They come with surprises!
			response = 0;
			
		} //end of if user = 1
		
		else if (USERREMOTEOPERATION == 2) //if user chose tv
		{
			
			response = 1;
			//add tv which is powered by the universal remote control to the ArrayList
			RemoteControl.add(TVRemote);
			
			//press the poweron button on the universal remote control
			TVRemote.powerOn();
			
			//increments the volume of the radio by 20 units
			TVRemote.pressPlus(20);
			
			//stores user's input here;
			TVRemote.pressNumber(USERREMOTEOPERATION);
			
			response = 0;
			
		} //end of else if user == 2
		
		else if (USERREMOTEOPERATION == 3) //use chose Aircon
		{
			response = 1;
			//add tv which is powered by the universal remote control to the ArrayList
			RemoteControl.add(ACRemote);
			
			//press the poweron button on the universal remote control
			ACRemote.powerOn();
			
			//increments the temperature of the Aircon by 20 units
			ACRemote.pressPlus(4);
			
			//stores user's input here;
			ACRemote.pressNumber(USERREMOTEOPERATION);
			
			response = 0;
			
		} //end of else if user == 3
		
		else if (USERREMOTEOPERATION == 4) //user chose voice assistant/Alexa
		{
			response = 1;
			//add voice assistant which is powered by the universal remote control to the ArrayList
			RemoteControl.add(AlexaRemote);
			
			//press the power on button on the universal remote control
			AlexaRemote.powerOn();
			
			//increments the volume of the Voice Assistant by 20 units
			AlexaRemote.pressPlus(4);
			
			//stores user's input here;
			AlexaRemote.pressNumber(USERREMOTEOPERATION);
			
			response = 0;
			
		} //end of else if user == 4
			
		else if (USERREMOTEOPERATION == 5)
		{
			response = 1;
			 //add voice assistant which is powered by the universal remote control to the ArrayList
			RemoteControl.add(LightsRemote);
			
			//press the power on button on the universal remote control
			LightsRemote.powerOn();
			
			//press random number on the universal remote control to activate color switching mode 
			LightsRemote.pressNumber(USERREMOTEOPERATION);
			
			//increments the volume of the Voice Assistant by 20 units
			LightsRemote.pressPlus(4); 
			
			
		} //end of else if user == 5
		} //end of while response = 0
		
		} // end of if to ON device
		
		else if (ONOROFF_OPTION == 2)
		{
			
			//ask user which device do they want to switch off
			String REMOTEOPERATIONMENU2 = JOptionPane.showInputDialog("CHOOSE YOUR BUTTONS, WHICH DEVICE TO OFF?" +
			"\n[1] RADIO" + "\n[2] TELEVISION" + "\n[3] AIRCON" + "\n[4] VOICE ASSISTANT" + "\n[5] LIGHTS");
			
			//store user's input
			int USERREMOTEOPERATION2 = Integer.parseInt(REMOTEOPERATIONMENU2);
			
			//validating input
			while (USERREMOTEOPERATION2 < 1 || USERREMOTEOPERATION2 > 5 ) 
			{
				REMOTEOPERATIONMENU2 = JOptionPane.showInputDialog("CHOOSE YOUR BUTTONS, WHICH DEVICE TO SWITCH OFF?" +
						"\n[1] R"
						+ "ADIO" + "\n[2] TELEVISION" + "\n[3] AIRCON" + "\n[4] VOICE ASSISTANT" + "\n[5] LIGHTS");
				USERREMOTEOPERATION2 = Integer.parseInt(REMOTEOPERATIONMENU2); 
			}
			
			if (response1 == 0)
			{
				
				if (USERREMOTEOPERATION2 == 1) //if user chose radio
				{
					response1 = 1; 
					// the add method will be used to turn off the Radio from the Remote Control and adding in into the Remote Arraylist above
					RemoteControl.add(RadioRemote);
					RadioRemote.powerOff(); //switch off the device
					
					response1 = 0;

					
				} //end of if user = 1
				
				else if (USERREMOTEOPERATION2 == 2) //if user chose tv
				{
					response1 = 1;
					//add tv which is powered by the universal remote control to the ArrayList
					RemoteControl.add(TVRemote);
					
					//press the poweroff button on the universal remote control
					TVRemote.powerOff();  //switch off the device
					
					response1 = 0;
				} //end of else if user == 2
				
				else if (USERREMOTEOPERATION2 == 3) //use chose Aircon
				{
					response1 = 1;
					
					//add tv which is powered by the universal remote control to the ArrayList
					RemoteControl.add(ACRemote);
					
					//press the poweroff button on the universal remote control
					ACRemote.powerOff();
		
					
					response1 = 0;
				} //end of else if user == 3
				
				else if (USERREMOTEOPERATION2 == 4) //user chose voice assistant/Alexa
				{
					response1 = 1;
					
					//add voice assistant which is powered by the universal remote control to the ArrayList
					RemoteControl.add(AlexaRemote);
					
					//press the poweroff button on the universal remote control
					AlexaRemote.powerOff();
					
					response1 = 0;
					
				} //end of else if user == 4
					
				else if (USERREMOTEOPERATION2 == 5)
				{
		
					response1 = 1;
					 //add voice assistant which is powered by the universal remote control to the ArrayList
					RemoteControl.add(LightsRemote);
					
					//press the power off button on the universal remote control
					LightsRemote.powerOff();
					
					
					response1 = 0;
					
				} //end of else if user == 5
				
			} //end of response1 == 0
			
		} //end of if want to switch off device
		} //end of while main response = 0
	} // end of public static void main 
}
