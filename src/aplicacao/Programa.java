package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import MVC_Model_View_Control.entidades.Reserva;

public class Programa {
	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat dFormatoData = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Entre com o numero do Quarto desejado: ");
		int iNumeroDoQuarto = sc.nextInt();
		System.out.print("Entre com a data de entrada (dd/MM/yyyy): ");
		Date dEntrada = dFormatoData.parse(sc.next());
		System.out.print("Entre com a data de saida (dd/MM/yyyy): ");
		Date dSaida = dFormatoData.parse(sc.next());

		if (!dSaida.after(dEntrada)) {
			System.out.println("Favor informar a data correta, onde entrada e saida batem com "
					+ "os dias reais pois o cliente não é um jumper temporal.");
		} else {
			Reserva reserva = new Reserva(iNumeroDoQuarto, dEntrada, dSaida);
			System.out.println("Cliente reservado: " + reserva);

			System.out.println();
			System.out.print("Entre com a data de entrada (dd/MM/yyyy): ");
			dEntrada = dFormatoData.parse(sc.next());
			System.out.print("Entre com a data de saida (dd/MM/yyyy): ");
			dSaida = dFormatoData.parse(sc.next());

			String sErro = reserva.atualizaData(dEntrada, dSaida);
			if (sErro != null) {
				System.out.println(" Erro ao realizar a reserva: " + sErro);
			} else {
				System.out.println("Reserva atualizada: " + reserva);

			}
		}
		sc.close();
	}
}
