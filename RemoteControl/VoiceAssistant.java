import javax.swing.JOptionPane;

public class VoiceAssistant implements RemoteControl
{
	
	/*FIELDSS*/
	
	private boolean HeyAlexa;
	private String Quotes_Generate;
	private boolean QuotesGenerated;
	private int volume;
	private boolean songPlaying;
	private String brand = "Google";
	private String color = "rose_gold";
	private boolean Power;
	private String callStatus;
	private boolean wifi;
	
	/*CONSTRUCTOR*/
	VoiceAssistant()
	{
		this.volume = 0;
		this.Power = false;
		this.HeyAlexa = false;
	}

	VoiceAssistant(boolean Power, int volume, boolean HeyAlexa)
	{
		this.Power = Power;
		this.volume = volume; 
		this.HeyAlexa = HeyAlexa;
	}
	
	/*MUTATOR*/
	
	public void setHeyAlexa(boolean HeyAlexa)
	{
		if (Power)
		{
		this.HeyAlexa = HeyAlexa;
		}
		else 
			System.out.println("Cannot call Alexa because Assistant is switched off");
	}
	
	public void setVolume(int volume)
	{
		if (Power)
		{
			 this.volume = volume;
		}
		else 
			System.out.println("Cannot set Volume because Assistant is switched off");
		
	}
	
	public void setQuotes(boolean callquotes)
	{
		if (Power && HeyAlexa)
		{

			String quotes[] = {"The universe cannot help you unless you help yourself", 
								"What is a person, if not the marks they leave behind?",
								"Because time is cruel to all, and crueler still to artists. Because visions weakens, and voices wither, and talent fades.... Because happiness is brief, and history is lasting, and in the end... everyone wants to be remembered",
								"The little things? The little moments? They aren’t little.",
								"The best way to capture moments is to pay attention. This is how we cultivate mindfulness.",
								"To think in terms of either pessimism or optimism oversimplifies the truth. The problem is to see reality as it is.",
								"Becoming by Michelle Obama: Revised Audiobook Podcast",
								"Many people are alive but don’t touch the miracle of being alive.",
								"Blink, and the years fall away like leaves",
								"His heart has a draft. It lets in light. It lets in storms. It lets in everything."};
			int min = 0;
			int max = quotes.length;
			System.out.println("generating random quotes...");
			int random_int = (int)(Math.random() * (max - min + 1) + min );
			Quotes_Generate =  ("The Quotes Alexa chose for you: " + quotes[random_int]);
			QuotesGenerated = true;
		}
		else 
			System.out.println("Cannot call Alexa because Assistant is switched off");
	}
	
	public void setPower(boolean onoroff)
	{
		this.Power = onoroff;
	}
	

	
	public void HeyAlexa()
	{
		setHeyAlexa(true);
	}
	public void playMusic()
	{
		if (Power && HeyAlexa)
		{
			//connect to Radio 
			Radio music =  new Radio (20);
			music.Play();
			this.songPlaying = true;
		}
		
		else if ((HeyAlexa == false) && Power)
		{
			System.out.println("Call alexa first by typing HeyAlexa() to play music");
			System.exit(0);
		}
		
		else
		{
			System.out.println("Turn Voice Assitant on FIrst");
			System.exit(0);
		}
	}
	
	public void callPeople(String people)
	{
		if (Power && HeyAlexa)
		{
			callStatus = ("Calling" + people + "...");
			//In main: 
			//Generate a window that let user choose who they want to call
			//Save user's input in a variable
			//Inform user that the VoiceAssistant is calling the people.
			
		}
		
		else if ((HeyAlexa == false) && Power)
		{
			System.out.println("Call alexa first by typing HeyAlexa() to play music");
			System.exit(0);
		}
		
		else
		{
			System.out.println("Turn Voice Assitant on FIrst");
			System.exit(0);
		}
	}
	
	public void turnonTV()
	{
		Television TV1 = new Television("Generic");
		
		TV1.powerOn();
		TV1.setChannel(3);
		TV1.setVolume(30);
		
		TV1.toString();
		
	}

	
	
	/*ACCESSOR*/
	
	public String getTheQuote()
	{
		return this.Quotes_Generate;
	}
	
	public boolean getAlexa()
	{
		return this.HeyAlexa;
	}
	
	public String getQuotes_Generate()
	{
		return Quotes_Generate;
	}
	
	public int getVolume()
	{
		return volume;
	}
	
	public boolean songPlaying()
	{
		return songPlaying;
	}
	
	public boolean getPower()
	{
		return Power;
	}
	
	public boolean getStatusQuotesGenerated()
	{
		return QuotesGenerated;
	}
	
	public String getBrand()
	{
		return this.brand;
	}
	
	public String getColor()
	{
		return this.color;
	}
	
	public String getCallStatus()
	{
		return this.callStatus;
	}
	
	
	/*Volume Up and Volume Down*/
	
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
		System.out.println("Voice Assistant is turned on");
	}
	
	@Override
	public void powerOff() 
	{
		Power = false;
		System.out.println("Voice Assistant is turned on");
	}
	
	@Override
	public void pressNumber(int i)
	{
		setPower(true);
		if (Power)
		{
			String str = JOptionPane.showInputDialog("VOICE ASSISTANT IS TURNED ON "
					+ " \n1 GET THE WEATHER TODAY "
					+ "\n2 PLAY MUSIC "
					+ "\n3  GENERATE QUOTES "
					+ "\n4 PLAY PODCAST"
					+ " \n5 CALL PEOPLE"
					+ "\n6 WHAT SHOULD I COOK TODAY? "
					+ "\n7 WILL MY CRUSH EVER NOTICE ME?"
					+ "\n8 CONNECT TO WIFI"
					+ "\n9 HOW TO LEAD A MEANINGFUL LIFE?"
					+ "\n0 ALEXA ALEXA WHO IS THE PRETTIEST OF THEM ALL?" );
			int opt = Integer.parseInt(str);
		switch (opt)
		{
		case 1:
			// GET THE WEATHER TODAY
			String forecast[] = {"It is cloudy today, 30 degree celcius, with 95% chance of raining. It's time to try out some indoor zumba!", 
					"It is sunny today, 37 degree celcius, with 64% chance of raining. It's time to try out some outdoor workout!",
					"It is rainning today, 28 degree celcius, with 99% chance of raining the whole day. Say no more and wrap yourself in with a blanket and a hot cocoa!!",
					"It is going to rain heavily today, 27 degree celcius. It's time to try out some indoor yoga!",
					"It is sunny today, 36 degree celcius, with 40% chance of raining. Don't forget your sunscreen!",
					"It is misty today, 29 degree celcius, with 85% chance of raining. Oh nostalgic memories a weather can bring",
					"It is sunny today, 39 degree celcius, with 30% chance of raining. It's time to try out some outdoor yoga for this good weather!",
					"It is going to rain lightly today, 27 degree celcius. Bring an umbrella!",
					"It is going to rain heavily today, 30 degree celcius. There is no better time to hide yourself under the blanket and sleep... or I prefer Netflix",
					"It is cloudy today, 31 degree celcius, with 88% chance of raining. It's time to spend your time indoor catching up with the shows you missed."};
			int min1 = 0;
			int max1 = forecast.length;
			
			int random_int1 = (int)(Math.random() * (max1 - min1 + 1) + min1 );
			String forecastStatus =  ("Getting weather forecast....\n" + forecast[random_int1]);
			
			JOptionPane.showMessageDialog(null, forecastStatus);
			break;
		case 2:
			// PLAY MUSIC
			
			String music[] = {"I love you - Little Mix", 
					"imagine - Ariana Grande ",
					"Style - Taylor Swift",
					"Light's Up - Harry Styles ",
					"Daydreamin' - Ariana Grande",
					"Chernobyl - Alec Bailey",
					"OMG - Little Mix",
					"Break My Heart Again - Finneas",
					"Best Song Ever - One Direction ",
					"International SMile - Katy Perry "};
			int min_music = 0;
			int max_music = music.length;
			
			int random_music_pos = (int)(Math.random() * (max_music - min_music + 1) + min_music );
			String random_music =  ("Playing " + music[random_music_pos]);
			
			JOptionPane.showMessageDialog(null, random_music);
			break;
		case 3: 
			// GENERATE QUOTES
			String quotes[] = {"Dua tiga kucing berlari, Weendy comel tidak boleh nafi", 
					"Shoutout to the people who havent felt okay lately but get up everyday and refuse to quit. Stay strong.",
					"Love and kindness will always be louder",
					"I dont chase. I attract. What belongs to me will find me.",
					"Be more attracted to what's good for you",
					"Don't focus on your goals. Instead, focus on the habits that will take you to them. It's always you vs you.",
					"Trust what your soul tells you",
					"Some of you are sleeping on skills and talents that can make you a millionaire. Wake up."};
			int min_quotes = 0;
			int max_quotes = quotes.length;
			
			int random_quotes_pos = (int)(Math.random() * (max_quotes - min_quotes + 1) + min_quotes );
			String random_quotes =  ("REMINDER: " + quotes[random_quotes_pos]);
			
			JOptionPane.showMessageDialog(null, random_quotes);
			
			break;
		case 4:
			// PLAY PODCAST
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
			int min_podcast = 0;
			int max_podcast = podcast.length;
			
			int random_podcast_pos = (int)(Math.random() * (max_podcast - min_podcast + 1) + min_podcast );
			String PodcastStatus =  ("Playing " + podcast[random_podcast_pos]);
			
			JOptionPane.showMessageDialog(null, PodcastStatus);
			break;
		case 5:
			// CALL PEOPLE
			String people[] = {"Cole Sprouse +60195553333", 
					"Ariana Grande +60423045345",
					"Harry Styles +37943274",
					"Emilia Clarke +6343248325",
					"Istiqarah +84234021",
					"Weendy +384328",
					"Michelle Obama +324872384",
					"Jude Duarte +3048204",
					"Beth Harmon +32742347",
					"Ms. Sailormoon +743284"};
			int min_people = 0;
			int max_people = people.length;
			
			int random_people_pos = (int)(Math.random() * (max_people - min_people +1) + min_people );
			String callpeople =  ("calling" + people[random_people_pos]);
			
			JOptionPane.showMessageDialog(null, callpeople);
			break;
			
		case 6:
			// WHAT SHOULD I COOK TODAY?
			String recipe[] = {"Sambal Tumbuk Ikan Basung", 
					"Ikan Goreng Mangga Hancur",
					"Daun Pucuk Ubi",
					"Kuetiau Basah",
					"Salmon Fillet",
					"Sambal Goreng",
					"Tauhu Ayam",
					"Sotong Goreng",
					"Fillet Mignon Steak",
					"Sup Jagubg"};
			int min_recipe = 0;
			int max_recipe = recipe.length;
			
			int random_recipe_pos = (int)(Math.random() * (max_recipe - min_recipe) + min_recipe );
			String cookrcipe =  ("today, you should cook " + recipe[random_recipe_pos]);
			
			JOptionPane.showMessageDialog(null, cookrcipe);
			break;
		case 7:
			
			//WILL MY CRUSH EVER NOTICE ME?
			String crush[] = {"Yes, you're so pretty it hurts to look at you, of course he will.", 
					"Yes but you deserves better",
					"No but he's below your league",
					"yes queen",
					"yes yes yes ",
					"YES ",
					"DUH? look at you. you're the prettiest of the prettiest.",
					"yes",
					"yes queeeeen",
					"No but he's ugly so it's okay"};
			int min_crush = 0;
			int max_crush = crush.length;
			
			int random_crush_pos = (int)(Math.random() * (max_crush - min_crush) + min_crush );
			String crushnotice =  ("Will your crush ever notice you? to that i answer " + crush[random_crush_pos]);
			
			JOptionPane.showMessageDialog(null, crushnotice);
			break;
			
		case 8:
			//CONNECT TO WIFI
			this.setWifi(true);
			JOptionPane.showMessageDialog(null, "Voice assistant connected to wifi");
			break;
		case 9:
			// HOW TO LEAD A MEANINGFUL LIFE?
			JOptionPane.showMessageDialog(null, "By living in the present");
			break;
		case 0: 
			// ALEXA ALEXA WHO IS THE PRETTIEST OF THEM ALL?" 
			String prettiest[] = {"Weendy", 
					"Isti",
					};
			int min_prettiest = 0;
			int max_prettiest = prettiest.length;
			
			int random_prettiest_pos = (int)(Math.random() * (max_prettiest - min_prettiest) + min_prettiest );
			String whoistheprettiestdiduniaini =  ("The prettiest people in the world is: " + prettiest[random_prettiest_pos]);
			
			JOptionPane.showMessageDialog(null, whoistheprettiestdiduniaini);
			break;
		default:
			System.out.println("Press 1-0 only.");
			break;
		} // end of Switch(opt)
		} // end of if (Power)
	} // end of pressnumber(int)

	private void setWifi(boolean b) {
	
		this.wifi = b;
		
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
