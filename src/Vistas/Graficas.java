package Vistas;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author sebastian
 */

public class Graficas {
    
    //Atributos de clase
    private JFreeChart grafica;
    private XYSeriesCollection datosXY = new XYSeriesCollection();
    private DefaultCategoryDataset categoria = new DefaultCategoryDataset();    
    private String titulo, tx,ty;
    
    //constantes
    final static int LINEAL = 1;
    final static int POLAR = 2;
    final static int DISPERSION = 3;
    final static int AREA = 4;
    final static int LOGARITMICA = 5;
    final static int SERIETIEMPO = 6;
    final static int PASO = 7;
    final static int PASOAREA = 8;
    final static int BARRAS = 9;
    //-----------------------------------
    
    //Constructor
    public Graficas (int tipo, String titulo){
        this.titulo = titulo;
        tipoGrafica(tipo);
    }   
    public Graficas(int tipo, String titulo, String tx, String ty) {
        this.titulo = titulo;
        this.tx = tx;
        this.ty = ty;
        tipoGrafica(tipo);
    }
    //------------------------------------   
    
    //selecciona el tipo de grafica
    public void tipoGrafica(int tipo){        
        switch(tipo){
            case LINEAL:
                grafica = ChartFactory.createXYLineChart(titulo, tx, ty, datosXY, PlotOrientation.VERTICAL, true, true, true);
                break;
            case POLAR:
                grafica = ChartFactory.createPolarChart(titulo, datosXY, true, true, true);
                break;
            case DISPERSION:
                grafica = ChartFactory.createScatterPlot(titulo, tx, ty, datosXY, PlotOrientation.VERTICAL, true, true, true);
                break;
            case AREA:
                grafica = ChartFactory.createXYAreaChart(titulo, tx, ty, datosXY, PlotOrientation.VERTICAL, true, true, true);
                break;
            case LOGARITMICA:
                grafica = ChartFactory.createXYLineChart(titulo, tx, ty, datosXY, PlotOrientation.VERTICAL, true, true, true);
                XYPlot ejes=grafica.getXYPlot();
                NumberAxis rango = new LogarithmicAxis(ty);
                ejes.setRangeAxis(rango);
                break;
            case SERIETIEMPO:
                grafica = ChartFactory.createTimeSeriesChart(titulo, tx, ty, datosXY, true, true, true);
                break;
            case PASO:
                grafica = ChartFactory.createXYStepChart(titulo, ty, tx, datosXY, PlotOrientation.VERTICAL, true, true, true);
                break;
            case PASOAREA:
                grafica = ChartFactory.createXYStepAreaChart(titulo, tx, ty, datosXY, PlotOrientation.VERTICAL, true, true, true);
                break;
            case BARRAS:
                grafica = ChartFactory.createBarChart(titulo, tx, ty, categoria, PlotOrientation.VERTICAL, true, true, true);
                break;
                
        }            
    }
    //-------------------------------------
        
    //método que adiciona datos X, Y y luego construye grafica
    public void agregarSerieXY(String id,double [] x,double []y){
        XYSeries s = new XYSeries(id);
        int n = x.length;
        for(int i=0;i<n;i++){
            s.add(x[i],y[i]);
        }
        datosXY.addSeries(s);
    }
    //------------------------------------------
    
    //Método que agrega categorías y luego grafica
    public void agregarCategorias(double [] x,double []y){        
        int n = x.length;
        
        for(int i=0;i<n;i++){
            categoria.setValue((Number)y[i], ty, (int)x[i]);
        }
        
    }
    //--------------------------------------------
    
    //Devuelve un panel con la gráfica
    public ChartPanel obtienePanel(){
        return new ChartPanel(grafica);
    }
    //-------------------------------------
}
