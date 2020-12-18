package javaapplication8;

import java.util.Scanner;

public class Teste {
    static Scanner input;
    public static void main(String[] args) {
        input = new Scanner(System.in);
        Produto[] produtos = new Produto[4];
        Item[] itens = new Item[10];
        Fatura fatura = null;
        casosTeste(produtos);
        int opcao;
        do{
            do{
                Menu1();
                opcao = input.nextInt();
            }while(opcao < 0 || opcao > 3);
            var bug = input.nextLine();
            switch(opcao){
                case 1: // Comprar um produto
                    for(int i = 0; i < itens.length; i++){
                        if(itens[i] == null ){
                            itens[i] = comprarProduto(produtos);
                            break;
                        }
                        if(i == itens.length - 1 && itens[i] != null){
                            System.out.println("\nLimite no carrinho excedido!\n");
                        }                        
                    }
                    break;
                case 2: // Olhar a fatura
                    olharFatura(itens);
                    break;
                case 3:
                    finalizarCompra(fatura, itens);
                    return;
            }
        }while(opcao != 0);
    }
    private static void finalizarCompra(Fatura fatura, Item[] itens) {
        fatura = new Fatura(itens);
        System.out.print("\nItens Comprados: ");
        String descricao;
        double valor;
        int quantidade;
        for(int i = 0; i < itens.length; i++){
            if(itens[i] != null){
                descricao = itens[i].getProduto().getDescricao();
                quantidade = itens[i]. getQuantidade();
                valor = itens[i].getValorTotal();
                System.out.print("\nDescrição: " +descricao
                               + "\nQuantidade: " +itens[i].getQuantidade()
                               + "\nValor: R$" + valor);
            }
        }
        System.out.println("\nValor total: R$" + fatura.getValorTotal());
        int pagamento;
        do{
            System.out.print("\nO cliente ja realizou o pagamento: "
                           + "\n(1). Sim"
                           + "\n(0). Não"
                           + "\nOpção: ");
            pagamento = input.nextInt();
        }while(pagamento != 1);
        System.out.println("\nCompraFinalizada");
    }
    private static void olharFatura(Item[] itens){
        double total = 0.0;
        for(int i = 0; i < itens.length; i++){
            if(itens[i] == null){
                break;
            }
            total += itens[i].getValorTotal();
        }
        System.out.println("\nValor total da compra: R$"+total);
    }
    private static Item comprarProduto(Produto[] produtos){
        int opcao;
        do{
            System.out.print("\nDigite a opção desejada: ");
            for(int i = 0; i < produtos.length; i++){
                System.out.print("\n("+produtos[i].getId()+"). Descrição: "+produtos[i].getDescricao()
                                +"\nValor: R$"+produtos[i].getPreco());
            }
            System.out.print("\nOpção: ");
            opcao = input.nextInt();
        }while(opcao < 0 || opcao > produtos[produtos.length - 1].getId());
        int quantidade;
        do{
            System.out.print("\nDigite a quantidade desejada: ");
            quantidade = input.nextInt();
        }while(quantidade < 0);
        return new Item(produtos[opcao - 1], quantidade);
    }
    private static void Menu1(){
        System.out.print("\nDigite a opção desejada: "
                       + "\n(1). Comprar um produto"
                       + "\n(2). Olhar valor total"
                       + "\n(3). Finalizar compra"
                       + "\n(0). Encerrar"
                       + "\nOpção: ");
    }
    private static void casosTeste(Produto[] produtos){
        produtos[0] = new Produto(1, "Cooler para processador", 40.00);
        produtos[1] = new Produto(2, "Mouse Gamer sem fio", 70.00);
        produtos[2] = new Produto(3, "Teclado / mouse sem fio", 125.00);
        produtos[3] = new Produto(4, "Monitor LED 24’", 692.00); 
    }

}








































