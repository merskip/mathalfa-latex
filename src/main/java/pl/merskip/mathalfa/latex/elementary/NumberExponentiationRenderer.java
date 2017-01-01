package pl.merskip.mathalfa.latex.elementary;

import pl.merskip.mathalfa.base.core.Symbol;
import pl.merskip.mathalfa.base.elementary.NumberExponentiation;
import pl.merskip.mathalfa.base.elementary.RationalNumber;
import pl.merskip.mathalfa.latex.core.RendererRegister;
import pl.merskip.mathalfa.latex.core.SymbolRenderer;

public class NumberExponentiationRenderer implements SymbolRenderer<NumberExponentiation> {
    
    @Override
    public String renderSymbol(RendererRegister register, NumberExponentiation symbol) {
        String baseLatex = register.renderSymbol(symbol.getBase());
        String powerLatex = register.renderSymbol(symbol.getPower());
        if (baseNeedsParentheses(symbol.getBase())) {
            return String.format("\\left( %s \\right)^{%s}", baseLatex, powerLatex);
        }
        else {
            return String.format("%s^{%s}", baseLatex, powerLatex);
        }
    }
    
    private boolean baseNeedsParentheses(Symbol base) {
        if (base instanceof RationalNumber) {
            RationalNumber baseNumber = (RationalNumber) base;
            return !baseNumber.isInteger();
        }
        return true;
    }
}
