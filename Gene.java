package clickinggame;

public class Gene {
	
	private int x;
	private int y;
	private int r;

    public Gene(int x, int y, int r) {
    	
    	this.x = Integer.valueOf(x);
    	this.y = Integer.valueOf(y);
    	this.r = Integer.valueOf(r);
    
    }
    
    public Gene(Gene g){
    	this.x = Integer.valueOf(g.getX());
    	this.y = Integer.valueOf(g.getY());
    	this.r = Integer.valueOf(g.getR());
    }
    
    public int getX(){
    	return Integer.valueOf(x);
    }
    
    public int getY(){
    	return Integer.valueOf(y);
    }
    
    public int getR(){
    	return Integer.valueOf(r);
    }
    
    public void setX(int x){
    	this.x = Integer.valueOf(x);
    }
    
    public void setY(int y){
    	this.y = Integer.valueOf(y);
    }
    
    public void setR(int r){
    	this.r = Integer.valueOf(r);
    }
    
}