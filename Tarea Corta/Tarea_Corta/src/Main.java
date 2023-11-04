import java.io.*;
import java.util.LinkedList;
import java.util.Random;

public class Main {

    //instancia de random
    private final Random random = new Random();

    //array de 10.000 elementos
    private int[] arrayDiezMil = new int[10000];
    private int[] arrayDiezMilCopia = new int[10000];

    //array de 100.000 elementos
    private int[] arrayCienMil = new int[100000];
    private int[] arrayCienMilCopia = new int[100000];

    //array de 1000.000 elementos
    private int[] arrayMillon = new int[1000000];
    private int[] arrayMillonCopia = new int[1000000];

    //instancias de los algoritmos de ordenamiento
    private SelectionSort_Algoritmo selectionSortAlgoritmo = new SelectionSort_Algoritmo();
    private BubbleSort_Algoritmo bubbleSortAlgoritmo = new BubbleSort_Algoritmo();
    private InsertionSort_Algoritmo insertionSortAlgoritmo = new InsertionSort_Algoritmo();
    private ShellSort_Algoritmo shellSortAlgoritmo = new ShellSort_Algoritmo();
    private MergeSort_Algoritmo mergeSortAlgoritmo = new MergeSort_Algoritmo();
    private QuickSort_Algoritmo quickSortAlgoritmo = new QuickSort_Algoritmo();
    private RadixSort_Algoritmo radixSortAlgoritmo = new RadixSort_Algoritmo();

    //listas para almacenar los tiempos de ordenamiento
    //[largo de la lista][tiempo por ciclo]
    private final float[][] listaTiemposSelection = new float[3][15];
    private final float[][] listaTiemposBubble = new float[3][15];
    private final float[][] listaTiemposInsertion = new float[3][15];
    private final float[][] listaTiemposShell = new float[3][15];
    private final float[][] listaTiemposMerge = new float[3][15];
    private final float[][] listaTiemposQuick = new float[3][15];
    private final float[][] listaTiemposRadix = new float[3][15];



    public static void main(String [] args){

        Main main = new Main();
        main.ejecutarPruebaRendimiento();

    }

    public void ejecutarPruebaRendimiento(){

        //asignar elementos al array de 10.000
        rellenarArrays(arrayDiezMil);

        //asignar elementos al array de 100.000
        rellenarArrays(arrayCienMil);

        //asignar elementos al array de 1000.000
        rellenarArrays(arrayMillon);

        //guardar el valor actual de los arrays para no cambiar los elementos que almacenan las listas
        arrayDiezMilCopia = arrayDiezMil;
        arrayCienMilCopia = arrayCienMil;
        arrayMillonCopia = arrayMillon;

        //algoritmo selection sort-------------------------
        selectionSort();

        //desordenar los elementos ordenados de los arrays
        arrayDiezMil = arrayDiezMilCopia;
        arrayCienMil = arrayCienMilCopia;
        arrayMillon = arrayMillonCopia;

        //algortmo bubble sort---------------------------
        bubbleSort();

        //desordenar los elementos ordenados de los arrays
        arrayDiezMil = arrayDiezMilCopia;
        arrayCienMil = arrayCienMilCopia;
        arrayMillon = arrayMillonCopia;

        //algoritmo insertion sort------------------------
        insertionSort();

        //desordenar los elementos ordenados de los arrays
        arrayDiezMil = arrayDiezMilCopia;
        arrayCienMil = arrayCienMilCopia;
        arrayMillon = arrayMillonCopia;

        //algoritmo shell sort-----------------------
        shellSort();

        //desordenar los elementos ordenados de los arrays
        arrayDiezMil = arrayDiezMilCopia;
        arrayCienMil = arrayCienMilCopia;
        arrayMillon = arrayMillonCopia;

        //algoritmo merge sort-------------------------
        mergeSort();

        //desordenar los elementos ordenados de los arrays
        arrayDiezMil = arrayDiezMilCopia;
        arrayCienMil = arrayCienMilCopia;
        arrayMillon = arrayMillonCopia;

        //algoritmo quick sort-----------------------
        quickSort();

        //desordenar los elementos ordenados de los arrays
        arrayDiezMil = arrayDiezMilCopia;
        arrayCienMil = arrayCienMilCopia;
        arrayMillon = arrayMillonCopia;

        //radix sort-------------------------------------
        radixSort();

    }

    private void selectionSort(){

        System.out.println("selection sort diez mil");

        //for para diez mil elementos
        for(int i = 0;i < 15;i++){

            //tiempo inicial para la prueba
            long inicio = System.nanoTime();

            //algoritmo a testear
            selectionSortAlgoritmo.sort(arrayDiezMil);

            //tiempo final para la prueba
            long fin = System.nanoTime();

            //duracion de la prueba
            long result = fin - inicio;

            //duracion en milisegundos de la prueba
            float tiempo = (float) (result / 1e6);

            listaTiemposSelection[0][i] = tiempo;

            System.out.println(tiempo + " ms");

        }

        System.out.println("selection sort cien mil");

        //for para cien mil elementos
        for(int i = 0; i < 15;i++){

            //tiempo inicial para la prueba
            long inicio = System.nanoTime();

            //algoritmo a testear
            selectionSortAlgoritmo.sort(arrayCienMil);

            //tiempo final para la prueba
            long fin = System.nanoTime();

            //duracion de la prueba
            long result = fin - inicio;

            //duracion en milisegundos de la prueba
            float tiempo = (float) (result / 1e6);

            listaTiemposSelection[1][i] = tiempo;

            System.out.println(tiempo + " ms");

        }

        System.out.println("selection sort millon");

        //for para millon de elementos
        for(int i = 0; i < 15;i++){

            //tiempo inicial para la prueba
            long inicio = System.nanoTime();

            //algoritmo a testear
            selectionSortAlgoritmo.sort(arrayMillon);

            //tiempo final para la prueba
            long fin = System.nanoTime();

            //duracion de la prueba
            long result = fin - inicio;

            //duracion en milisegundos de la prueba
            float tiempo = (float) (result / 1e6);

            listaTiemposSelection[2][i] = tiempo;

            System.out.println(tiempo + " ms");

        }

        try {
            FileWriter fw = new FileWriter("C:\\Users\\josth\\OneDrive\\Escritorio\\Tarea Corta\\Tarea_Corta\\Resultados.txt",true);
            PrintWriter pw = new PrintWriter(fw);

            for(int i = 0; i < 3; i++){

                for (int j = 0; j < 15;j++){

                    pw.print(listaTiemposSelection[i][j]);
                    if(i < 14){

                        pw.print("||");

                    }

                }

                pw.println();

            }

            pw.close();

        }catch (IOException e){
            throw new RuntimeException(e);
        }


    }

    private void bubbleSort(){

        System.out.println("bubble sort diez mil");

        //for para diez mil elementos
        for(int i = 0;i < 15;i++){

            //tiempo inicial para la prueba
            long inicio = System.nanoTime();

            bubbleSortAlgoritmo.bubbleSort(arrayDiezMil);

            //tiempo final para la prueba
            long fin = System.nanoTime();

            //duracion de la prueba
            long result = fin - inicio;

            //duracion en milisegundos de la prueba
            float tiempo = (float) (result / 1e6);

            listaTiemposBubble[0][i] = tiempo;

            System.out.println(tiempo + " ms");

        }

        System.out.println("bubble sort cien mil");

        //for para cien mil elementos
        for(int i = 0; i < 15;i++){

            //tiempo inicial para la prueba
            long inicio = System.nanoTime();

            //algoritmo a testear
            bubbleSortAlgoritmo.bubbleSort(arrayCienMil);

            //tiempo final para la prueba
            long fin = System.nanoTime();

            //duracion de la prueba
            long result = fin - inicio;

            //duracion en milisegundos de la prueba
            float tiempo = (float) (result / 1e6);

            listaTiemposBubble[1][i] = tiempo;

            System.out.println(tiempo + " ms");

        }

        System.out.println("bubble sort millon");

        //for para millon de elementos
        for(int i = 0; i < 15;i++){

            //tiempo inicial para la prueba
            long inicio = System.nanoTime();

            //algoritmo a testear
            bubbleSortAlgoritmo.bubbleSort(arrayMillon);

            //tiempo final para la prueba
            long fin = System.nanoTime();

            //duracion de la prueba
            long result = fin - inicio;

            //duracion en milisegundos de la prueba
            float tiempo = (float) (result / 1e6);

            listaTiemposBubble[2][i] = tiempo;

            System.out.println(tiempo + " ms");

        }

        try {
            FileWriter fw = new FileWriter("C:\\Users\\josth\\OneDrive\\Escritorio\\Tarea Corta\\Tarea_Corta\\Resultados.txt",true);
            PrintWriter pw = new PrintWriter(fw);

            for(int i = 0; i < 3; i++){

                for (int j = 0; j < 15;j++){

                    pw.print(listaTiemposBubble[i][j]);
                    if(i < 14){

                        pw.print("||");

                    }

                }

                pw.println();

            }

            pw.close();

        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }

    private void insertionSort(){

        System.out.println("insertion sort diez mil");

        //for para diez mil elementos
        for(int i = 0;i < 15;i++){

            //tiempo inicial para la prueba
            long inicio = System.nanoTime();

            insertionSortAlgoritmo.sort(arrayDiezMil);

            //tiempo final para la prueba
            long fin = System.nanoTime();

            //duracion de la prueba
            long result = fin - inicio;

            //duracion en milisegundos de la prueba
            float tiempo = (float) (result / 1e6);

            listaTiemposInsertion[0][i] = tiempo;

            System.out.println(tiempo + " ms");

        }

        System.out.println("insertion sort cien mil");

        //for para cien mil elementos
        for(int i = 0; i < 15;i++){

            //tiempo inicial para la prueba
            long inicio = System.nanoTime();

            //algoritmo a testear
            insertionSortAlgoritmo.sort(arrayCienMil);

            //tiempo final para la prueba
            long fin = System.nanoTime();

            //duracion de la prueba
            long result = fin - inicio;

            //duracion en milisegundos de la prueba
            float tiempo = (float) (result / 1e6);

            listaTiemposInsertion[1][i] = tiempo;

            System.out.println(tiempo + " ms");

        }

        System.out.println("insertion sort millon");

        //for para millon de elementos
        for(int i = 0; i < 15;i++){

            //tiempo inicial para la prueba
            long inicio = System.nanoTime();

            //algoritmo a testear
            insertionSortAlgoritmo.sort(arrayMillon);

            //tiempo final para la prueba
            long fin = System.nanoTime();

            //duracion de la prueba
            long result = fin - inicio;

            //duracion en milisegundos de la prueba
            float tiempo = (float) (result / 1e6);

            listaTiemposInsertion[2][i] = tiempo;

            System.out.println(tiempo + " ms");

        }

        try {
            FileWriter fw = new FileWriter("C:\\Users\\josth\\OneDrive\\Escritorio\\Tarea Corta\\Tarea_Corta\\Resultados.txt",true);
            PrintWriter pw = new PrintWriter(fw);

            for(int i = 0; i < 3; i++){

                for (int j = 0; j < 15;j++){

                    pw.print(listaTiemposInsertion[i][j]);
                    if(i < 14){

                        pw.print("||");

                    }

                }

                pw.println();

            }

            pw.close();

        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }

    private void shellSort(){

        System.out.println("shell sort diez mil");

        //for para diez mil elementos
        for(int i = 0;i < 15;i++){

            //tiempo inicial para la prueba
            long inicio = System.nanoTime();

            shellSortAlgoritmo.sort(arrayDiezMil);

            //tiempo final para la prueba
            long fin = System.nanoTime();

            //duracion de la prueba
            long result = fin - inicio;

            //duracion en milisegundos de la prueba
            float tiempo = (float) (result / 1e6);

            listaTiemposShell[0][i] = tiempo;

            System.out.println(tiempo + " ms");

        }

        System.out.println("shell sort cien mil");

        //for para cien mil elementos
        for(int i = 0; i < 15;i++){

            //tiempo inicial para la prueba
            long inicio = System.nanoTime();

            //algoritmo a testear
            shellSortAlgoritmo.sort(arrayCienMil);

            //tiempo final para la prueba
            long fin = System.nanoTime();

            //duracion de la prueba
            long result = fin - inicio;

            //duracion en milisegundos de la prueba
            float tiempo = (float) (result / 1e6);

            listaTiemposShell[1][i] = tiempo;

            System.out.println(tiempo + " ms");

        }

        System.out.println("shell sort millon");

        //for para millon de elementos
        for(int i = 0; i < 15;i++){

            //tiempo inicial para la prueba
            long inicio = System.nanoTime();

            //algoritmo a testear
            shellSortAlgoritmo.sort(arrayMillon);

            //tiempo final para la prueba
            long fin = System.nanoTime();

            //duracion de la prueba
            long result = fin - inicio;

            //duracion en milisegundos de la prueba
            float tiempo = (float) (result / 1e6);

            listaTiemposShell[2][i] = tiempo;

            System.out.println(tiempo + " ms");

        }

        try {
            FileWriter fw = new FileWriter("C:\\Users\\josth\\OneDrive\\Escritorio\\Tarea Corta\\Tarea_Corta\\Resultados.txt",true);
            PrintWriter pw = new PrintWriter(fw);

            for(int i = 0; i < 3; i++){

                for (int j = 0; j < 15;j++){

                    pw.print(listaTiemposShell[i][j]);
                    if(i < 14){

                        pw.print("||");

                    }

                }

                pw.println();

            }

            pw.close();

        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }

    private void mergeSort(){

        System.out.println("merge sort diez mil");

        //for para diez mil elementos
        for(int i = 0;i < 15;i++){

            //tiempo inicial para la prueba
            long inicio = System.nanoTime();

            mergeSortAlgoritmo.sort(arrayDiezMil,0,arrayDiezMil.length - 1);

            //tiempo final para la prueba
            long fin = System.nanoTime();

            //duracion de la prueba
            long result = fin - inicio;

            //duracion en milisegundos de la prueba
            float tiempo = (float) (result / 1e6);

            listaTiemposMerge[0][i] = tiempo;

            System.out.println(tiempo + " ms");

        }

        System.out.println("merge sort cien mil");

        //for para cien mil elementos
        for(int i = 0; i < 15;i++){

            //tiempo inicial para la prueba
            long inicio = System.nanoTime();

            //algoritmo a testear
            mergeSortAlgoritmo.sort(arrayCienMil,0,arrayCienMil.length - 1);

            //tiempo final para la prueba
            long fin = System.nanoTime();

            //duracion de la prueba
            long result = fin - inicio;

            //duracion en milisegundos de la prueba
            float tiempo = (float) (result / 1e6);

            listaTiemposMerge[1][i] = tiempo;

            System.out.println(tiempo + " ms");

        }

        System.out.println("merge sort millon");

        //for para millon de elementos
        for(int i = 0; i < 15;i++){

            //tiempo inicial para la prueba
            long inicio = System.nanoTime();

            //algoritmo a testear
            mergeSortAlgoritmo.sort(arrayMillon,0,arrayMillon.length - 1);

            //tiempo final para la prueba
            long fin = System.nanoTime();

            //duracion de la prueba
            long result = fin - inicio;

            //duracion en milisegundos de la prueba
            float tiempo = (float) (result / 1e6);

            listaTiemposMerge[2][i] = tiempo;

            System.out.println(tiempo + " ms");

        }

        try {
            FileWriter fw = new FileWriter("C:\\Users\\josth\\OneDrive\\Escritorio\\Tarea Corta\\Tarea_Corta\\Resultados.txt",true);
            PrintWriter pw = new PrintWriter(fw);

            for(int i = 0; i < 3; i++){

                for (int j = 0; j < 15;j++){

                    pw.print(listaTiemposMerge[i][j]);
                    if(i < 14){

                        pw.print("||");

                    }

                }

                pw.println();

            }

            pw.close();

        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }

    private void quickSort(){

        System.out.println("quick sort diez mil");

        //for para diez mil elementos
        for(int i = 0;i < 15;i++){

            //tiempo inicial para la prueba
            long inicio = System.nanoTime();

            quickSortAlgoritmo.quickSort(arrayDiezMil,0,arrayDiezMil.length - 1);

            //tiempo final para la prueba
            long fin = System.nanoTime();

            //duracion de la prueba
            long result = fin - inicio;

            //duracion en milisegundos de la prueba
            float tiempo = (float) (result / 1e6);

            listaTiemposQuick[0][i] = tiempo;

            System.out.println(tiempo + " ms");

        }

        System.out.println("quick sort cien mil");

        //for para cien mil elementos
        for(int i = 0; i < 15;i++){

            //tiempo inicial para la prueba
            long inicio = System.nanoTime();

            //algoritmo a testear
            quickSortAlgoritmo.quickSort(arrayCienMil,0,arrayCienMil.length - 1);

            //tiempo final para la prueba
            long fin = System.nanoTime();

            //duracion de la prueba
            long result = fin - inicio;

            //duracion en milisegundos de la prueba
            float tiempo = (float) (result / 1e6);

            listaTiemposQuick[1][i] = tiempo;

            System.out.println(tiempo + " ms");

        }

        System.out.println("quick sort millon");

        //for para millon de elementos
        for(int i = 0; i < 15;i++){

            //tiempo inicial para la prueba
            long inicio = System.nanoTime();

            //algoritmo a testear
            quickSortAlgoritmo.quickSort(arrayMillon,0,arrayMillon.length - 1);

            //tiempo final para la prueba
            long fin = System.nanoTime();

            //duracion de la prueba
            long result = fin - inicio;

            //duracion en milisegundos de la prueba
            float tiempo = (float) (result / 1e6);

            listaTiemposQuick[2][i] = tiempo;

            System.out.println(tiempo + " ms");

        }

        try {
            FileWriter fw = new FileWriter("C:\\Users\\josth\\OneDrive\\Escritorio\\Tarea Corta\\Tarea_Corta\\Resultados.txt",true);
            PrintWriter pw = new PrintWriter(fw);

            for(int i = 0; i < 3; i++){

                for (int j = 0; j < 15;j++){

                    pw.print(listaTiemposQuick[i][j]);
                    if(i < 14){

                        pw.print("||");

                    }

                }

                pw.println();

            }

            pw.close();

        }catch (IOException e){
            throw new RuntimeException(e);
        }


    }

    private void radixSort(){

        System.out.println("radix sort diez mil");

        //for para diez mil elementos
        for(int i = 0;i < 15;i++){

            //tiempo inicial para la prueba
            long inicio = System.nanoTime();

            radixSortAlgoritmo.radixsort(arrayDiezMil,arrayDiezMil.length);

            //tiempo final para la prueba
            long fin = System.nanoTime();

            //duracion de la prueba
            long result = fin - inicio;

            //duracion en milisegundos de la prueba
            float tiempo = (float) (result / 1e6);

            listaTiemposRadix[0][i] = tiempo;

            System.out.println(tiempo + " ms");

        }

        System.out.println("radix sort cien mil");

        //for para cien mil elementos
        for(int i = 0; i < 15;i++){

            //tiempo inicial para la prueba
            long inicio = System.nanoTime();

            //algoritmo a testear
            radixSortAlgoritmo.radixsort(arrayCienMil,arrayCienMil.length);

            //tiempo final para la prueba
            long fin = System.nanoTime();

            //duracion de la prueba
            long result = fin - inicio;

            //duracion en milisegundos de la prueba
            float tiempo = (float) (result / 1e6);

            listaTiemposRadix[1][i] = tiempo;

            System.out.println(tiempo + " ms");

        }

        System.out.println("radix sort millon");

        //for para millon de elementos
        for(int i = 0; i < 15;i++){

            //tiempo inicial para la prueba
            long inicio = System.nanoTime();

            //algoritmo a testear
            radixSortAlgoritmo.radixsort(arrayMillon,arrayMillon.length);

            //tiempo final para la prueba
            long fin = System.nanoTime();

            //duracion de la prueba
            long result = fin - inicio;

            //duracion en milisegundos de la prueba
            float tiempo = (float) (result / 1e6);

            listaTiemposRadix[2][i] = tiempo;

            System.out.println(tiempo + " ms");

        }

        try {
            FileWriter fw = new FileWriter("C:\\Users\\josth\\OneDrive\\Escritorio\\Tarea Corta\\Tarea_Corta\\Resultados.txt",true);
            PrintWriter pw = new PrintWriter(fw);

            for(int i = 0; i < 3; i++){

                for (int j = 0; j < 15;j++){

                    pw.print(listaTiemposRadix[i][j]);
                    if(i < 14){

                        pw.print("||");

                    }

                }

                pw.println();

            }

            pw.close();

        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }

    private void rellenarArrays(int[] lista){

        //long inicio = System.nanoTime();

        //for que recorre elemento  por elemento añadiendo un numero entero
        for (int i = 0; i < lista.length; i++){

            //numero aleatorio que ocupara un elemento en el array
            int numRandom = random.nextInt(5000);

            //asignar el numero random en la casilla iterada en ese momnento
            lista[i] = numRandom;

        }


    }


}
