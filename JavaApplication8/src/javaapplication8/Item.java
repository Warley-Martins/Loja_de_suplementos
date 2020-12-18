package javaapplication8;
public class Item {
    private Produto produto;
    private double valorTotal;
    private int quantidade;
    public Item(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotal = (produto.getPreco() * quantidade);
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}


