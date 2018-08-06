package Modelo_de_Ececao;

public class ErroPrincipal extends Exception{ 
	// RuntimeException para o compilador não obrigar a tratar
	// Pode ser usado os doi Excepitions
	// Pode ser retirado os Throws dos construtores
	
	private static final long serialVersionUID = 1L; 

	public ErroPrincipal(String sMensagen) {
		super (sMensagen);
	}
	
}
