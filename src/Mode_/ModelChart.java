
package Mode_;

import java.awt.Color;

/**
 *
 * @author HP
 */
public class ModelChart {

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(double value) {
        this.value = value;
    }

    public ModelChart(Color color, String title, double value) {
        this.color = color;
        this.title = title;
        this.value = value;
    }

    public ModelChart() {
    }
    
    private Color color;
    private String title;
    private double value;
    
}
