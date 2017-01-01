package pl.merskip.mathalfa.latex.core;

import pl.merskip.mathalfa.base.core.Symbol;

import java.util.List;

public interface RendererRegister {
    
    String renderEquation(List<Symbol> members);
    
    String renderSymbol(Symbol symbol);
    
}
