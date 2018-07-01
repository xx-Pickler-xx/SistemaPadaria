package controladres;

import java.util.ArrayList;

public class Pedidos {

	public ArrayList<Produto> ListaDeProdutos = new ArrayList<>();
	public static ArrayList<Pedidos> PedidoTotal = new ArrayList<>();
	public ArrayList<Integer> ListaDeQuantidades = new ArrayList<>();
	public String nome;
	public double precoTotal = 0;
	public String texto = "";

	// -----------------------------------------------------------------------------------------------------

	public void adicionarAoPedido(String nome, int quantidade) {

		for (int i = 0; i < ListaDeProdutos.size(); i++) {
			if (nome.equals(ListaDeProdutos.get(i).nome)) {
				ListaDeQuantidades.set(i, ListaDeQuantidades.get(i) + quantidade);
				return;
			}

		}

		for (Produto produto : Produto.produto) {
			if (produto.nome.equals(nome)) {
				ListaDeQuantidades.add(quantidade);
				ListaDeProdutos.add(produto);
				return;
			}

		}

	}

	// -----------------------------------------------------------------------------------------------------

	public void finalizarPedido() {
		for (int i = 0; i < ListaDeProdutos.size(); i++) {
			precoTotal += ListaDeProdutos.get(i).valor * ListaDeQuantidades.get(i);

		}

		String textoComVirgula = "";
		String textoSemVirgula = "";

		for (int i = 0; i < ListaDeProdutos.size(); i++) {

			textoSemVirgula = " " +ListaDeQuantidades.get(i) + " " + ListaDeProdutos.get(i).nome;
			texto += textoComVirgula;

			textoComVirgula = ListaDeQuantidades.get(i) + " " + ListaDeProdutos.get(i).nome + ", ";

		}
		texto += textoSemVirgula;
		PedidoTotal.add(this);

	}

	// -----------------------------------------------------------------------------------------------------

	// Validar quantidade
	public static boolean validaQuantidade(String quantidade) {
		int valorInt;
		try {
			valorInt = Integer.parseInt(quantidade);
		} catch (Exception e) {

			return false;
		}
		if (valorInt <= 0) {
			return false;
		}
		return true;

	}
}
