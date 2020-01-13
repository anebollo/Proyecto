package Utilidades;

import java.util.List;

public class QuickSort {
	
	public static void QuickSort(List<Integer> a, int inicio, int fin) {

        // base case

        if (fin <= inicio || inicio >= fin) {



                   // Nada

        }



        else {

                   int pivot = a.get(inicio); // cogemos el primer elemento como pivote

                   int ini = inicio + 1; // primer elemento del array quitando el pivote

                   int aux;



                   // partition array

                   for (int j = ini; j <= fin; j++) {

                              if (pivot > a.get(j)) {



                                          // se intercambian

                                          aux = a.get(j);

                                          a.set(j, a.get(ini));

                                          a.set(ini, a.get(j));

                                          ini++; // llega a tener del tamaño del array

                              }

                   }



                   // put pivot in right position

                   a.set(inicio, a.get(ini - 1)); // llevar el pivote a la ultima posicion

                   a.set(ini - 1, pivot); //



                   // llama a la funcion del quicksort en el lado izquierdo y derecho del pivote

                   QuickSort(a, inicio, ini - 2);

                   QuickSort(a, ini, fin);

        }

}

}
