/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CKY;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author leeco
 */
public class Grammar {
    public static TreeMap<Integer, ArrayList<String>> TachCuPhap(String dsCuPhap) {
        TreeMap<Integer, ArrayList<String>> grammar = new TreeMap<>();
        String[] cuPhap = dsCuPhap.split("[\n]");
        for (int j = 0; j < cuPhap.length; j++) {
            String[] dsKiTu = cuPhap[j].split("[->. ]+");
            for (int i = 0; i < dsKiTu.length; i++) {
                if (dsKiTu.length == 3) {
                    ArrayList<String> non_terminal = new ArrayList();
                    non_terminal.add(dsKiTu[0]);
                    non_terminal.add(dsKiTu[1]);
                    non_terminal.add(dsKiTu[2]);
                    grammar.put(j, non_terminal);
                } else if (dsKiTu.length == 2) {
                    ArrayList<String> terminal = new ArrayList();
                    terminal.add(dsKiTu[0]);
                    terminal.add(dsKiTu[1]);
                    grammar.put(j, terminal);
                }
            }
        }
        return grammar;
    }

    public static ArrayList<String> getTerLeft(String s, TreeMap<Integer, ArrayList<String>> grammar) {
        ArrayList<String> result = new ArrayList();
        for (ArrayList<String> al : grammar.values()) {
            if (al.size() == 2) {
                if (al.get(1).equals(s)) {
                    result.add(al.get(0));
                }
            }
        }
        return result;
    }

    public static ArrayList<String> getNonTerLeft(String s1, String s2, TreeMap<Integer, ArrayList<String>> grammar) {
        ArrayList<String> result = new ArrayList();
        for (ArrayList<String> al : grammar.values()) {
            if (al.size() == 3) {
                if (al.get(1).equals(s1) && al.get(2).equals(s2)) {
                    result.add(al.get(0));
                }
            }
        }
        return result;
    }

    public static ArrayList<String>[][] arr_Cky(int soLuongTu) {
        ArrayList<String> [][] arr = new ArrayList[soLuongTu][soLuongTu];
        for (int i = 0; i < soLuongTu; i++) {
            for (int j = 0; j < soLuongTu; j++) {
                arr[i][j] =new ArrayList();
            }
        }
        return arr;
    }

    public static String[] arr_Tu(String dsTu) {
        String[] arr = dsTu.split("[. ]+");
        return arr;
    }
    

}
