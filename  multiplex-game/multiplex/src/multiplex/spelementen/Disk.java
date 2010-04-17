package multiplex.spelementen;

import multiplex.level.Level;

public class Disk extends DynamischObject implements IsDuwbaar, KanVallen {
	public Disk(Level level)
	{
		super(level);
	}

	@Override
	public void duw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void val() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isOpBodem() {
		return true;
	}

	@Override
	public boolean isVallend() {
		return false;
	}
}
