package pl.merskip.mathalfa.latex.core;

public interface SymbolRenderer<T> {
    
    String renderSymbol(RendererRegister register, T symbol);
    
}
