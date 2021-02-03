/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.*;

/**
 *
 * @author SharpSchnitzel
 */
public class StreamAPI {
    
    private static int getRandomInt(int precision) {
        return (int)(Math.random() * precision);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //preparations
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i=0; i < Math.max(7, getRandomInt(35)); i++) {
            list.add(getRandomInt(215));
        }
        
        list.add(list.get(getRandomInt(list.size() - 1)));
        list.add(list.get(getRandomInt(list.size() - 1)));       
        Collections.shuffle(list);    
        String text = Arrays.toString(list.toArray());
        System.out.println(text);
        System.out.println(new String(new char[text.length()]).replace("\0", "#"));
        //1
        System.out.println("-- distinct               | " + Arrays.toString(list.stream().distinct().toArray()));
        //2
        System.out.println("-- even within (10, 100)  | " + Arrays.toString(list.stream().filter(s -> s > 9 && s < 101 && s%2 == 0).toArray()));
        //3
        System.out.println("-- multiplied by 2:       | " + Arrays.toString(list.stream().map(s -> s*2).toArray()));
        //4 is there any way to obtain index (map, filter) :<
        System.out.println("-- first 4 elements (asc) | " + Arrays.toString(list.stream().sorted().limit(4).toArray()));
        //5
        System.out.println("-- count:                 | " + list.stream().count());
        //6
        System.out.println("-- average:               | " + (Math.round(list.stream().mapToInt(s -> s).average().getAsDouble() * 1000d)/1000d));
        
        // [146, 151, 146, 2, 175, 88, 61, 71, 151]
        // ########################################
        // -- distinct               | [146, 151, 2, 175, 88, 61, 71]
        // -- even within (10, 100)  | [88]
        // -- multiplied by 2:       | [292, 302, 292, 4, 350, 176, 122, 142, 302]
        // -- first 4 elements (asc) | [2, 61, 71, 88]
        // -- count:                 | 9
        // -- average:               | 110.111
        
    }
    
}
