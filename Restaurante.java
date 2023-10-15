package LPJoelGraca;
public class Restaurante {
    // Constantes
    private static final float MENU_PEIXE = 250.0f;
    private static final float MENU_CARNE = 250.0f;

    // Variáveis de intância
    private int QntdPeixe;
    private int QntdCarne;
    private float despMenuPeixe;
    private float despMenuCarne;
    private float valorPagar;
    private float valorTotal;
    private float valorDobra;
    private float teveLucro;
    private float descontoP;
    private float descontoC;

    public Restaurante(){
        this.QntdPeixe = 0;
        this.QntdCarne = 0;
        this.despMenuPeixe = 300.0f;
        this.despMenuCarne = 300.0f;
        this.valorPagar = 0.0f;
        this.valorTotal = 0.0f;
        this.valorDobra = 0.0f;
        this.teveLucro = 0.0f;
        this.descontoP = 0.0f;
        this.descontoC = 0.0f;
    }

    public Restaurante(float despMenuPeixe, float despMenuCarne){
        this.despMenuPeixe = despMenuPeixe;
        this.despMenuCarne = despMenuCarne;
    }
    // realiza os pedidos dos menus e verifica o valor a ser pago
    public float pedido(int numeroDePeixe, int numeroCarne){
        this.QntdPeixe = numeroDePeixe;
        this.QntdCarne = numeroCarne;
        if (QntdPeixe > 2 && QntdCarne > 2) { // mais de dois menus cada
            descontoP = ((MENU_PEIXE * QntdPeixe) * 20 ) / 100;
            descontoC = ((MENU_CARNE * QntdCarne) * 20 ) / 100;
            valorPagar = ((MENU_PEIXE * QntdPeixe) - descontoP) + ((MENU_CARNE * QntdCarne) - descontoC);
        }else{ // Caso não, calcular a quantidades de menus vendidos
            valorPagar = (MENU_PEIXE * QntdPeixe) + (MENU_CARNE * QntdCarne);
        }
        return valorPagar;
    }
    // retorna o número de menus vendidos a um preço normal
    public int menusPrecoNormal(){
        int precoNormal = 0;
        if (QntdPeixe  <= 2 && QntdCarne <= 2) { // caso os menus não sejam mais de 2
            precoNormal = (int) ((MENU_PEIXE * QntdPeixe) + (MENU_CARNE * QntdCarne));

        }else if(QntdPeixe  <= 2 && QntdCarne > 2 || QntdPeixe  > 2 && QntdCarne <= 2){ // caso apenas um menu seja pedido mais de duas vezes
            precoNormal = (int) ((MENU_PEIXE * QntdPeixe) + (MENU_CARNE * QntdCarne));
        }
        return precoNormal;
    }
    // retorna o número de menus vendidos a um preço reduzido
    public int menusPrecoReduzido(){
        int precoReduzido = 0;
        if (QntdPeixe > 2 && QntdCarne > 2){
            precoReduzido = (int)valorPagar;
        }
        return precoReduzido;
    }
    // valor total abtido das vendas
    public float valorVenda(){
        this.valorTotal = valorPagar;
        return this.valorTotal;
    }
    // valor a pagar ao imposto de (15%)
    public float iva(){
        this.valorDobra = (valorTotal * 15) / 100;
        return this.valorDobra;
    }
    // calcula o lucro do restaurante, valor normal e reduzido, mas o iva
    public float lucro(){
        teveLucro = (this.valorVenda() - this.iva()); // já contém a venda em valor normal ou reduzido
        return this.teveLucro;
    }
    // verifica se o restaurante teve lucro
    public boolean teveLucro() {
        if(this.lucro() > (despMenuPeixe + despMenuCarne)){ // caso o lucro seja superior a despesa dos menus
            return true;
        }
        return false;
    }
}
