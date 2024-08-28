package es.studium.Gauss;

import java.util.Random;

import org.apache.commons.math3.special.Erf;

public class Gauss
{
	public static void main(String[] args) 
	{
        int start = 0;
        int end = 20;
        double[] results = calculateGaussFunction(start, end);

        for (int i = start; i <= end; i++) 
        {
        	System.out.print(results[i - start]+",");
        }
        for (int i = end; i >= start; i--) 
        {
        	System.out.print(results[i - start]+",");
        }
    }

    public static double[] calculateGaussFunction(int start, int end) 
    {
    	Random aleatorio = new Random();
    	int valorReferencia = aleatorio.nextInt(55)-10;
        int size = end - start + 1;
        double[] results = new double[size];

        for (int i = start; i <= end; i++) 
        {
            results[i - start] = gaussFunction(i)*10+valorReferencia;
        }

        return results;
    }

    public static double gaussFunction(double x) 
    {
        // La función de Gauss es la función de error complementaria
        return 0.5 * (1 + Erf.erf(x / Math.sqrt(2)));
    }
}