package pl.merskip.mathalfa.latex.elementary;

import pl.merskip.mathalfa.base.core.Operator;
import pl.merskip.mathalfa.base.core.Symbol;
import pl.merskip.mathalfa.base.elementary.NumberDivision;
import pl.merskip.mathalfa.base.elementary.NumberExponentiation;
import pl.merskip.mathalfa.base.elementary.RationalNumber;
import pl.merskip.mathalfa.latex.core.RendererRegister;

public abstract class OperatorRenderer {
    
    private String operatorChar;
    
    protected OperatorRenderer(String operatorChar) {
        this.operatorChar = operatorChar;
    }
    
    protected String renderOperator(RendererRegister register, Operator operator, Symbol firstArgument, Symbol secondArgument) {
        
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
    
    protected boolean firstArgumentNeedsParentheses(Symbol firstArgument) {
        //noinspection SimplifiableIfStatement
        if (firstArgument instanceof RationalNumber
                || firstArgument instanceof NumberDivision
                || firstArgument instanceof NumberExponentiation) {
            return false;
        }
        else {
            return true;
        }
    }
    
    protected boolean secondArgumentNeedsParentheses(Symbol secondArgument) {
        //noinspection SimplifiableIfStatement
        if (secondArgument instanceof RationalNumber
                || secondArgument instanceof NumberDivision
                || secondArgument instanceof NumberExponentiation) {
            return false;
        }
        else {
            return true;
        }
    }
}
