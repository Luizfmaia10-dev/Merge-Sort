import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array= {3,4,6,9,11,17,2,1};
        mergesort(array,0,array.length);
        System.out.println(Arrays.toString(array));
    }
    public static void mergesort(int[] array,int inicio,int fim){
        if(fim-inicio>1){
            int meio=(fim+inicio)/2;
            mergesort(array,inicio,meio);
            mergesort(array,meio,fim);
            merge(array,inicio,meio,fim);
        }
    }
    public static void merge(int[] array,int inicio,int meio,int fim){
        int[] esquerda= Arrays.copyOfRange(array,inicio,meio);
        int [] direito= Arrays.copyOfRange(array,meio,fim);
        int topoEsquerda=0;
        int topoDireito=0;
        for(int i=inicio;i<fim;i++){
            if(topoEsquerda >= esquerda.length){
                array[i] = direito[topoDireito];
                topoDireito++;
            } else if (topoDireito>= direito.length) {
                array[i] = esquerda[topoEsquerda];
                topoEsquerda++;

            }
            else if(esquerda[topoEsquerda]<direito[topoDireito]){
                array[i] = esquerda[topoEsquerda];
                topoEsquerda++;
            }else {
                array[i] = direito[topoDireito];
                topoDireito++;
            }
        }
    }
}
