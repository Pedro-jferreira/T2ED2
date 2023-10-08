package view.images;
import java.util.Objects;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Classe para organização e controle das imagens utilizadas pelo sistema.
 */
public class Images {

    public static Icon IFGoiano(){
        return new ImageIcon(Objects.requireNonNull(Images.class.getResource("IFGoiano2.png")));
    }


}
