package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import layerServices.ContractService;

public class Program {

	public static void main(String[] args) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\033[1mEntre com os dados do contrato:\033[0m");
		System.out.print("Número: ");
		int number = sc.nextInt();
		System.out.print("Data(dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), dtf);
		System.out.print("Valor do contrato: ");
		double contractValue = sc.nextDouble();
		
		Contract contract = new Contract(number, date, contractValue);
		
		System.out.print("Entre com o número de parcelas: ");
		int installmentsNumber = sc.nextInt();
		
		ContractService contractService = new ContractService(null);
		
		contractService.processContract(contract, installmentsNumber);
		
		System.out.println("\033[1mParcelas:\033[0m");		
		for (Installment installment: contract.getInstallments()) {
			System.out.println(installment);
		}
		
		sc.close();

	}

}