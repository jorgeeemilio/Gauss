package es.studium.Gauss;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GaussChartExample extends JFrame 
{
	private static final long serialVersionUID = 1L;

	public GaussChartExample(String title, double[] data, double mean, double stdDev) 
	{
        super(title);

        // Crear el dataset
        XYSeries series = new XYSeries("Campana de Gauss");
        NormalDistribution normalDistribution = new NormalDistribution(mean, stdDev);

        for (double x : data) 
        {
            double y = normalDistribution.density(x);
            series.add(x, y);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        // Crear el gráfico
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Campana de Gauss", // Título del gráfico
                "Valor", // Etiqueta del eje X
                "Densidad", // Etiqueta del eje Y
                dataset, // Dataset
                PlotOrientation.VERTICAL, // Orientación del gráfico
                true, // Incluir leyenda
                true, // Incluir tooltips
                false // Incluir URLs
        );

        // Crear el panel del gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> {
            double[] data = new double[100];
            for (int i = 0; i < data.length; i++) 
            {
                data[i] = -3 + i * 0.06; // Generar valores entre -3 y 3
            }
            double mean = 0;
            double stdDev = 1;
            GaussChartExample example = new GaussChartExample("Campana de Gauss", data, mean, stdDev);
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}