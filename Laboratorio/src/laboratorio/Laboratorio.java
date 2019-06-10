/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Andrés
 */
public class Laboratorio {
    // lee registro del archivo

    public static void leerRegistros() {
        double suma = 0;//Valor de la suma de goles
        double promedio = 0;//Vaslor del promedio de los goles
        double suma1 = 0;//Valor de la suma de altura
        double promedio1 = 0;//Valor del promedio de la altura
        int contador = 0;//Contador
        // 1. Se abre el archivo
        try // lee registros del archivo, usando el objeto Scanner
        {
            Scanner entrada = new Scanner(new File("Data/"
                    + "tabula-FWC_2018_Squadlists_4.csv"));

            while (entrada.hasNext()) {
                String linea = entrada.nextLine();
                //System.out.println(linea);
                ArrayList<String> linea_partes = new ArrayList<>(
                        Arrays.asList(linea.split("\\|")));

                //Transformacion de String a Doublesd de las posiciones 9 y 11
                double goals = Double.parseDouble(linea_partes.get(9));
                double heigth = Double.parseDouble(linea_partes.get(11));
                suma = suma + goals;//Acumulacion de datos de los goles
                suma1 = suma1 + heigth;//Acumulacion de datos de la altura
                contador = contador + 1;//Aumento del contador
                promedio = (suma / contador);//Suma total divido para condator
                promedio1 = (suma1 / contador);//Suma total divido para condator

            } // fin de while
            System.out.printf("El promedio de goles es %.2f\nEl "
                    + "proemdio de altura es %,2f", promedio, promedio1);
            // fin de try
        } catch (Exception e) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } // fin de catch
        // fin del metodo leerRegistros
        // cierra el archivo y termina la aplicacion

    }

}
