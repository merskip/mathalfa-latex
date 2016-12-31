package pl.merskip.mathalfa.latex.elementary;

import pl.merskip.mathalfa.base.core.Operator;
import pl.merskip.mathalfa.base.core.Symbol;
import pl.merskip.mathalfa.base.elementary.NumberAddition;
import pl.merskip.mathalfa.base.elementary.RationalNumber;
import pl.merskip.mathalfa.latex.core.RendererRegister;

public abstract class OperatorRenderer {
    
    private String operatorChar;
    
    protected OperatorRenderer(String operatorChar) {
        this.operatorChar = operatorChar;
    }
    
    protected String renderOperator(RendererRegister register,
                                    Operator operator,
                                    Symbol firstArgument, Symbol secondArgument) {
        
        String firstArgLatex = register.renderSymbol(firstArgument);
        String secondArgLatex = register.renderSymbol(secondArgument);
        
        if (symbolNeedsParentheses(firstArgument)) {
            firstArgLatex = String.format("\\left( %s \\right)", firstArgLatex);
        }
        if (symbolNeedsParentheses(secondArgument)) {
            secondArgLatex = String.format("\\left( %s \\right)", secondArgLatex);
        }
        
        return firstArgLatex + " " + operatorChar + " " + secondArgLatex;
    }
    
    private boolean symbolNeedsParentheses(Symbol symbol) {
        if (symbol instanceof RationalNumber) {
            RationalNumber firstArgument = (RationalNumber) symbol;
            return firstArgument.getDenominator() != 1;
        }
        return true;
    }
}
