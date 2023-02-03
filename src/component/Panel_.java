
package component;

import Model_.Model_Chart;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


public class Panel_ extends javax.swing.JComponent {

  private List<Model_Chart> list = new ArrayList<>();
  
  private double BigNo;
  private double totalNo;
  private final int TOTAL = 30;
  
    public Panel_() {
        initComponents();
        setBackground(Color.white);
        setForeground(Color.white);
    }

    @Override
    public void paint(Graphics g) {
        if (isOpaque()) {
            g.setColor(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight());
        }
        Background(g);
        super.paint(g); 
        
    }
    private void Background (Graphics g){
        int width = getWidth();
        int height = getHeight()-TOTAL;
        int spc = 5;
        int size = Math.min(width, height)-spc;
        int x = (width-size)/2;
        int y = (height-size)/2;
        if (width<=0) {
            width =1;
        }
        if (height<=0) {
            height = 1;
            
        }
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
         g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (!list.isEmpty()) {
            
        }else{
            g2.setColor(new Color(200,200,200));
            g2.drawOval(x, y, size, size);
        }
        g2.dispose();
        g.drawImage(img, 0, 0, null);
    }
    
    

    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
