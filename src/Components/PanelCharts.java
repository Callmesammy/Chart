
package Components;

import Model_.Model_Charts;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


public class PanelCharts extends javax.swing.JComponent {

  private List<Model_Charts> list = new ArrayList<>();
  
  private double BigNo;
  private double ValueNo;
  private final int TOTAL=30;
  
    public PanelCharts() {
        initComponents();
    
        setForeground(Color.white);
        setBackground(Color.white);
    }

    @Override
    public void paint(Graphics g) {
        if(isOpaque()){
            g.setColor(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight());
        }
        createShape(g);
        super.paint(g);
    }
    
    private void createShape(Graphics g){
        int width = getWidth();
        int height = getHeight()-TOTAL;
        int space = 5;
        int size = Math.min(width, height)-space;
        int x = (width-size)/2;
        int y = (height-size)/2;
        if (width<= 0) {
            width = 1;
            
        }
        if (height<=0) {
            height = 1;
        }
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (!list.isEmpty()) {
            double angle = 90;
            for(Model_Charts charts: list){
                g2.setColor(charts.getColor());
                double sz = setrectangle(charts.getValue());
                double toAngle = Addrectangle(charts.getValue(), size);
                Shape sh = addRectangleShape(angle, toAngle, sz);
                g2.fill(sh);
                g2.setComposite(AlphaComposite.Clear);
                g2.setStroke(new BasicStroke(3f));
                g2.draw(sh);
                g2.setComposite(AlphaComposite.SrcOver);
                                angle += toAngle;

            }
        }else{
            g2.setColor(new Color(200,200,200));
            g2.drawOval(x, y, size, size);
        }
        g2.dispose();
        g.drawImage(img, 0, 0, null);
    }

    private Shape addRectangleShape(double start,double end, double value){
        int width = getWidth();
        int height = getHeight()-TOTAL;
        double x = (width-value)/2;
        double y = (height-value)/2;
        Shape shape = new Arc2D.Double(x, y, value, value, start, end, Arc2D.PIE);
        return shape;
    }
    
    private double Addrectangle(double value, int size){
        double x = value*100/BigNo;
        return x *size/100;
         }
    
    private double setrectangle(double value){
        double x = value *100/ValueNo;
        return x*360/100;
    }
    
    private Point addPoint(double size, double sz){
        double x = Math.cos(Math.toRadians(size))*sz;
        double y = Math.sin(Math.toRadians(size))*sz;
        return new Point((int)x, (int)y);
    }
    private void addSHAPE(Model_Charts data){
        BigNo = Math.max(BigNo, data.getValue());
        ValueNo = 0;
        for(Model_Charts charts: list){
            ValueNo += charts.getValue();
        }
    }
    public void addShapeItem(Model_Charts data){
        list.add(data);
        addSHAPE(data);
        repaint();
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
