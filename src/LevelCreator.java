import java.io.*;
import java.util.*;

public class LevelCreator{
    public static void main(String[] args) throws IOException{
        int inputLength = 21;
        int length = inputLength - 2;
        int height = 16;
        int startY = 1;
        int startX = 1;
        int [][] arr = new int [height][length];
        
        String str2 = "0,118,118,187,188,160,161,189,160,161,118,189,0,0,0,0,0,0,0,0,0,118,189,160,161,118,162,163,190,162,163,118,190,118,0,0,0,0,0,0,0,0,118,190,162,163,167,114,114,114,114,114,166,160,161,118,0,0,0,0,0,0,0,187,188,125,126,158,0,0,0,113,122,134,162,163,189,189,189,187,188,0,0,0,160,161,160,161,117,0,0,113,164,229,168,118,118,190,190,190,118,189,187,188,0,162,163,162,163,135,148,122,164,118,139,138,118,139,114,114,114,166,190,160,161,0,0,160,161,118,118,120,118,118,139,123,119,168,117,0,0,0,121,166,162,163,118,0,162,163,167,114,152,138,118,117,0,157,126,158,0,0,0,0,121,166,118,118,0,187,188,117,0,0,119,168,117,0,119,168,117,0,0,0,0,0,119,187,188,0,187,188,117,0,0,119,118,117,0,119,118,117,0,0,0,0,0,119,189,118,0,160,161,117,0,0,121,114,123,113,164,118,165,122,122,148,122,122,134,190,189,0,162,163,165,122,122,115,0,0,119,118,118,118,168,168,120,168,168,160,161,190,0,187,188,118,160,161,165,122,115,121,166,118,167,114,114,152,114,138,162,163,118,0,0,187,188,162,163,118,189,117,0,119,168,117,0,0,0,0,119,118,118,0,0,0,0,118,118,189,118,190,165,115,119,168,117,0,0,0,0,119,160,161,0,0,0,0,0,0,190,187,188,118,135,134,168,135,122,122,122,122,164,162,163,0,0,0,0,0,0,0,118,189,160,161,118,187,188,160,161,160,161,189,187,188,0,0,0,0,0,0,0,0,190,162,163,187,188,118,162,163,162,163,190,118,0,0";
        String str3 = "";
        String counter = "";
        ArrayList <String> list2 = new ArrayList <>();
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) == ',') {
                list2.add(counter);
                counter = "";
            } else {
                counter += str2.charAt(i);
            }
        }
        counter = "";
        ArrayList <String> list3 = new ArrayList <>();
        for (int i = 0; i < str3.length(); i++) {
            if (str3.charAt(i) == ',') {
                list3.add(counter);
                counter = "";
            } else {
                counter += str3.charAt(i);
            }
        }
        int factor = 1;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                int tile = Integer.parseInt(list2.get((i + startY) * inputLength + j + startX)) - factor;
                if (tile == 117 || (159 <= tile && tile <= 166) || (186 <= tile && tile <= 189)) {
                    arr [i][j] = 1;
                }
                if (tile == 167) {
                    arr [i][j] = 2;
                }
            }
        }
        /*factor = 1;
        HashMap <Integer, Integer> map = new HashMap <>(); 
        map.put(191, 6);
        map.put(44, 7);
        map.put(43, 8);
        map.put(42, 9);
        map.put(24, 1);
        map.put(23, 1);
        map.put(22, 1);
        map.put(21, 1);
        map.put(37, 4);
        map.put(40, 5);
        map.put(55, 10);
        map.put(54, 11);
        map.put(53, 12);
        map.put(56, 13);
        map.put(51, 20);
        map.put(50, 21);
        map.put(49, 22);
        map.put(52, 23);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                int tile = Integer.parseInt(list3.get((i + startY) * inputLength + j + startX)) - factor;
                if (map.containsKey(tile)) {
                    arr [i][j] = map.get(tile);
                }
            }
        }*/
        for (int i = 0; i < height; i++) {
            System.out.print(Arrays.toString(arr[i]).replace("]", "}, ").replace("[", "{"));
        }
    }
}
