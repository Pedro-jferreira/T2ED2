package view.CustomComponents;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * Classe de customização dos JtextField.
 */
public class JtextField extends JTextField {
        private int rounded  = 20;

    private Shape shape;
    public JtextField() {
        setOpaque(false);
    }
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, getRounded(), getRounded());
        super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, getRounded(), getRounded());
    }
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, getRounded(), getRounded());
        }
        return shape.contains(x, y);
    }
    public int getRounded() {
        return rounded;
    }
    public void setRounded(int rounded) {
        this.rounded = rounded;
    }
}
