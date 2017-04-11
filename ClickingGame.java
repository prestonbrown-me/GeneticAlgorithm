package clickinggame;

import java.io.PrintWriter;
import java.util.*;

public class ClickingGame {
	
    public static int startGeneListSize = 10;
    public static int startPopulationSize = 10;
    public static int threshold = 1000;
        
    public static ArrayList<Chromosome> population = new ArrayList<Chromosome>();

    public static void main(String[] args) {

        for (int i = 1; i <= 1; i++) {

            for (int j = 0; j < startPopulationSize; j++) {
                population.add(new Chromosome(startGeneListSize));
            }

            boolean solutionFound = false;

            int generationCountInt = 1;

            while (generationCountInt <= threshold) {
                evaluateFitness(population);
                Collections.sort(population);
                population = cullPopulation(population);
                population = duplicatePopulation(population);
                population = mutatePopulation(population);
                System.out.println(generationCountInt);
                printApexInfo(population); 
                generationCountInt++;            
            }          
        }  
    }
    
    public static void printPopulation(ArrayList<Chromosome> p){
    	for(int chromeIterate = 0; chromeIterate < p.size(); chromeIterate++){
    		System.out.println("Creature: " + chromeIterate + "    Fitness: " + p.get(chromeIterate).getFitness());
    		for(int geneIterate = 0; geneIterate < p.get(chromeIterate).getGeneListSize(); geneIterate++){
    			System.out.println("Gene: " + geneIterate);
    			System.out.println("X: " + p.get(chromeIterate).getGeneList().get(geneIterate).getX());
    			System.out.println("Y: " + p.get(chromeIterate).getGeneList().get(geneIterate).getY());
    			System.out.println("R: " + p.get(chromeIterate).getGeneList().get(geneIterate).getR());
    			System.out.println();
    		}
    	}
    }
    
    public static boolean insideCookie(int x, int y){
        //303 is center x
        //428 is center y
        
        double xSquared = Math.pow(x - 303, 2);
        double ySquared = Math.pow(y - 428, 2);
        
        if(Math.pow(xSquared + ySquared, 1.0/2.0) <= 128){
            return true;
        } else {
            return false;
        }
        
    }
    
    public static void evaluateFitness(ArrayList<Chromosome> p){
        for(int i = 0; i < p.size(); i++){
            
            int cursorPrice = 15;
            int cursorCount = 0;
            
            int grandmaPrice = 100;
            int grandmaCount = 0;
            
            int farmPrice = 1100;
            int farmCount = 0;
            
            int cookiesClicked = 0;
        
            double cookieCount = 0.0;
            double cps = 0.0;
            
            for(int index = 0; index < p.get(i).getGeneListSize(); index++){
                for(int repeat = 0; repeat < p.get(i).getGeneList().get(index).getR(); repeat++){
                
                    int clickLocX = p.get(i).getGeneList().get(index).getX();
                    int clickLocY = p.get(i).getGeneList().get(index).getY();
                
                    if(insideCookie(clickLocX, clickLocY)){
                        cookieCount++;
                        cookiesClicked++;
                    }
                
                    if((clickLocX > 1619) && (clickLocX < 1619 + 300) && (clickLocY > 286) && (clickLocY < 286 + 64) && (cookieCount >= cursorPrice)){
                        cookieCount -= cursorPrice;
                        cps += .1;
                        cursorCount++;
                        cursorPrice = (int)Math.nextUp(cursorPrice*1.15);
                    }
                    if((clickLocX > 1619) && (clickLocX < 1619 + 300) && (clickLocY > 350) && (clickLocY < 350 + 64) && (cookieCount >= grandmaPrice)){
                        cookieCount -= grandmaPrice;
                        cps += 1;
                        grandmaCount++;
                        grandmaPrice *= (int)Math.nextUp(cursorPrice*1.15);
                    }
                    if((clickLocX > 1619) && (clickLocX < 1619 + 300) && (clickLocY > 414) && (clickLocY < 414 + 64) && (cookieCount >= farmPrice)){
                        cookieCount -= farmPrice;
                        cps += 8;
                        farmCount++;
                        farmPrice *= (int)Math.nextUp(cursorPrice*1.15);
                    } 
                }              
            cookieCount += cps * (double)p.get(i).getGeneList().get(index).getR();           
            }
            
            cookieCount += cps*10;
            
            population.get(i).setFitness((int)cookieCount);
            population.get(i).setCookieCount((int)cookieCount);
            population.get(i).setCookieClicks(cookiesClicked);
            population.get(i).setCPS(cps);
            population.get(i).setCursorCount(cursorCount);
            population.get(i).setGrandmaCount(grandmaCount);
            population.get(i).setFarmCount(farmCount);
  
        }
    }
    
    public static void printFitnesses(ArrayList<Chromosome> p){
    	for(int chromeIterate = 0; chromeIterate < p.size(); chromeIterate++){
    		System.out.println("Creature: " + chromeIterate);
    		System.out.println("ID: " + p.get(chromeIterate));
    		System.out.println("Fitness: " + p.get(chromeIterate).getFitness());
                System.out.println("Cookies: " + p.get(chromeIterate).getCookieCount());
                System.out.println("Cookies Clicked: " + p.get(chromeIterate).getCookieClicks());
                System.out.println("CPS: " + p.get(chromeIterate).getCPS());
    		System.out.println("Chromosome Size: " + p.get(chromeIterate).getGeneListSize());
                System.out.println("Cursors: " + p.get(chromeIterate).getCursorCount());
                System.out.println("Grandmas: " + p.get(chromeIterate).getGrandmaCount());
                System.out.println("FarmCount: " + p.get(chromeIterate).getFarmCount());
    		System.out.println();
    	}
    }
    
    
    //Fix to print properly again.
    public static void printApexInfo(ArrayList<Chromosome> p){
        System.out.println("ID: " + p.get(0));
    	System.out.println("Fitness: " + p.get(0).getFitness());
        System.out.println("Cookies: " + p.get(0).getCookieCount());
        System.out.println("Cookies Clicked: " + p.get(0).getCookieClicks());
        System.out.println("CPS: " + p.get(0).getCPS());
        System.out.println("Chromosome Size: " + p.get(0).getGeneListSize());
        System.out.println("Cursors: " + p.get(0).getCursorCount());
        System.out.println("Grandmas: " + p.get(0).getGrandmaCount());
        System.out.println("FarmCount: " + p.get(0).getFarmCount());
        System.out.println();
    }
    
    public static ArrayList<Chromosome> cullPopulation(ArrayList<Chromosome> p){
    	
    	int removeLimit = Integer.valueOf(p.size())/2;
    	
    	for(int i = 0; i < removeLimit; i++){
    		p.remove(p.size()-1);
    	}	
    	return p;	
    }
    
    public static ArrayList<Chromosome> duplicatePopulation(ArrayList<Chromosome> p){
    	int setSize = Integer.valueOf(p.size());
    	for(int i = 0; i < setSize; i++){
    		p.add(new Chromosome(p.get(i).getGeneList(), Double.valueOf(p.get(i).getFitness()), Integer.valueOf(p.get(i).getCookieCount())));
    	}
    	return p;
    }
    
    public static ArrayList<Chromosome> mutatePopulation(ArrayList<Chromosome> p){
    	for(int i = 0; i <= p.size()/2-1; i++){
    		p.get(i).mutateChromosome();
    	}
    	
    	return p;
    	
    }
    
    
}
