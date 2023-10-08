package view.CustomComponents;

import java.awt.Color;
import java.awt.Font;

/**
 * Classe de customização de fontes e cores utilizadas nas telas.
 */
public class FontPaletas {
    public static Font font1(){return new Font("Broadway", Font.PLAIN, 50);}
    public static Font font2(){return new Font("Century Gothic", Font.BOLD, 16);}
  
    public static Color color1(){return new Color(27,27,47);} 
    public static Color white(){return new Color(255,255,255);} 
    public static Color red(){return new Color(247,43,42);}  
    public static Color lightGray(){return new Color(192, 192, 192);}
    public static Color black(){return new Color(0,0,0);}
    public static Color darkGray(){return new Color(64,64,64);}
    public static Color darkGreen(){return new Color(85,122,70);}
}
