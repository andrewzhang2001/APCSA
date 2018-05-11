package adamTowerDefense;

public abstract class DamagingBuilding extends Building{
	protected int DMG;
	protected int range;
	protected boolean isShooting;
	protected int reloadCounter;
	public DamagingBuilding(int r, int c, int hp, int DMG, int range){
		super(r,c,hp);
		this.DMG=DMG;
		this.range=range;
		reloadCounter = 1000;
	}
	public void setDMG(int dmg){
		DMG = dmg;
	}
	public int getRange(){
		return range;
	}
	public int getDMG(){
		return DMG;
	}
	public int getRC(){
		return reloadCounter;
	}
	public void setRC(int v ){
		reloadCounter = v;
	}
}
