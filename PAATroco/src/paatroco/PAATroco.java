/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paatroco;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JFileChooser;

/**
 *
 * @author Gustavo
 */
public class PAATroco {
    
    public static Map<Integer,Map<List, Integer>> mapa = new HashMap();
    public static int nos = 0;
    
    public static int principal(int troco, List moedas){
        
        if (mapa.containsKey(troco)){
            if(mapa.get(troco).containsKey(moedas)){
                return mapa.get(troco).get(moedas);
            }
        }
        
        if (moedas.isEmpty()){
            return 0;
        }
        if (troco < 0){
            return 0;
        }
        if(troco==0){
            return 1;
        }
        int moedamaior = (int) moedas.get(moedas.size()-1);
        List mantermoedas = moedas.subList(0, moedas.size()-1);
        nos++;
        int total = principal(troco-moedamaior, moedas) + principal(troco, moedas.subList(0, moedas.size()-1));
        if (mapa.containsKey(troco)){
            Map<List, Integer> valores = mapa.get(troco);
            valores.put(moedas, total);
        }
        else{
            Map<List, Integer> valores = new HashMap();
            valores.put(moedas, total);
            mapa.put(troco, valores);
        }
        return total;
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> moedas = new ArrayList();
        moedas.add(1);
        moedas.add(5);
        moedas.add(10);
        moedas.add(25);
        moedas.add(50);
        final JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(fc);
        File path = fc.getSelectedFile();
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader reader = Files.newBufferedReader(path.toPath(), charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
            System.out.println(principal(Integer.parseInt(line), moedas));
            System.out.println("Nos processados: " + nos);
        }
        } catch (IOException x) {
        System.err.format("IOException: %s%n", x);
        }       
        
    }

    
}
