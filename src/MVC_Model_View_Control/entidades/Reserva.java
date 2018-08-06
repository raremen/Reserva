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
	
	public String atualizaData(Date dEntrada, Date dSaida) {
		Date dAgora = new Date();
		if (dEntrada.before(dAgora) || dSaida.before(dAgora)) {
			return "Data incorreta, favor colocar datas futuras referente a data de hoje.";
		}
		if(!dSaida.after(dEntrada)) {
		return "Favor informar a data correta, onde entrada e saida batem com "
				+ "os dias reais pois o cliente não é um jumper temporal.";
		}
		this.dEntrada = dEntrada;
		this.dSaida   = dSaida;
		return null;
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
