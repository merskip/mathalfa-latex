package pl.merskip.mathalfa.latex;

import java.awt.*;

public class Configuration {
    
    public Color textColor;
    public Color backgroundColor;
    public Insets insets;
    public float fontSize;
    
    public Configuration() {
        textColor = new Color(0, 0, 0);
        backgroundColor = null;
        insets = new Insets(0, 0, 0, 0);
        fontSize = 32.0f;
    }
}
