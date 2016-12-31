package pl.merskip.mathalfa.latex.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.merskip.mathalfa.base.core.Symbol;
import pl.merskip.mathalfa.base.elementary.RationalNumber;
import pl.merskip.mathalfa.base.infixparser.PostfixParser;
import pl.merskip.mathalfa.base.shared.SharedPostfixParser;
import pl.merskip.mathalfa.latex.core.RendererRegister;
import pl.merskip.mathalfa.latex.elementary.ElementaryRenderer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElementaryRendererTest {
    
    private PostfixParser parser = new SharedPostfixParser();
    private RendererRegister register = new ElementaryRenderer();
    
    private String toLatex(String plainText) {
        Symbol rootSymbol = parser.parseAndGetRootSymbol(plainText);
        return register.renderSymbol(rootSymbol);
    }
    
    @Test
    public void number_integer_returnsOnlyNumber() {
        String latex = register.renderSymbol(new RationalNumber(2, 1));
        
        assertEquals("2", latex);
    }
    
    @Test
    public void number_rationalNumber_returnsWithFrac() {
        String latex = register.renderSymbol(new RationalNumber(1, 2));
        
        assertEquals("\\frac{1}{2}", latex);
    }
    
    @Test
    public void addition_integers_returnsWithoutParentheses() {
        String latex = toLatex("1+2");
        
        assertEquals("1 + 2", latex);
    }
    
    @Test
    public void subtraction_integers_returnsWithoutParentheses() {
        String latex = toLatex("1-2");
    
        assertEquals("1 - 2", latex);
    }
    
    @Test
    public void addition_leftRationalNumber_returnsLeftWithParentheses() {
        String latex = toLatex("(1+2)+3");
        
        assertEquals("\\left( 1 + 2 \\right) + 3", latex);
    }
    
    @Test
    public void addition_rightRationalNumber_returnsRightWithParentheses() {
        String latex = toLatex("1+(2+3)");
        
        assertEquals("1 + \\left( 2 + 3 \\right)", latex);
    }
    
    @Test
    public void addition_bothRationalNumber_returnsBothWithParentheses() {
        String latex = toLatex("(1+2) + (3+4)");
    
        assertEquals("\\left( 1 + 2 \\right) + \\left( 3 + 4 \\right)", latex);
    }
    
    @Test
    @Disabled("Not implemented yet")
    public void addition_threeAdd_returnsWithoutParentheses() {
        String latex = toLatex("1+2+3");
        
        assertEquals("1 + 2 + 3", latex);
    }
}
