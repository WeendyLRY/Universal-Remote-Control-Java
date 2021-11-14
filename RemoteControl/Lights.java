import javax.swing.JOptionPane;

public class Lights implements RemoteControl
{
	
	private String Lamp_Color;
	private boolean Power;
	private int brightness;
	private String brand;
	
	/*CONSTRUCTOR*/
	
	public Lights ()
	{
		this.brand = "Generic";
		this.Power = false;
		this.brightness = 2;
		this.Lamp_Color = getLamp_Color();
		
	}
	
	public Lights (String brand)
	{
		this.brand = brand;
		this.Power = false;
		this.brightness = 2;
		this.Lamp_Color = getLamp_Color();
	}
	
	/*MUTATOR*/
	
	public void setBrand(String brand)
	{
		this.brand = brand;
	}
	
	public void setPower(boolean onoroff)
	{
		this.Power = onoroff;
	}
	
	public void setBrightness(int i)
	{
		this.brightness = i;
	}

	
	public void setLamp_Color(int i)
	{
		if (i == 1)
		{
			this.Lamp_Color = "white";
		}
		
		else if (i == 2)
		{
			this.Lamp_Color = "orange";
		}
		
		else if (i == 3)
		{
			this.Lamp_Color = "red";
		}
		else if (i == 4)
		{
			this.Lamp_Color = "pink";
		}
		
		else if (i == 5)
		{
			this.Lamp_Color = "purple";
		}
		
		else if (i == 6)
		{
			this.Lamp_Color = "magenta";
		}
		
		else if (i==7)
		{
			this.Lamp_Color = "cyan";
		}
		
		else if (i==8)
		{
			this.Lamp_Color = "green";
		}
		
		else if (i==9)
		{
			this.Lamp_Color = "blue";
		}
		
		else if (i==0)
		{
			this.Lamp_Color = "aquamarine";
		}
	}
	
	/*ACCESSOR*/
	
	public String getLamp_Color()
	{
		return this.Lamp_Color;
	}
	
	public String getBrand()
	{
		return this.brand;
	}
	
	
	public int getBrightness()
	{
		return brightness;
	}
	@Override
	public void powerOn() 
	{
		this.Power = true;
		pressNumber(1);
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pressNumber(int i) 
	{
	setPower(true);
	if (Power)
	{
		String str = JOptionPane.showInputDialog("\n CURRENT COLOR OF LIGHTS IS NOT SET \nWHAT LIGHTS COLOR WOULD YOU LIKE TO CHANGE TO?"
				+ " \n1 WHITE "
				+ "\n2 ORANGE "
				+ "\n3 RED "
				+ "\n4 PINK"
				+ " \n5 PURPLE "
				+ "\n6 MAGENTA"
				+ "\n7 CYAN"
				+ "\n8 GREEN"
				+ "\n9 BLUE"
				+ "\n0 AQUAMARINE" );
		int opt = Integer.parseInt(str);
	switch (opt)
	{
	case 1:
		// WHITE
		this.setLamp_Color(1);
		JOptionPane.showMessageDialog(null, "Lights Color is changed to " + getLamp_Color());
		break;
	case 2:
		// ORANGE
		this.setLamp_Color(2);
		JOptionPane.showMessageDialog(null, "Lights Color is changed to " + getLamp_Color());
		break;
	case 3: 
		// RED
		this.setLamp_Color(3);
		JOptionPane.showMessageDialog(null, "Lights Color is changed to " + getLamp_Color());
		break;
	case 4:
		// PINK
		this.setLamp_Color(4);
		JOptionPane.showMessageDialog(null, "Lights Color is changed to " + getLamp_Color());
		break;
	case 5:
		// PURPLE
		this.setLamp_Color(5);
		JOptionPane.showMessageDialog(null, "Lights Color is changed to " + getLamp_Color());
		break;
	case 6:
		// MAGENTA
		this.setLamp_Color(6);
		JOptionPane.showMessageDialog(null, "Lights Color is changed to " + getLamp_Color());
		break;
	case 7:
		// CYAN
		this.setLamp_Color(7);
		JOptionPane.showMessageDialog(null, "Lights Color is changed to " + getLamp_Color());
		break;
	case 8:
		// GREEN
		this.setLamp_Color(8);
		JOptionPane.showMessageDialog(null, "Lights Color is changed to " + getLamp_Color());
		break;

	case 9:
		// BLUE
		this.setLamp_Color(9);
		JOptionPane.showMessageDialog(null, "Lights Color is changed to " + getLamp_Color());
		break;
	case 0: 
		// AQUAMARINE
		this.setLamp_Color(0);
		JOptionPane.showMessageDialog(null, "Lights Color is changed to " + getLamp_Color());
		break;
		
	default:
		System.out.println("Press 1-0 only.");
		break;
	} // end of Switch(opt)
	} // end of if (Power)
} // end of pressnumber(int)

	@Override
	public void pressPlus(int i) {
		this.brightness += i;
		
	}

	@Override
	public void pressMinus(int i) {
		this.brightness -= i;
		
	}
	
}
