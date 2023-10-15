package LPJoelGraca;

public class Main_Restaurante {

    public static void main(String[] args){

        Restaurante r1 = new Restaurante(150,150);

        System.out.println(r1.pedido(3,3));
        System.out.println(r1.menusPrecoNormal());
        System.out.println(r1.menusPrecoReduzido());
        System.out.println(r1.valorVenda());
        System.out.println(r1.iva());
        System.out.println(r1.lucro());
        System.out.println(r1.teveLucro());

    }
}
