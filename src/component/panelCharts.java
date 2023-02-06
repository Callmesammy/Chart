
package component;

import Mode_.ModelChart;
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


public class panelCharts extends javax.swing.JComponent {

   private List<ModelChart> list = new ArrayList<>();
   
   private double BigVal;
   private double valueNo;
   private final int TOTAL_NO = 30;
   
    public panelCharts() {
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
        createShape(g);
        super.paint(g); 
    }

   private void createShape (Graphics g){
       int width = getWidth();
       int height = getHeight()-TOTAL_NO;
       int space = 5;
       int size = Math.min(width, height)-space;
       int x = (width-size)/2;
       int y = (height-size)/2;
       if (width<=0) {
           width=1;
       }
       if (height<=0) {
           height=1;
       }
       BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
       Graphics2D g2 = img.createGraphics();
       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       if (!list.isEmpty()) {
           double angle = 90;
           for(ModelChart data:list){
               g2.setColor(data.getColor());
               double toAngle = getrectangleShape(data.getValue());
               double sz = addRectangleshape(data.getValue(), size);
               Shape s = getcreateShape(angle, toAngle, sz);
               g2.fill(s);
               g2.setComposite(AlphaComposite.Clear);
               g2.setStroke(new BasicStroke(3f));
             
               g2.draw(s); 
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
// adding more components for the shape ;)
    
    private Shape getcreateShape(double start, double end,double value){
        int width = getWidth();
        int height = getHeight()-TOTAL_NO;
        double x = (width-value)/2;
        double y = (height-value)/2;
        Shape shape = new Arc2D.Double(x, y, value, value, start, end, Arc2D.PIE);
        return shape;
    }
    
    private double addRectangleshape(double value, int size){
        double x = value *100/BigVal;
        return x *size/100;
    }
    
    private double getrectangleShape (double value){
        double y = value*100/valueNo;
        return y *360/100;
    }
    
    private Point addRectangleZ(double value, double sr ){
        double x = Math.cos(Math.toRadians(value))*sr;
        double y = Math.sin(Math.toRadians(value))*sr;
        return new Point((int)x, (int)y);
        
    }
    private void addShapecharts(ModelChart data){
        BigVal = Math.max(BigVal, data.getValue());
        valueNo =0;
        for(ModelChart chart: list){
            valueNo += chart.getValue();
        }
    }

    // adding of the components 
    public void addImage(ModelChart data){
        list.add(data);
        addShapecharts(data);
        repaint();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
