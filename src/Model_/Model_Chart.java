
package Model_;

import java.awt.Color;


public class Model_Chart {

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
     * @return the number
     */
    public double getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(double number) {
        this.number = number;
    }
    private Color color;
    private String title;
    private double number;

    public Model_Chart(Color color, String title, double number) {
        this.color = color;
        this.title = title;
        this.number = number;
    }

    public Model_Chart() {
    }
    
}
