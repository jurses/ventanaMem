package ventanaMem;

public class Color {
	private int red;
	private int green;
	private int blue;
	
	public int getRed()
	{
		return red;
	}
	
	public int getGreen()
	{
		return green;
	}
	
	public int getBlue()
	{
		return blue;
	}
	
	
	public void setRed(double red) {
		this.red = (int)(red * 255.0);
	}

	public void setGreen(double green) {
		this.green = (int)(green * 255.0);
	}

	public void setBlue(double blue) {
		this.blue = (int)(blue * 255.0);
	}
	
	public void setRed(int red) {
		this.red = red;
	}

	public void setGreen(int green) {
		this.green = green;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}

	@Override
	public String toString()
	{
		return String.format("%02X", red) + String.format("%02X", blue) + String.format("%02X", green);
	}
}
