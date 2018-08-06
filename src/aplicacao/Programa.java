package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import MVC_Model_View_Control.entidades.Reserva;
import Modelo_de_Ececao.ErroPrincipal;

public class Programa {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat dFormatoData = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Entre com o numero do Quarto desejado: ");
			int iNumeroDoQuarto = sc.nextInt();
			System.out.print("Entre com a data de entrada (dd/MM/yyyy): ");
			Date dEntrada = dFormatoData.parse(sc.next());
			System.out.print("Entre com a data de saida (dd/MM/yyyy): ");
			Date dSaida = dFormatoData.parse(sc.next());

			Reserva reserva = new Reserva(iNumeroDoQuarto, dEntrada, dSaida);
			System.out.println("Cliente reservado: " + reserva);

			System.out.println();
			System.out.print("Entre com a data de entrada (dd/MM/yyyy): ");
			dEntrada = dFormatoData.parse(sc.next());
			System.out.print("Entre com a data de saida (dd/MM/yyyy): ");
			dSaida = dFormatoData.parse(sc.next());

			reserva.atualizaData(dEntrada, dSaida);
		} catch (ParseException e) {
			System.out.println("Data digitada é invalida!");
		} catch (ErroPrincipal e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Erro não esperado.");
		}
		sc.close();
	}
}
