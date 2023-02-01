
package Model_pane;

import java.awt.Color;

/**
 *
 * @author HP
 */
public class ModelCompoent {

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
     * @return the num
     */
    public Double getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(Double num) {
        this.num = num;
    }
   private Color color;
    private String name;
    private Double num;

    public ModelCompoent(Color color, String name, Double num) {
        this.color = color;
        this.name = name;
        this.num = num;
    }

    public ModelCompoent() {
    }
    
    
    
}
