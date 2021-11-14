


import javax.swing.JOptionPane;


public class Radio implements RemoteControl
{
	/*fields*/ 
	private boolean Power; 
	private int volume = 0;
	private String modulation; //AM or FM
	private int freq;
	private boolean CD;
	
	private String CDplaying;
	private boolean play;
	private boolean pause;
	private boolean wifi;

	private boolean playPodcast;
	private String PodcastStatus;
	private String brand;
	
	
	/*Constructor*/
	//0. No arg Constructor
	public Radio()
	{
		this.brand = "Generic";
		Power = false;
		this.volume = 0;
		this.modulation = "Unsetted";
		this.freq = 100;
		this.CD = false;
		this.wifi = false;
		
		System.out.println("Generic brand radio is turned on");
	}
	
	
	//1.
	public Radio (String brand)
	{
		this.brand = brand;
		Power = true;
		this.volume = 0;
		this.modulation = "Unsetted";
		this.freq = 100;
		this.CD = false;
		this.wifi = false;
	}
	
	//2. 
	public Radio (boolean power, int volume, String modulation, int frequency, boolean CD, boolean wifi)
	{
		this.Power = power;
		this.volume = volume; 
		this.modulation = modulation;
		this.freq = frequency;
		this.CD = CD;
		this.wifi = wifi;
	}
	
	//3. To turn on radio just to listen to music from CD
	public Radio (int volume)
	{
		this.Power = true;
		this.volume = volume; 
		this.modulation = "0";
		this.freq = 0;
		this.CD = true;
		this.wifi = false;
	}
	
	/*MUTATOR*/
	
	public void setVolume(int Volume)
	{
		if (Power == true)
		{
			this.volume = Volume;
		}
		else 
		{
			System.out.println("Radio NEED TO BE TURNED ON BEFORE ANY CONFIGURATION!");
		}
	}
	
	public void setModulator (int Modulator)
	{
		if (Power)
		{
		if (Modulator == 1)
		{
			this.modulation = "FM";
		}
		else if (Modulator == 2)
		{
			this.modulation = "AM";
		}
		else 
		{
			System.out.println("ERROR! MODULATOR SHOULD BE 1 OR 2. 1 FOR FM, 2 FOR AM");
		}
		}
		else 
		{
			System.out.println("ERROR! CANNOT CHOOSE MODULATOR ON RADIO BECAUSE POWER IS OFF");
		}
	}
	
	public void setFreq(int Freq)
	{
		this.freq = Freq;
	}
	
	public void setCD(boolean CDexist)
	{
		//maybe add CD options? idk
		if ((CDexist == true) && (Power == true))
		{
			System.out.println("CD is inserted, play and pause button can now be operated");
			CD = true;
		}
		else if ((CDexist == false) && (Power == true))
		{
			System.out.println("CD Cannot be played because it is not inserted into Radio");
		}
		else 
		{
			System.out.println("ERROR! UNABLE TO SET CD STATUS BECAUSE POWER IS OFF");
		}
			
	}
	
	public void Play()
	
	{
		if (CD && Power)
		{
			System.out.println("Song is randomly played");
			String CDContent[] = {"Harry Styles - Watermelon Sugar", "Ariana Grande - Tattooed Heart", "You are my sunshine - Johnny Cash",
									"Katy Perry - The One That Got Away", "Lorde - Tennis Court", "La La Land - Emma Stone", "Deep Chills - Cassie X",
									"Taylor Swift - Betty's Garden"};
			int min = 0;
			int max = CDContent.length;
			System.out.println("generating random song...");
			int random_int = (int)(Math.random() * (max - min + 1) + min );
			CDplaying =  ("Playing " + CDContent[random_int]);
			play = true;
			pause = false;
		}
		
		else if (Power && (CD==false))
		{
			CDplaying = "cannot play CD because CD is not detected in radio";
		}
		else 
		{
			System.out.println("ERROR! CANNOT PLAY RADIO BECAUSE POWER IS OFF");
		}
	}
	
	public void Next()
	{
		if (CD && Power)
		{
			System.out.println("NEXT: Song is randomly played");
			String CDContent[] = {"Harry Styles - Watermelon Sugar", "Ariana Grande - Tattooed Heart", "You are my sunshine - Johnny Cash",
									"Katy Perry - The One That Got Away", "Lorde - Tennis Court", "La La Land - Emma Stone", "Deep Chills - Cassie X",
									"Taylor Swift - Betty's Garden"};
			int min = 0;
			int max = CDContent.length;
			System.out.println("NEXT: generating random song...");
			int random_int = (int)(Math.random() * (max - min + 1) + min );
			CDplaying =  ("Playing next " + CDContent[random_int]);
			play = true;
			pause = false;
		}
		
		else if (Power && (CD==false))
		{
			CDplaying = "cannot go to next song in CD because CD is not detected in radio";
		}
		else 
		{
			System.out.println("ERROR! CANNOT PLAY RADIO BECAUSE POWER IS OFF");
		}
	}
	
	public void Pause()
	{
		
		if (CD && Power)
		{
			System.out.println("Song is paused");
			CDplaying = "Paused";
			pause = true;
			play = false;
		}
		
		else if (Power && (CD==false))
		{
			CDplaying = "cannot pause CD because CD is not detected in radio";
		}
		else 
		{
			System.out.println("ERROR! CANNOT PAUSE CD BECAUSE POWER IS OFF");
		}
		
	}
	
	public void connectWiFi(Boolean wifi)
	{
		if (Power)
		{
			JOptionPane.showMessageDialog(null, "Radio is connected to wifi");
		this.wifi = wifi;
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "Cannot connect to wifi because Radio is off.");
			this.wifi = wifi;
		}
	}
	
	public void playPodcast ()
	{
		playPodcast = true;

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
			int min = 0;
			int max = podcast.length;
			System.out.println("generating random podcast...");
			int random_int = (int)(Math.random() * (max - min + 1) + min );
			PodcastStatus =  ("Playing " + podcast[random_int]);
			playPodcast = true;
			
			
	}
	
	
	
	
	
	/**methods: 
	*1. ChangeModulation() to either AM or FM
	*2. setFrequency() 
	*3. InsertCD()
	*4.	Play()
	*5. Pause()
	*6. Next()
	*7. ConnectWifi()
	*8. PlayPodcast()
	*
	*
	*4,5,6 only allowed if 3 is true
	*8 only allowed if 7 is true
	*
	*/
	
	
	
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
	

	public void VolumeDown(int volume) 
	{
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
			System.out.println("RADIO NEED TO BE TURNED ON BEFORE ANY CONFIGURATION!");
		}
		
	}
	
	
	@Override
	public void powerOn() 
	{
		Power = true;
		System.out.println("Radio is turned on");
	}
	
	@Override
	public void powerOff() 
	{
		Power = false;
		System.out.println("Radio is turned OFF");
	}
	
	@Override
	public void pressNumber(int i)
	{
		if (Power)
		{
			String str = JOptionPane.showInputDialog("RADIO IS TURNED ON"
					+ " \n1 TO CHECK MODULATION \n2 TO CHECK FREQUENCY \n3 TO CHECK BRAND "
					+ "\n4 TO CHECK INTERNET CONNECTION"
					+ "\n5 SET MODULATION "
					+ "\n6 SET FREQUENCY "
					+ "\n7 SET VOLUME"
					+ "\n8 PLAY PODCAST"
					+ "\n9  PLAY MUSIC FROM CD"
					+ "\n0 CONNECT TO WIFI");
			int opt = Integer.parseInt(str);
		switch (opt)
		{
		case 1:
			JOptionPane.showMessageDialog(null, "checking modulation");
			{
			if (modulation == "FM")
			{
				JOptionPane.showMessageDialog(null, "Radio is connected to FM station");
			}
			 
			else if (modulation == "AM")
			{
				
				JOptionPane.showMessageDialog(null, "Radio is connected to AM station");
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "modulation is not yet set");
			}
			}
			break;
		case 2:
			
			JOptionPane.showMessageDialog(null, "checking frequency....");
			JOptionPane.showMessageDialog(null, "Frequency " + getFreq());
			break;
		case 3: 
			
			JOptionPane.showMessageDialog(null, "checking brand");
			JOptionPane.showMessageDialog(null, "brand " + getBrand());
			break;
		case 4:
			
			JOptionPane.showMessageDialog(null, "Checking internet connection");
			if (this.isConnectedtoWifi())
			{
				JOptionPane.showMessageDialog(null, "Radio is connected to internet");
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Radio is not connected to the internet");
			}
			break;
		case 5:
			
			JOptionPane.showMessageDialog(null, "SETTING MODULATION");
			
			String getRadioModulation = JOptionPane.showInputDialog("SETTING MODULATION" +  
					"\nKEY IN THE MODULATION YOU WANT " + 
					"\n[1]AM \n[2]FM");
			int RadioModulation = Integer.parseInt(getRadioModulation);
			
			while (RadioModulation < 1 || RadioModulation >2 )
			{
				getRadioModulation = JOptionPane.showInputDialog("SETTING MODULATION" +  
						"\nKEY IN THE MODULATION YOU WANT " + 
						"\n[1]AM \n[2]FM");
				 RadioModulation = Integer.parseInt(getRadioModulation);
			}
			
			setModulator(RadioModulation);
			break;
		case 6:
			//set frequency
			
			JOptionPane.showMessageDialog(null, "SETTING FREQUENCY");
			
			String getRadioFrequency = JOptionPane.showInputDialog("SETTING FREQUENCY" +  
					"\nKEY IN THE FREQUENCY YOU WANT (3 DIGITS XXX) ");
			int RadioFrequency = Integer.parseInt(getRadioFrequency);
			
			while (RadioFrequency < 100 || RadioFrequency > 999 )
			{
				getRadioFrequency = JOptionPane.showInputDialog("SETTING MODULATION" +  
						"\nKEY IN THE MODULATION YOU WANT " + 
						"\n[1]AM \n[2]FM");
				RadioFrequency = Integer.parseInt(getRadioFrequency);
			}
		
			setFreq(RadioFrequency);
			JOptionPane.showMessageDialog(null, "Frequency is: " + this.getFreq());
			
		case 7:
			//set volume
			JOptionPane.showMessageDialog(null, "SETTING VOKUME");
			
			String getRadioVolume = JOptionPane.showInputDialog("SETTING VOLUME" +  
					"\nKEY IN THE FREQUENCY YOU WANT (3 DIGITS XXX) ");
			int RadioVolume = Integer.parseInt(getRadioVolume);
			
			while (RadioVolume < 0 )
			{
				getRadioVolume = JOptionPane.showInputDialog("SETTING VOLUME" +  
						"\nKEY IN THE VOLUME YOU WANT ");
				RadioVolume = Integer.parseInt(getRadioVolume);
			}
		
			setFreq(RadioVolume);
			JOptionPane.showMessageDialog(null, "V is: " + this.getVolume());
			break;
		case 8:
			//play podcast
			playPodcast();
			
			JOptionPane.showMessageDialog(null, "playing podcast... random podcast is generated");
			String playingpodcast = getPodcastStatus();
			
			JOptionPane.showMessageDialog(null, playingpodcast);
			break;
		case 9:
			//play music from CD;
			this.setCD(true);
			this.Play();
			String CDsong = this.CDplaying();
			JOptionPane.showMessageDialog(null, CDsong);
			break;
		case 0: 
			//connect to wifi
			connectWiFi(true);
			break;
			
		default:
			System.out.println("Press 1,2,3,4,5,6,7,8,0 only.");
		} // end of Switch(opt)
		} // end of if (Power)
	} // end of pressnumber(int)
	
	/*ACCESSOR*/
	
	public boolean getPower()
	{
		return Power; 
	}
	
	public int getVolume()
	{
		return volume;
	}
	
	public int getFreq()
	{
		return freq;
	}
	
	public boolean CDStatus()
	{
		return CD;
	}
	
	public String CDplaying()
	{
		return CDplaying;
	}
	
	public boolean isMusicPlaying()
	{
		return play;
	}
	
	public boolean isMusicPaused()
	{
		return pause;
	}
	
	public boolean isConnectedtoWifi()
	{
		return wifi;
	}
	
	public boolean isPodcastplaying()
	{
		return playPodcast;
	}
	
	public String getPodcastStatus()
	{
		return PodcastStatus;
	}
	
	public String getModulation()
	{
		return modulation; 
	}
	
	public String getBrand()
	{
		return brand;
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