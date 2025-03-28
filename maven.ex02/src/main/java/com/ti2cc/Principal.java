package com.ti2cc;

import java.util.*;

public class Principal {
	
	public static void mostrarMenu() {
		System.out.println("========= Menu =========");
		System.out.println("1)	Listar");
		System.out.println("2)	Inserir");
		System.out.println("3)	Excluir");
		System.out.println("4)	Atualizar");
		System.out.println("5)	Sair");
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DAO dao = new DAO();
		
		dao.conectar();
		
		int opcao, cod, an;
		String nom, marc;
		
		mostrarMenu();
		opcao = sc.nextInt();
		while((opcao < 1) && (opcao > 5)) {
			System.out.println("Valor não aceito. Digite um valor dentre as opções!");
			opcao = sc.nextInt();
		}
		while(opcao != 5) {
			switch(opcao) {
				case 1:
					System.out.println("==== Mostrar carros === ");
					Carro[] carros = dao.getCarros();
					for(int i = 0; i < carros.length; i++) {
						System.out.println(carros[i].toString());
					}
					break;
				case 2:
					System.out.println("Código do carro: ");
					cod = sc.nextInt();
					sc.nextLine();
					System.out.println("Nome do carro: ");
					nom = sc.nextLine();
					System.out.println("Marca do carro: ");
					marc = sc.nextLine();
					System.out.println("Ano do carro: ");
					an = sc.nextInt();
					Carro carro = new Carro(cod, nom, marc, an);
					if(dao.inserirCarro(carro) == true) {
						System.out.println("Inserção com sucesso -> " + carro.toString());
					}
					break;
				case 3:
					System.out.println("Código do carro que deseja excluir: ");
					cod = sc.nextInt();
					dao.excluirCarro(cod);
					break;
				case 4:
					System.out.println("Código do carro que deseja atualizar: ");
					cod = sc.nextInt();
					sc.nextLine();
					System.out.println("Novo nome do carro: ");
					nom = sc.nextLine();
					System.out.println("Nova marca do carro: ");
					marc = sc.nextLine();
					System.out.println("Novo ano do carro: ");
					an = sc.nextInt();
					Carro Carro = new Carro(cod, nom, marc, an);
					dao.atualizarCarro(Carro);
					break;
			}
			mostrarMenu();
			opcao = sc.nextInt();
			while((opcao < 1) && (opcao > 5)) {
				System.out.println("Valor não aceito. Digite um valor dentre as opções!");
				opcao = sc.nextInt();
			}
		}

		sc.close();
		dao.close();
	}

}
