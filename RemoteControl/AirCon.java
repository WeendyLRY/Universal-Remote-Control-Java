import javax.swing.JOptionPane;

public class AirCon implements RemoteControl
{
	/*FIELDS*/
	private double temperature;
	private boolean fanMode;
	//private String voiceAssistant;
	private int timer_minutes;
	private int timer_hours;
	private boolean Power; 
	private int volume = 0;
	String brand;
	

	/*CONSTRUCTOR*/
	public AirCon(String brand)
	{
		this.brand = brand;
		this.temperature = 0.0;
		this.fanMode = false;
		//this.voiceAssistant = "Device is turned off and not configured"; 
		this.timer_minutes = 0;
		this.timer_hours = 0;
		this.Power = false;
		this.volume = 0;
		
	}

	public AirCon(double temp, boolean fan, String voice, int min, int hr, boolean power, int volume)
	{
		this.temperature = temp;
		this.fanMode = fan;
		//this.voiceAssistant = voice; 
		this.timer_minutes = min;
		this.timer_hours = hr;
		this.Power = power;
		this.volume = volume;
	}
	
	/*MUTATOR*/
	public void setTemperature(double temp)
	{
		if (Power == true)
		{
			this.temperature = temp;
		}
		else 
		{
			System.out.println("AIRCON NEED TO BE TURNED ON BEFORE ANY CONFIGURATION!");
		}
	}

	public void setFan(boolean Fan)
	{
		if (Power == true)
		{
			this.fanMode = Fan;
		}
		else 
		{
			System.out.println("AIRCON NEED TO BE TURNED ON BEFORE ANY CONFIGURATION!");
		}
	}
	
	/*
	public void setVoice(String Accent, String Gender, double speed)
	{
		if (Power==true)
		{
			voiceAssistant = ("Accent: " + Accent + "\nGender:" + Gender + "\nVoice speed:" + speed + "\nVolume:" + getVolume());
		}
		else
		{
			System.out.println("AIRCON NEED TO BE TURNED ON BEFORE ANY CONFIGURATION!");
		}
		
	}
	*/
	
	
	public void setMinutes(int min)
	{
		if (Power==true)
		{
			this.timer_minutes = min;
		}
		else
		{
			System.out.println("AIRCON NEED TO BE TURNED ON BEFORE ANY CONFIGURATION!");
		}
	}
	
	public void setHour(int hr)
	{
		if (Power==true)
		{
			this.timer_hours = hr;
		}
		else
		{
			System.out.println("AIRCON NEED TO BE TURNED ON BEFORE ANY CONFIGURATION!");
		}
	}
	
	public void setTimer(int min, int hr)
	{
		if (Power==true)
		{
			this.timer_hours = hr;
			this.timer_minutes = min;
		}
		else
		{
			System.out.println("AIRCON NEED TO BE TURNED ON BEFORE ANY CONFIGURATION!");
		}
	}
	
	public void setPower(boolean power)
	{
		this.Power = power;
	}
	
	public void setVolume (int Volume)
	{
		if (Power == true)
		{
			this.volume = Volume;
		}
		else 
		{
			System.out.println("AIRCON NEED TO BE TURNED ON BEFORE ANY CONFIGURATION!");
		}
	}

	/*OVERRIDEN METHODS*/
	
	

	public void VolumeUp(int volume) 
	{
		if (Power==true)
		{
		System.out.println("Volume will determine the loudness unit of the aircon voice assistant");
		//to increase volume up until the argument i
				for (int i = 0; i <= volume; i++ )
				{
					this.volume += i;
				}
				
				System.out.println("Volume is incremented by " + volume + " units...");
		}
		else
		{
			System.out.println("AIRCON NEED TO BE TURNED ON BEFORE ANY CONFIGURATION!");
		}
	}

	public void VolumeDown(int volume) {
		
		if (Power==true)
		{
		
		System.out.println("Volume will determine the loudness unit of the aircon voice assistant");
		if (this.volume <= volume)
		{
			System.out.println("You cannot decrement the volume lower than the TV volume");
			System.exit(0);
		}
		else 
		{	
			this.volume -= volume;
			System.out.println("Volume is decremented by " + volume + " units...");
		}
		}
		else
		{
			System.out.println("AIRCON NEED TO BE TURNED ON BEFORE ANY CONFIGURATION!");
		}
		
	}

	@Override
	public void powerOn() 
	{
		Power = true;
		System.out.println("Aircon is turned on");
	}

	@Override
	public void powerOff() 
	{
		Power = false;
		System.out.println("Aircon is turned off");
	}
	
	/*ACCESSORS*/
	
	public double getTemperature()
	{
		return this.temperature;
	}
	
	public boolean getFanMode()
	{
		return this.fanMode;
	}
	
	/*public String getVoiceAssistant()
	{
		return voiceAssistant;
	}
	*/
	
	public int getTimer_minutes()
	{
		return this.timer_minutes;
	}
	
	public int getTimer_hours()
	{
		return this.timer_hours;
	}
	
	public boolean getPower()
	{
		return Power;
	}
	
	public int getVolume()
	{
		return this.volume;
	}
	
	/*toString*/
	
	public String toString()
	{
		if (Power==true && fanMode == true)
		{
			return ("Computer is turned on" + "\nTemperature is set at " + getTemperature() +
					/*"\nFan Mode is turned on" + getVoiceAssistant() + */ "\nminute timer is set at" + getTimer_minutes() + "\nhour timer is set at" + getTimer_hours() + 
					"\nVolume of AC Voice Assistant is: " + getVolume());	
		}
		if (Power == true && fanMode == false)
		{
			return ("Computer is turned on" + "\nTemperature is set at " + getTemperature() +
					 "\nFan Mode is turned off" /* + getVoiceAssistant() */ + "\nminute timer is set at" + getTimer_minutes() + "\nhour timer is set at" + getTimer_hours() + 
					"\nVolume of AC Voice Assistant is: " + getVolume());
		}
		else 
			return ("AC is turned off. Thus, it is impossible for the AC to be configured");
	}

	@Override
	public void pressNumber(int i)
	{
		setPower(true);
		if (Power)
		{
			String str = JOptionPane.showInputDialog("ACIS TURNED ON "
					+ " \n1 OPEN FANMODE "
					+ "\n2 DISABLE FANMODE "
					+ "\n3 SET TIMER FOR HOURS AND MINUTES "
					+ "\n4 WHAT IS MY AC BRAND"
					+ " \n5 SET TEMPERATURE  "
					+ "\n6 CHECK TEMPERATURE "
					+ "\n7 NOTHING"
					+ "\n8 NOTHING"
					+ "\n9 NOTHING"
					+ "\n0 NOTHING" );
			int opt = Integer.parseInt(str);
		switch (opt)
		{
		case 1:
			// OPEN FANMODE
			this.setFan(true);
			JOptionPane.showMessageDialog(null, "Fan mode is on");
			break;
		case 2:
			// DISABLE FANMODE
			this.setFan(false);
			JOptionPane.showMessageDialog(null, "Fan mode is off");
			
			break;
		case 3: 
			// SET TIMER
			String mingen = JOptionPane.showInputDialog("TO SET AC TIMER"
					+ " \nENTER MINUTES");
			int min = Integer.parseInt(mingen);
			
			String hrgen = JOptionPane.showInputDialog("TO SET AC TIMER"
					+ "\nENTER HOURS");
			int hr = Integer.parseInt(hrgen);
			
			this.setTimer(min, hr);
			
			JOptionPane.showMessageDialog(null, "timer is set for " + min + " Minutes" + " and" + hr + "hours");
			
			
			
			break;
		case 4:
			// check AC brand 
			JOptionPane.showMessageDialog(null, "This is a " + this.getBrand() + "Aircon" );
			break;
		case 5:
			// SET TEMPERATURE 
			String tempset = JOptionPane.showInputDialog("TO SET TEMPERATURE \nENTER TEMPERATURE");
			int temp = Integer.parseInt(tempset);
			
			JOptionPane.showMessageDialog(null, "Temperature is set for " + temp + " degree celcius");
			
			break;
		case 6:
			// CHECK TEMPERATURE
			JOptionPane.showMessageDialog(null, "Temperature is at " + this.getTemperature() + "degree celcius" );
			break;
		case 7:
			// STATIC
			JOptionPane.showMessageDialog(null, "zzzzzzzzzzzzzzzzzzzzz \nzzzzzzzzzzzzzzzzzz \nzzzzzzzzzzz \n nothing to see here");
			break;
		case 8:
			// STATIC
			JOptionPane.showMessageDialog(null, "zzzzzzzzzzzzzzzzzzzzz \nzzzzzzzzzzzzzzzzzz \nzzzzzzzzzzz \n nothing to see here");
			break;

		case 9:
			// STATIC
			JOptionPane.showMessageDialog(null, "zzzzzzzzzzzzzzzzzzzzz \nzzzzzzzzzzzzzzzzzz \nzzzzzzzzzzz \n nothing to see here");
			break;
		case 0: 
			// static
			JOptionPane.showMessageDialog(null, "zzzzzzzzzzzzzzzzzzzzz \nzzzzzzzzzzzzzzzzzz \nzzzzzzzzzzz \n nothing to see here");
			break;
			
		default:
			System.out.println("Press 1-0 only.");
			break;
		} // end of Switch(opt)
		} // end of if (Power)
	} // end of pressnumber(int)

	private String getBrand() {
		// TODO Auto-generated method stub
		return this.brand;
	}

	@Override
	public void pressPlus(int i) {
		 this.temperature += i;
		
	}

	@Override
	public void pressMinus(int i) {
		this.temperature -= i;
		
	}
}
