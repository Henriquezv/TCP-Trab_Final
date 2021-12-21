package bank.business.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import bank.business.BusinessException;

/**
 * @author Ingrid Nunes
 * 
 */
public class Transfer extends Transaction {
	
	
	private String estado = "NOT DEFINED";
	private CurrentAccount destinationAccount;

	public Transfer(OperationLocation location, CurrentAccount account,
			CurrentAccount destinationAccount, double amount) {
		super(location, account, amount);
		this.destinationAccount = destinationAccount;
	}

	/**
	 * @return the destinationAccount
	 */
	
	public void setEstado(String newEstado) {
		this.estado = newEstado;
		
	}
	
	
	public String getEstado() {
		return estado;
	}
	
	public void endTransfer() {
		this.setEstado("Finalizado");
		
	}
	public void cancelTransfer() {
		this.setEstado("Cancelado");

	}
	
	public CurrentAccount getDestinationAccount() {
		return destinationAccount;
	}

}
