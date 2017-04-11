package clickinggame;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.math.*;

public class Chromosome implements Comparable<Chromosome> {
	
    private double fitness;
    public double getFitness(){
    	return Double.valueOf(this.fitness);
    }
    public void setFitness(double f) {
        if (f <= this.getGeneListSize()) {
            f = this.getGeneListSize();
        }
        this.fitness = Math.pow(f, 1.1) / Math.pow(this.getGeneListSize(), 0.9);
    }

    
    private int cookieCount = 0;
    public int getCookieCount() {
        return Integer.valueOf(this.cookieCount);
    }
    public void setCookieCount(int c) {
        this.cookieCount = Integer.valueOf(c);
    }
    
    
    private int cookieClicks = 0;
    public int getCookieClicks(){
        return Integer.valueOf(this.cookieClicks);
    }
    public void setCookieClicks(int cc){
        this.cookieClicks = Integer.valueOf(cc);
    }
    
    
    private double cps;
    public double getCPS(){
        return Double.valueOf(this.cps);
    }
    public void setCPS(double cp){
        this.cps = Double.valueOf(cp);
    }
        
    private int cursorCount = 0;
    public int getCursorCount(){
        return Integer.valueOf(this.cursorCount);
    }
    public void setCursorCount(int scc){
        this.cursorCount = Integer.valueOf(scc);
    }
    
    private int grandmaCount = 0;
    public int getGrandmaCount(){
        return Integer.valueOf(this.grandmaCount);
    }
    public void setGrandmaCount(int gc){
        this.grandmaCount = Integer.valueOf(gc);
    }
    
    private int farmCount = 0;
    public int getFarmCount(){
        return Integer.valueOf(this.farmCount);
    }
    public void setFarmCount(int fc){
        this.farmCount = Integer.valueOf(fc);
    }

    private ArrayList<Gene> geneList = new ArrayList<Gene>();
    public ArrayList<Gene> getGeneList() {

        ArrayList<Gene> t = new ArrayList<Gene>();

        int x = 0;
        int y = 0;
        int r = 0;

        for (int i = 0; i < geneList.size(); i++) {

            x = Integer.valueOf(geneList.get(i).getX());
            y = Integer.valueOf(geneList.get(i).getY());
            r = Integer.valueOf(geneList.get(i).getR());

            t.add(new Gene(x, y, r));
        }

        return t;
    }
    public void setGeneList(ArrayList<Gene> g){
    	this.geneList = g;
    }

    public Chromosome(ArrayList<Gene> g, double f, int c) {
    	this.geneList = g;
    	this.fitness = Double.valueOf(f);
        this.cookieCount = Integer.valueOf(c);
    }
    
    public Chromosome(int num){
    	populateChromosome(num);
    }
    
    public Chromosome(){
    	
    }
 
    public int getGeneListSize(){
    	return geneList.size();
    }
    
    public void populateChromosome(int length){
    	for(int i = 0; i < length; i++){
    		geneList.add(createNewGene());
    	}
    }
    
    public int compareTo(Chromosome that){
    	int compareFitness = (int)that.getFitness() * 1000;
    	return compareFitness - ((int)this.fitness * 1000);
    }
    
    public void addRandomGene(){
        if(this.geneList.size() > 0){
            Random rand = new Random();	
            this.geneList.add(Math.abs(rand.nextInt(this.geneList.size())), createNewGene());
        }
    }
    
    public void removeRandomGene(){
        if(this.geneList.size() > 0){
            Random rand = new Random();
            this.geneList.remove(Math.abs(rand.nextInt(this.geneList.size())));
        }
    }
    
    public void replaceRandomGene(){
        if(this.geneList.size() > 0){
            Random rand = new Random();
            this.geneList.set(Math.abs(rand.nextInt(this.geneList.size())), createNewGene());
        }
    }
    
    public Gene createNewGene(){
    	Random rand = new Random();
    	return new Gene(rand.nextInt(1680)+ 120, rand.nextInt(780) + 120, rand.nextInt(20) + 1);
    }
    
    public void mutateChromosome(){
    	Random rand = new Random();
        
        int mutateTimes = rand.nextInt(1) + 1;
        int selection;
        
        
        for (int x = 0; x <= mutateTimes; x++) {
            
            selection = rand.nextInt(5);

            switch (selection) {
                case 0:
                    removeRandomGene();

                case 1:
                    removeRandomGene();

                case 2:
                    replaceRandomGene();

                case 3:
                    replaceRandomGene();

                case 4:
                    addRandomGene();
            }
        }
    }
}