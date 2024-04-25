package BST;

public class Main {

	public static void main(String[] args) {

		BinaryTree bst = new BinaryTree();

		bst.add(8);
		bst.add(4);
		bst.add(2);
		bst.add(6);
		bst.add(18);
		bst.add(12);
		bst.add(20);
		bst.add(10);
		bst.add(16);
		bst.add(14);

		//bst.gerarArqDot("arvore1.dot");
		System.out.println();
		bst.inOrder();
		
		bst.delete(18);

		//bst.gerarArqDot("arvore2.dot");
		System.out.println();
		bst.inOrder();
		
		bst.AlocateNode(10);

		bst.add(13);
		bst.add(22);
		bst.add(17);
		bst.add(30);
		bst.add(20);
		bst.add(19);
		bst.add(24);
		bst.add(9);
		bst.add(1);
		bst.add(17);
		
		//bst.gerarArqDot("arvore3.dot");
		System.out.println();
		bst.inOrder();
		
		bst.delete(13);
		bst.delete(24);
		bst.delete(19);
		
		//bst.gerarArqDot("arvore4.dot");
		System.out.println();
		bst.inOrder();
		
		bst.add(30);
		bst.add(27);
		bst.add(33);
		bst.add(28);
		bst.add(26);
		
		//bst.gerarArqDot("arvore5.dot");
		System.out.println();
		bst.inOrder();
		
		bst.delete(27);
		bst.delete(20);
		
		//bst.gerarArqDot("arvore6.dot");
		System.out.println();
		bst.inOrder();
		
	}

}
