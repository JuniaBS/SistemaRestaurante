package cardapio;

public class Lanche implements ItemCardapio {

    private String nome;
    private double preco;

    private boolean queijo = true;
    private boolean alface = true;
    private boolean tomate = true;
    private boolean cebola = true;

    public Lanche(String nome, double preco) {
        setNome(nome);
        setPreco(preco);
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");
        }

        this.nome = nome;
    }

    public void setPreco(double preco) {
        if (!Double.isFinite(preco) || preco < 0) {
            throw new IllegalArgumentException("Valor não pode ser negativo.");
        }

        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String getDescricao() {
        String desc = nome;

        if (!queijo) desc += " sem queijo";
        if (!alface) desc += " sem alface";
        if (!tomate) desc += " sem tomate";
        if (!cebola) desc += " sem cebola";

        return desc;
    }

    @Override
    public double getPreco() {

        return preco;
    }

    public boolean isQueijo() {

        return queijo;
    }

    public void setQueijo(boolean queijo) {

        this.queijo = queijo;
    }

    public boolean isAlface() {

        return alface;
    }

    public void setAlface(boolean alface) {

        this.alface = alface;
    }

    public boolean isTomate() {

        return tomate;
    }

    public void setTomate(boolean tomate) {

        this.tomate = tomate;
    }

    public boolean isCebola() {

        return cebola;
    }

    public void setCebola(boolean cebola) {

        this.cebola = cebola;
    }

    @Override
    public String getNomeBase() {
        return nome;
    }
}
