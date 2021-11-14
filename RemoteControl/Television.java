import javax.swing.JOptionPane;

public class Television implements RemoteControl

{
	/*FIELDS*
	 */
	private int Channel ; //3 digits and must begin with 1
	private boolean Power; 
	private int volume = 0;
	String brand;
	private boolean wifi;
	
	/*Constructor*/
	
	public Television(String brand)
	{
		this.brand = brand;
		this.Channel = 111;
		this.Power = true;
		this.volume = 0;
		this.wifi = false;
	}
	
	
	public Television (int Channel, boolean Power, int volume, boolean wifi)
	{
		this.Channel = Channel;
		this.Power = false;
		this.volume = volume;
		this.wifi = wifi;
	}

	/*Mutator*/
	
	public void setChannel(int Channel) 
	{
		if (Channel >= 99 || Channel <= 999)
		{
			this.Channel = Channel;
 			System.out.println("Channel is set to " + Channel);
		}
		else 
		{
			System.out.println("fatal error in generating Television channel because it must be 3 digits and start with letter 1.");
			System.out.println("CANNOT CONFIGURE WHEN DEVICE IS OFF");
			System.out.println("Program restarting...");
			
			System.exit(0);
		}
	}
	
	public boolean validateChannel(int Channel)
	{
		if (Channel >= 99 && Channel <= 999 && Power == true)
		{
			boolean validInput = true;
			return validInput;
		}
		else 
		{
			boolean validInput = false;
			return validInput;
		}
	}
	
	public void setPower(boolean onoroff)
	{
		this.Power = onoroff;
	}
	
	public void setVolume (int Volume)
		{
			if (Power == true)
			{
				this.volume = Volume;
			}
			else 
			{
				System.out.println("TV NEED TO BE TURNED ON BEFORE ANY CONFIGURATION!");
			}
		}
	
	public void connectWiFi(Boolean wifi)
	{
		if (Power)
		{
			JOptionPane.showMessageDialog(null, "TV is connected to wifi");
		this.wifi = wifi;
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "Cannot connect to wifi because TV is off.");
			this.wifi = wifi;
		}
	}

	public void VolumeUp(int volume) 
	{
		
		//to increase volume up until the argument i
		for (int i = 0; i <= volume; i++ )
		{
			this.volume += i;
		}
		
		System.out.println("Volume is incremented by " + volume + " units...");
	}
	

	public void VolumeDown(int volume)
	{
		if (this.volume <= volume && Power == false)
		{
			System.out.println("You cannot decrement the volume lower than the TV volume");
			System.out.println("CANNOT CONFIGURE WHEN DEVICE IS OFF");
			System.exit(0);
		}
		else 
		{	
			this.volume -= volume;
			System.out.println("Volume is decremented by " + volume + " units...");
		}
	}

	@Override
	public void powerOn() 
	{
		Power = true;
		System.out.println("Television is turned on");
		
	}

	@Override 
	public void powerOff()
	{
		Power = false;
		System.out.println("Television is turned off");
	}

	
	/*Accesor*/
	
	public int getChannel()
	{
		return Channel;
	}
	
	public boolean getPower()
	{
		return Power;
	}
	
	public int getVolume()
	{
		return this.volume;
	}
	
	public boolean getWifi()
	{
		return this.wifi;
	}
	
	/*toString*/
	
	public String toString()
	{
		return  ( "Television is"  + getPower() + 
				"\nTelevision is on the channel" + getChannel() +
				"\n Television is at volume " + getVolume() + 
				"n Television is connected to wifi(true or not): " + getWifi() );
				
	}


	@Override
	public void pressNumber(int i)
	{
		setPower(true);
		if (Power)
		{
			String str = JOptionPane.showInputDialog("TV IS TURNED ON "
					+ " \n1 OPEN CHANNEL 101 "
					+ "\n2 OPEN CHANNEL 202 "
					+ "\n3 OPEN CHANNEL 303 "
					+ "\n4 WHAT IS MY TV BRAND"
					+ " \n5 CONNECT TV TO WIFI "
					+ "\n6 PLAY MUSIC "
					+ "\n7 SETV TV VOLUME NUMERICALLY"
					+ "\n8 PLAY PODCAST"
					+ "\n9 CHECK INTERNEY CONNECTION "
					+ "\n0 Nothing" );
			int opt = Integer.parseInt(str);
		switch (opt)
		{
		case 1:
			// set channel to 101
			this.setChannel(101);
			JOptionPane.showMessageDialog(null, "Tv Channel is now " + getChannel());
			break;
		case 2:
			// set channel to 202
			this.setChannel(202);
			JOptionPane.showMessageDialog(null, "Tv Channel is now " + getChannel());
			break;
		case 3: 
			// set channel to 303
			this.setChannel(303);
			JOptionPane.showMessageDialog(null, "Tv Channel is now " + getChannel());
			break;
		case 4:
			// check tv brand 
			JOptionPane.showMessageDialog(null, this.getBrand());
			break;
		case 5:
			// connect to wifi 
			this.connectWiFi(true);
			break;
		case 6:
			// play music
			JOptionPane.showMessageDialog(null, "Playing music...");
			System.out.println("Song is randomly played");
			String CDContent[] = {"Harry Styles - Watermelon Sugar", "Ariana Grande - Tattooed Heart", "You are my sunshine - Johnny Cash",
									"Katy Perry - The One That Got Away", "Lorde - Tennis Court", "La La Land - Emma Stone", "Deep Chills - Cassie X",
									"Taylor Swift - Betty's Garden"};
			int min = 0;
			int max = CDContent.length;
			System.out.println("generating random song...");
			int random_int = (int)(Math.random() * (max - min + 1) + min );
			String CDplaying =  ("Playing " + CDContent[random_int]);
			JOptionPane.showMessageDialog(null, CDplaying);
			
			break;
		case 7:
			//checking volume
			JOptionPane.showMessageDialog(null, this.getVolume());
			break;
			
			
		case 8:
			//play podcast
			
			String podcast[] = {"Why you may be your own biggest enemy - Jude Duarte, replayed from Dec 2019 ", 
					"Is DNA the future of Data Storage? TED-ED ",
					"Rich Dad, Poor Dad Revised Audiobook Podcast",
					"#ScarySunday: I was followed by an entity I thought was a man until I turned back",
					"The Future of Quantum Computing: The End of Classic Computing Encryption",
					"Quantum computing explained with a deck of cards | Dario Gil, IBM Research",
					"Becoming by Michelle Obama: Revised Audiobook Podcast",
					"In the war for information, will quantum computers defeat cryptographers? | Craig Costello",
					"A Powerful Vocalist Singer's Secret To Find Your Singing Voice ",
					"Mindfulness: What they don't tell you"};
			int min1 = 0;
			int max1 = podcast.length;
			System.out.println("generating random podcast...");
			int random_int1 = (int)(Math.random() * (max1 - min1 + 1) + min1 );
			String PodcastStatus =  ("Playing " + podcast[random_int1]);
			
			JOptionPane.showMessageDialog(null, PodcastStatus);
			break;
		case 9:
			// check internet connection 
			if (getWifi())
			{
			JOptionPane.showMessageDialog(null, "TV is connected to the internet");
			}
			else 
				JOptionPane.showMessageDialog(null, "TV is not connected to the internet");
			break;
		case 0: 
			// static
			JOptionPane.showMessageDialog(null, "zzzzzzzzzzzzzzzzzzzzz \nzzzzzzzzzzzzzzzzzz \nzzzzzzzzzzz \n nothing to see here");
			break;
			
		default:
			System.out.println("Press 1-0 only.");
		} // end of Switch(opt)
		} // end of if (Power)
	} // end of pressnumber(int)


	private Object getBrand() {
		
		return this.brand;
	}


	@Override
	public void pressPlus(int i) {
		 
		this.volume += i; 
		
	}


	@Override
	public void pressMinus(int i) {
		
		this.volume -= i; 
		
	}
}
