package MVC_Model_View_Control.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	private Integer iNumeroDoQuarto;
	private Date    dEntrada;
	private Date    dSaida;
	
	private static SimpleDateFormat dFormatoData = new SimpleDateFormat("dd/MM/yyyy");
// Feito como statico para não ser criado outros SimpleDateFormat para cada vez que chamar a dEntrada ou a dSada
	
	public Reserva() {
	}

	public Reserva(Integer iNumeroDoQuarto, Date dEntrada, Date dSaida) {
		this.iNumeroDoQuarto = iNumeroDoQuarto;
		this.dEntrada = dEntrada;
		this.dSaida = dSaida;
	}

	public Integer getiNumeroDoQuarto() {
		return iNumeroDoQuarto;
	}

	public void setiNumeroDoQuarto(Integer iNumeroDoQuarto) {
		this.iNumeroDoQuarto = iNumeroDoQuarto;
	}

	public Date getdEntrada() {
		return dEntrada;
	}

	public Date getdSaida() {
		return dSaida;
	}
	
	public long duracao() {
		long lDiferenca = dSaida.getTime() - dEntrada.getTime();
		return TimeUnit.DAYS.convert(lDiferenca, TimeUnit.MICROSECONDS);
	}
	
	public void atualizaData(Date dEntrada, Date dSaida) {
		this.dEntrada = dEntrada;
		this.dSaida   = dSaida;
	}
	
	@Override
	public String toString() {
		return "\n_________________________\n" +
				"Quarto: "
				+ iNumeroDoQuarto +
				"\nEntrada: "
				+ dFormatoData.format(dEntrada) +
				" dia e Saida: "
				+ dFormatoData.format(dSaida) 
				+ " dia.\n" +
				" Cliente ficou "
				+ duracao() +
				" Noites"
				+ "\n_________________________";
	}
}
