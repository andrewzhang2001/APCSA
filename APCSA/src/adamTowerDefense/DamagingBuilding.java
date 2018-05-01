package adamTowerDefense;

public abstract class DamagingBuilding extends Building{
	protected int DMG;
	protected int range;
	public DamagingBuilding(int r, int c, int hp, int DMG, int range){
		super(r,c,hp);
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
