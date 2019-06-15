package Array.Amazon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Interval {
    int buy;
    int sell;
}

class Stock {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            StocksBuySell obj = new StocksBuySell();

            obj.stockBuySell(arr, n);
            System.out.println();
        }
    }
}


/*This is a function problem.You only need to complete the function given below*/
/*
100 180 260 310 40 535 695
class Interval {
    int buy;
    int sell;
}*/
class StocksBuySell {

    // Function to find the buy and sell days and print them
    static void stockBuySell(int price[], int n) {

        // Your code here
        int lowIndex = 0;
        int highIndex = 0;
        int maxProfit = 0;
        int currProfit = 0;
        StringBuffer sb = new StringBuffer();


        for (int i = 1; i < n; i++) {
            // System.out.println("low and high"+ lowIndex + "  "+ highIndex);
            if (price[lowIndex] >= price[i]) {
                lowIndex = i;
            }

            if (price[highIndex] < price[i]) {
                highIndex = i;
            }

            if (lowIndex > highIndex) {
                //invalid case for buy and sell as we can not sell before buy
                // make sell index as current lowindex
                highIndex = lowIndex;
            }

            // now check for the profit
            currProfit = price[highIndex] - price[lowIndex];
            if (currProfit > maxProfit && ((i + 1) < n) && (price[i + 1] < price[highIndex])) {
                //set in intervals and reset all index to curr highIndex
                sb.append("(" + lowIndex + " " + highIndex + ") ");
                if ((i + 1) < n) {
                    lowIndex = highIndex = i + 1;
                }
                maxProfit = 0;
            } else if (i == n - 1) {
                if (lowIndex != highIndex) {
                    sb.append("(" + lowIndex + " " + highIndex + ") ");
                } else if (sb.toString().equals("")) {
                    sb.append("No Profit");
                }
            }
        }
        System.out.print(sb);

    }

}

