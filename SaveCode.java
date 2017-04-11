/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clickinggame;


/**
 *
 * @author prestonbrown
 */
public class SaveCode {
    
/*
    
    
        public static PrintWriter apexFitness;
        public static PrintWriter apexGeneSize;
        public static PrintWriter generationCount;
        public static PrintWriter apexCookies;
    
    for (int i = 1; i <= 1; i++) {
            try {
                apexFitness = new PrintWriter("apexFitness" + i + ".txt", "UTF-8");
                apexGeneSize = new PrintWriter("apexGeneSize" + i + ".txt", "UTF-8");
                generationCount = new PrintWriter("generationCount" + i + ".txt", "UTF-8");
                apexCookies = new PrintWriter("apexCookies" + i + ".txt", "UTF-8");
            } catch (Exception e) {
            }

            for (int j = 0; j < startPopulationSize; j++) {
                population.add(new Chromosome(startGeneListSize));
            }

            //printPopulation(population);
            boolean solutionFound = false;

            int generationCountInt = 1;

            while (generationCountInt < 100) {
                evaluateFitness(population);
                //printFitnesses(population);
                Collections.sort(population);
                population = cullPopulation(population);
                population = duplicatePopulation(population);
                population = mutatePopulation(population);
                for (int x = 0; x < population.size(); x++) {
                    if (population.get(x).getCookieCount() > threshold) {
                        solutionFound = true;
                    }
                }
                printApexInfo(population);
                apexCookies.write(Integer.toString(population.get(0).getCookieCount()) + "\n");
                apexFitness.write(Double.toString(population.get(0).getFitness()) + "\n");
                apexGeneSize.write(Integer.toString(population.get(0).getGeneListSize()) + "\n");
                generationCount.write(Integer.toString(generationCountInt) + "\n");
                generationCountInt++;

            }
            
            if(generationCountInt > 1000){
                apexCookies.close();
                apexFitness.close();
                apexGeneSize.close();
                generationCount.close();
                
                break;
            }
            
            //printFitnesses(population);
            apexCookies.close();
            apexFitness.close();
            apexGeneSize.close();
            generationCount.close();
            
            population.clear();
            
        }*/
    
}
