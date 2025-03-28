package com.ti2cc;

public class Principal {
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		dao.conectar();

		
		//Inserir um elemento na tabela
		Carro carro = new Carro(5, "panamera", "porsche",2022);
		if(dao.inserirCarro(carro) == true) {
			System.out.println("Inserção com sucesso -> " + carro.toString());
		}
		
		//Mostrar carros		
		System.out.println("==== Mostrar carros === ");
		Carro[] carros = dao.getCarros();
		for(int i = 0; i < carros.length; i++) {
			System.out.println(carros[i].toString());
		}

		//Atualizar carro
		carro.setNome("novo nome");
		dao.atualizarCarro(carro);
		
		//Mostrar carros
		System.out.println("==== Mostrar carros === ");
		carros = dao.getCarros();
		for(int i = 0; i < carros.length; i++) {
			System.out.println(carros[i].toString());
		}
		
		//Excluir carro
		dao.excluirCarro(carro.getCodigo());
		
		//Mostrar carros
		carros = dao.getCarros();
		System.out.println("==== Mostrar carros === ");		
		for(int i = 0; i < carros.length; i++) {
			System.out.println(carros[i].toString());
		}
		
		dao.close();
	}

}
