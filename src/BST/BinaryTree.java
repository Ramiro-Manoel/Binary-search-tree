package BST;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BinaryTree {

	private Node root;

	public BinaryTree() {
		this.root = null;
	}

	public Node AlocateNode(int value) {
		Node novo = new Node(value);
		root = novo;
		return novo;
	}

	public void add(int value) {
		root = add(value, root);
	}

	private Node add(int value, Node root) {

		if (root == null) {
			return new Node(value);
		} else if (value < root.getValor()) {
			root.setLeft(add(value, root.getLeft()));
		} else if (value > root.getValor()) {
			root.setRight(add(value, root.getRight()));

		}
		return root;
	}

	public Node search(int value) {
		return search(value, root);
	}

	private Node search(int value, Node root) {

		if (root == null || value == root.getValor()) {
			return root;
		} else if (value < root.getValor()) {
			return search(value, root.getLeft());
		} else {
			return search(value, root.getRight());
		}
	}

	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node node) {
		if (node != null) {
			System.out.print(node.getValor() + " ");
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node node) {
		if (node != null) {
			inOrder(node.getLeft());
			System.out.print(node.getValor() + " ");
			inOrder(node.getRight());
		}
	}

	public Node buscarMin() {
		return searchMin(root);
	}

	private Node searchMin(Node root) {
		if (root.getLeft() == null) {
			return root;
		}
		return searchMin(root.getLeft());
	}

	public Node delete(int value) {
		return deleteByMerging(value, root);
	}

	private Node deleteByMerging(int value, Node root) {
		// verifica se é nulo
		if (root == null) {
			return root;

			// busca o nodo que quer deletar
		} else if (value < root.getValor()) {
			root.setLeft(deleteByMerging(value, root.getLeft()));
			return root;
		} else if (value > root.getValor()) {
			root.setRight(deleteByMerging(value, root.getRight()));
			return root;
		}
		// acha o nodo que quer deletar
		if (root.getValor() == value) {

			// se o nodo que quer deletar tem apenas filho na direita, puxa o filho no seu
			// lugar, se for nodo folha, vai puxar o nulo e matar o nodo
			if (root.getLeft() == null) {
				return root.getRight();
			}
			// se o nodo que quer deletar tem apenas filho na esquerda, puxa o filho no seu
			// lugar
			if (root.getRight() == null) {
				return root.getLeft();
			}

			// se tem 2 filhos, cria um nodo temporario, igual ao nodo da esquerda que
			// deseja deletar
			Node temp = new Node();
			temp = root.getLeft();
			// busca o nodo mais a direita do temporario
			while (temp.getRight() != null) {
				temp = temp.getRight();
			}
			// define como nodo direta do temporario o nodo a direira do que deseja deletar
			temp.setRight(root.getRight());

		}
		return root.getLeft();
	}

	public void gerarArqDot(String filename) {
        try {
            FileWriter fileWriter = new FileWriter(filename);
            BufferedWriter out = new BufferedWriter(fileWriter);
            out.write("digraph ArvoreBin {\n");
            escreverPreOrdemDot(root, out);
            out.write("}\n");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void escreverPreOrdemDot(Node raiz, BufferedWriter out) throws IOException {
        if (raiz != null) {
            out.write("\t" + raiz.getValor() + ";\n");
            if (raiz.getLeft() != null) {
                out.write("\t" + raiz.getValor() + " -> " + raiz.getLeft().getValor() + ";\n");
            }
            if (raiz.getRight() != null) {
                out.write("\t" + raiz.getValor() + " -> " + raiz.getRight().getValor() + ";\n");
            }
            escreverPreOrdemDot(raiz.getLeft(), out);
            escreverPreOrdemDot(raiz.getRight(), out);
        }
    }

}
