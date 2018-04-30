package adamTowerDefense;

public abstract class DamagingBuilding extends Building{
	protected int DMG;
	protected int range;
	public DamagingBuilding(int x, int y, int hp, int DMG, int range){
		super(x,y,hp);
		this.DMG=DMG;
		this.range=range;
	}
	public void setDMG(int dmg){
		DMG = dmg;
	}
	public int getDMG(){
		return DMG;
	}
}
