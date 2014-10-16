/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paatroco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Gustavo
 */
public class PAATroco {
    
    public static Map<Integer,Map<List, Integer>> mapa = new HashMap();
    
    
    public static int principal(int troco, List moedas){
        
        if (mapa.containsKey(troco)){
            if(mapa.get(troco).containsKey(moedas)){
                return mapa.get(troco).get(mapa);
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
        System.out.println(principal(51, moedas));
        
    }
    
}
