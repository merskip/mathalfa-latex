package pl.merskip.mathalfa.latex.elementary;

import pl.merskip.mathalfa.base.core.Operator;
import pl.merskip.mathalfa.base.core.Symbol;
import pl.merskip.mathalfa.base.elementary.NumberAddition;
import pl.merskip.mathalfa.base.elementary.NumberSubtraction;
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
        
        if (firstArgumentNeedsParentheses(firstArgument)) {
            firstArgLatex = String.format("\\left( %s \\right)", firstArgLatex);
        }
        if (secondArgumentNeedsParentheses(secondArgument)) {
            secondArgLatex = String.format("\\left( %s \\right)", secondArgLatex);
        }
        
        return firstArgLatex + " " + operatorChar + " " + secondArgLatex;
    }
    
    @SuppressWarnings("RedundantIfStatement")
    private boolean firstArgumentNeedsParentheses(Symbol firstArgument) {
        if (symbolIsIntegerNumber(firstArgument)
                || firstArgument instanceof NumberAddition
                || firstArgument instanceof NumberSubtraction ) {
            return false;
        }
        else {
            return true;
        }
    }
    
    @SuppressWarnings("RedundantIfStatement")
    private boolean secondArgumentNeedsParentheses(Symbol firstArgument) {
        if (symbolIsIntegerNumber(firstArgument)) {
            return false;
        }
        else {
            return true;
        }
    }
    
    private boolean symbolIsIntegerNumber(Symbol symbol) {
        if (symbol instanceof RationalNumber) {
            RationalNumber number = (RationalNumber) symbol;
            return number.getDenominator() == 1;
        }
        return false;
    }
}
