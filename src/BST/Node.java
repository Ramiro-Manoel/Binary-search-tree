package BST;

public class Node {

	private int valor;
	private Node right;
	private Node left;
	
	public Node() {}
	
	public Node(int valor) {
		this.valor = valor;
		this.right = null;
		this.left = null;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	@Override
	public String toString() {
		return "Node [valor=" + valor + ", right=" + right + ", left=" + left + "]";
	}
	
}
