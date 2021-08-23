package DataStructures.HashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = n / 2;

        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) matrix[i][j] = '*';
                else if (i == n -j - 1) matrix[i][j] = '*';

                else if (i == k){
                    for (int l = 0; l < n; l++) {
                        matrix[i][l] = '*';
                    }
                }
                else if (j == k) matrix[i][j] = '*';
                else matrix[i][j] = '.';
            }
        }

        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }

    private static void timeProgram() {
        final long startTime = System.currentTimeMillis();
        final long endTime = System.currentTimeMillis();


        System.out.println(endTime - startTime);
    }

    public static void testSameHash(String[] args) {


        HashMap<String, Integer> map = new HashMap();

        List list = generateN(3);
        int n = 0;
        for (Object obj : list){
            map.put((String) obj, n);
            n++;
        }
        System.out.println(map.size());
        map.print();

        map.remove("AaBBBB");
        map.remove("BBAaBB");
        System.out.println(map.size());
        map.print();
    }
    private static String[] base = new String[] {"Aa", "BB"};

    public static List<String> generateN(int n)
    {
        if(n <= 0)
        {
            return null;
        }

        List<String> list = generateOne(null);
        for(int i = 1; i < n; ++i)
        {
            list = generateOne(list);
        }

        return list;
    }


    public static List<String> generateOne(List<String> strList)
    {
        if((null == strList) || (0 == strList.size()))
        {
            strList = new ArrayList<String>();
            for(int i = 0; i < base.length; ++i)
            {
                strList.add(base[i]);
            }

            return strList;
        }

        List<String> result = new ArrayList<String>();

        for(int i = 0; i < base.length; ++i)
        {
            for(String str: strList)
            {
                result.add(base[i]  + str);
            }
        }

        return result;
    }
}
