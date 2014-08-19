package com.gargi.graphdemo;

import java.util.ArrayList;
import java.util.List;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.*;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	
	XYMultipleSeriesDataset mDataSet;
	XYMultipleSeriesRenderer mRenderer;
	
	GraphicalView mChartView;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button tabButton = (Button)findViewById(R.id.tabbutton);
		tabButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			}
		});
		drawGraph();
	}
	
	private void showTabsActivity() {
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void createAChartEngine() {
		LinearLayout chartLayout = (LinearLayout)findViewById(R.id.achartengine);
		if(mChartView == null) {
			mChartView = ChartFactory.getBarChartView(this, mDataSet, mRenderer, Type.DEFAULT);
			chartLayout.addView(mChartView);
		}else {
			mChartView.repaint();
		}
	}
	
	private void drawGraph() {
		//createGraphView();
		drawAChartEngineGraph();
	}
	
	private void createGraphView() {
		BarGraphView barGraphView = new BarGraphView(this, 
												"");
		barGraphView.addSeries(getGraphViewSeries());
		barGraphView.setDrawValuesOnTop(true);
		barGraphView.setCustomLabelFormatter(new CustomLabelFormatter() {
			
			@Override
			public String formatLabel(double value, boolean isValueX) {
				if(!isValueX) {
					if(value/value == 1) {
						Log.i("GraphViewExample", "This is Y = "+ String.valueOf(value));
						return String.valueOf(value);
					}
				}
				return null;
			}
		});
		barGraphView.getGraphViewStyle().setGridColor(Color.WHITE);
		LinearLayout graphViewLayout = (LinearLayout)findViewById(R.id.achartengine);
		graphViewLayout.addView(barGraphView);
	}
	
	private GraphViewSeries getGraphViewSeries() {
		
		GraphViewSeries series = new GraphViewSeries(new GraphViewData[] {
				new GraphViewData(1, 10),
				new GraphViewData(2, 10)
		});
		
		return series;
	}
	
	private void drawAChartEngineGraph() {
		/*ArrayList<double[]> marksList = new ArrayList<double[]>();
		marksList.add(new double[]{100, 200, 300, 400});
		//marksList.add(new double[]{400, 500, 600});
		mDataSet = buildBarDataset(new String[]{"Test1"}, marksList );
		
		mRenderer = buildBarRenderer(new int[]{Color.BLACK});*/
		createAchartModel();
		
		createAChartEngine();
	}
	
	  /**
	   * Builds a bar multiple series dataset using the provided values.
	   *
	   * @param titles the series titles
	   * @param values the values
	   * @return the XY multiple bar dataset
	   */
	  protected XYMultipleSeriesDataset buildBarDataset(String[] titles, List<double[]> values) {
	    XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
	    int length = titles.length;
	    for (int i = 0; i < length; i++) {
	      CategorySeries series = new CategorySeries(titles[i]);
	      double[] v = values.get(i);
	      int seriesLength = v.length;
	      for (int k = 0; k < seriesLength; k++) {
	        series.add(v[k]);
	      }
	      dataset.addSeries(series.toXYSeries());
	    }
	    return dataset;
	  }

	  /**
	   * Builds a bar multiple series renderer to use the provided colors.
	   *
	   * @param colors the series renderers colors
	   * @return the bar multiple series renderer
	   */
	  protected XYMultipleSeriesRenderer buildBarRenderer(int[] colors) {
	    XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
	    renderer.setAxisTitleTextSize(16);
	    renderer.setChartTitleTextSize(20);
	    renderer.setLabelsTextSize(15);
	    renderer.setLegendTextSize(15);
	    renderer.setZoomEnabled(false);
	    int length = colors.length;
	    for (int i = 0; i < length; i++) {
	      XYSeriesRenderer r = new XYSeriesRenderer();
	      r.setColor(colors[i]);
	      renderer.addSeriesRenderer(r);
	    }
	    return renderer;
	  }
	  
	  
	  private void createAchartModel() {
		   int y[] = {25,10,15,20};
	       
	        CategorySeries series = new CategorySeries("Bar1");
	        for(int i=0; i < y.length; i++){
	            series.add("Bar"+(i+1),y[i]);
	        }
	       
	        XYMultipleSeriesDataset dataSet = new XYMultipleSeriesDataset();  // collection of series under one object.,there could any
	        dataSet.addSeries(series.toXYSeries());                            // number of series
	        
	        mDataSet = dataSet;
	       
	        //customization of the chart
	   
	        XYSeriesRenderer renderer = new XYSeriesRenderer();     // one renderer for one series
	        renderer.setColor(Color.RED);
	        renderer.setDisplayChartValues(true);
	        renderer.setChartValuesSpacing((float) 5.5d);
	        renderer.setLineWidth((float) 10.5d);   
	       
	        XYMultipleSeriesRenderer barRenderer = new XYMultipleSeriesRenderer();   // collection multiple values for one renderer or series
	        barRenderer.addSeriesRenderer(renderer);
	        barRenderer.setChartTitle("Demo Graph");
//	        mRenderer.setXTitle("xValues");
	        barRenderer.setYTitle("Marks");
	        barRenderer.setZoomButtonsVisible(false);
	        barRenderer.setZoomEnabled(false, false);
	        barRenderer.setShowLegend(true);
	        barRenderer.setShowGridX(false);      // this will show the grid in  graph
	        barRenderer.setShowGridY(true);             
//	        mRenderer.setAntialiasing(true);
	        barRenderer.setBarSpacing(.5);   // adding spacing between the line or stacks
	        //barRenderer.setApplyBackgroundColor(true);
	        //barRenderer.setBackgroundColor(Color.BLACK);
	        barRenderer.setXAxisMin(0);
//	        mRenderer.setYAxisMin(.5);
	        barRenderer.setXAxisMax(5);
	        //barRenderer.setYAxisMax(50);
	//   
	        barRenderer.setXLabels(0);
	        barRenderer.addXTextLabel(1,"Income");
	        barRenderer.addXTextLabel(2,"Saving");
	        barRenderer.addXTextLabel(3,"Expenditure");
	        barRenderer.addXTextLabel(4,"NetIncome");
	        barRenderer.setPanEnabled(false, false);    // will fix the chart position
	        barRenderer.setMargins(new int[] {0, 0, 0, 0});
	        barRenderer.setShowLegend(false);
	        barRenderer.setLabelsTextSize(25);
	        
	        mRenderer = barRenderer;
	  }

}
