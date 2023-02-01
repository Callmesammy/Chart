
package Model_pane;

import java.awt.Color;

/**
 *
 * @author HP
 */
public class Model__chart {

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the numB
     */
    public Double getNumB() {
        return numB;
    }

    /**
     * @param numB the numB to set
     */
    public void setNumB(Double numB) {
        this.numB = numB;
    }
    private Color color;
    private String name;
    private Double numB;

    public Model__chart(Color color, String name, Double numB) {
        this.color = color;
        this.name = name;
        this.numB = numB;
    }

    public Model__chart() {
    }
    
}
