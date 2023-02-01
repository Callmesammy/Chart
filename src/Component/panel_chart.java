
package Component;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;

public class panel_chart extends JComponent{

    public List<panel_chart> list = new ArrayList<>();
    private double BigNum;
    private double TotalNum;
    private final int FINAL_NUM =30;
    
    public panel_chart() {
        setBackground(Color.red);
        setForeground(Color.WHITE);
    }
    
    
}
