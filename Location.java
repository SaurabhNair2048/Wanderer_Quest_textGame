package gameCharacterCreation;

public final class Location {
	
	private int x;
	private int y;
	
	Location()
	{
		this.x = 0;
		this.y = 0;
	}

	public final void setX(int x) {
		this.x += x;
		if(this.x > 100)
		{
			this.x = 100;
		}
		else if(this.x < 0)
		{
			this.x = 0;
		}
	}

	public final void setY(int y) {
		this.y += y;
		if(this.y > 100)
		{
			this.y = 100;
		}
		else if(this.y < 0)
		{
			this.y = 0;
		}
	}

	public final int getX() {
		return x;
	}

	public final int getY() {
		return y;
	}
	
	

}
