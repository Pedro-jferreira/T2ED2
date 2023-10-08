package view.CustomComponents;
import javax.swing.*;
import java.awt.*;

/**
 * Classe de customização dos botões utilizados no sistema.
 */
public class Jbutton extends JButton {
    private Color background, clicked, entered;
    private int rounded = 20;

    public Jbutton(String text, Icon icon) {
        super(text, icon);
        setConfig();
    }

    public Jbutton(String text) {
        super(text);
        setConfig();
    }

    public Jbutton(Icon icon) {
        super(icon);
        setConfig();
    }

    public Jbutton() {
        setConfig();

    }

    private void setConfig() {
        setContentAreaFilled(false);
        setColors(FontPaletas.lightGray());
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setFont(FontPaletas.font2());
    }

    public void setColors(Color background) {
        this.background = background;
        float[] hsbValues = Color.RGBtoHSB(background.getRed(), background.getGreen(), background.getBlue(), null);
        float brightness = hsbValues[2];
        Color entered = Color.getHSBColor(hsbValues[0], hsbValues[1], Math.min(brightness + 0.2f, 1.0f));
        Color clicked = background.darker();
        
        this.entered = entered;
        this.clicked = clicked;
        setBackground(background);
    }

    public Color getBackground() {
        return background;
    }

    public void setBackground(Color background) {
        this.background = background;
    }

    public Color getClicked() {
        return clicked;
    }

    public void setClicked(Color clicked) {
        this.clicked = clicked;
    }

    public Color getEntered() {
        return entered;
    }

    public void setEntered(Color entered) {
        this.entered = entered;
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, width - 2, height - 2, getRounded(), getRounded());

        super.paintComponent(g);
    }

    public int getRounded() {
        return rounded;
    }

    public void setRounded(int rounded) {
        this.rounded = rounded;
    }

}
