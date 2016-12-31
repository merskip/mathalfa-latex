package pl.merskip.mathalfa.latex.core;

import pl.merskip.mathalfa.base.core.Symbol;

public interface RendererRegister {
    
    String renderEquation(Symbol leftMember, Symbol rightMember);
    
    String renderSymbol(Symbol symbol);
    
}
