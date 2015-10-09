/*
 * Daily programmer challenge #235 easy
 */
package challenge235easy;

import java.util.*;

public class RuthAaronCalc {
    private List<Integer> prime, prime2;
    private List<Integer> div, div2;
    
    Scanner scanner;
    
    public RuthAaronCalc() {
        
        int input = readIntegers();
        List<Integer> testList = new ArrayList<>(calcPrime(input));
        int input2 = readIntegers();
        List<Integer> testList2 = new ArrayList<>(calcPrime(input2));
        System.out.printf("All the prime factors: %s", testList);
        System.out.printf("\nHow many items in the list: %d", testList.size());
        System.out.printf("\nAll the prime factors: %s", testList2);
        System.out.printf("\nHow many items in the list: %d", testList2.size());
        
        System.out.println();
        System.out.println();
        
        List<Integer> div = calcDiv(testList, input);
        List<Integer> div2 = calcDiv(testList2, input2);
        System.out.printf("\nPrime factors list: %s", div);
        System.out.printf("\nPrime factors list: %s", div2);
        
        System.out.println();
        System.out.println();
        System.out.printf("(%d, %d ) %b ", input, input2, calcRuthAaron(div,div2));
        
    }
    
    public static void main (String[] args) {
        new RuthAaronCalc();
    }
    
    public List<Integer> calcPrime(int number) {
        
        prime = new ArrayList<>();
        
        if ( number > 2 ) {
            prime.add(2);
        }
        
        for (int count = 2; count <= number; count++ ) {
            for ( int primeChecker = 1; primeChecker <= count; primeChecker += 2) {
                if ( count % primeChecker == 0) {                  
                    if ( prime.contains(primeChecker) ) {
                        break;
                    }                  
                    if ( count == primeChecker ) {
                        prime.add(count);
                    }                   
                }
            }
        }
        return prime;
    }
    
    public List<Integer> calcDiv(List<Integer> list, int input) {
        
        List<Integer> divList = new ArrayList<>();
    
        while ( input != 1 ) {
            for ( int x : list ) {
                if ( input % x == 0 ) {
                    divList.add(x);
                    input = input / x;
                    break;
                }   
            }
        }          
        return divList;
    }
    
    public boolean calcRuthAaron(List<Integer> list1, List<Integer> list2) {
        
        int sum = 0;
        int sum2 = 0;
        
        for ( int x : list1 ) {
            sum += x;
        }
        
        for ( int x : list2 ) {
            sum2 += x;
        }
        
        return sum == sum2;
    }
    
    public int readIntegers() {
        System.out.println("Typ a number");
        scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        return input;
    }
}
