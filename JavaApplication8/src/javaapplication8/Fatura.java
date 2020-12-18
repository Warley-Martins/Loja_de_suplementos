package javaapplication8;
public class Fatura {
    private Item[] itens;
    private double valorTotal = 0;
    public Fatura(Item[] itens){
        this.itens = itens;
        for(int i = 0; i < itens.length; i++){
            if(itens[i] != null){
                valorTotal += itens[i].getValorTotal();
            }
        }
    }
    public Item[] getItens() {
        return itens;
    }
    public void setItens(Item[] itens) {
        this.itens = itens;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
}





