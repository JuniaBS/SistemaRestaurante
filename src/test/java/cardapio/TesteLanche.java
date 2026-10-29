package cardapio;

public class TesteLanche {
    public static void main(String[] args) {

        Lanche lanche = new Lanche("Hambúrguer", 25.0);

        System.out.println(lanche.getNome());
        System.out.println(lanche.getPreco());

        Lanche lancheInvalido = new Lanche("", 10.0);

        System.out.println(lanche.getNome());
        System.out.println(lanche.getPreco());
    }
}
