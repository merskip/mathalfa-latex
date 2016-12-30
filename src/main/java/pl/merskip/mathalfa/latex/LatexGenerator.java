package pl.merskip.mathalfa.latex;

import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;
import pl.merskip.mathalfa.base.core.Symbol;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class LatexGenerator {
    
    private Configuration configuration;
    
    public LatexGenerator() {
        this(new Configuration());
    }
    
    public LatexGenerator(Configuration configuration) {
        this.configuration = configuration;
    }
    
    public String base64RenderSymbol(Symbol symbol) {
        BufferedImage image = renderSymbol(symbol);
    
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", Base64.getEncoder().wrap(outputStream));
            return outputStream.toString(StandardCharsets.UTF_8.name());
        } catch (IOException ioe) {
            throw new UncheckedIOException(ioe);
        }
    }
    
    public BufferedImage renderSymbol(Symbol symbol) {
        return renderLatex(symbol.toPlainText());
    }
    
    public BufferedImage renderLatex(String latex) {
        TeXFormula formula = new TeXFormula(latex);
    
        TeXFormula.TeXIconBuilder iconBuilder =
                formula.new TeXIconBuilder()
                        .setStyle(TeXConstants.STYLE_DISPLAY)
                        .setSize(configuration.fontSize);
        
        TeXIcon icon = iconBuilder.build();
        if (configuration.insets != null) {
            icon.setInsets(configuration.insets);
        }
    
        int iconWidth = icon.getIconWidth();
        int iconHeight = icon.getIconHeight();
        BufferedImage image = new BufferedImage(iconWidth, iconHeight, BufferedImage.TYPE_INT_ARGB);
        
        Graphics2D graphics = image.createGraphics();
        if (configuration.backgroundColor != null) {
            graphics.setColor(configuration.backgroundColor);
            graphics.fillRect(0, 0, iconWidth, iconHeight);
        }
        
        JLabel abstractLabel = new JLabel();
        if (configuration.textColor != null) {
            abstractLabel.setForeground(configuration.textColor);
        }
        
        icon.paintIcon(abstractLabel, graphics, 0, 0);
        return image;
    }
}
