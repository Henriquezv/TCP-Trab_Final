package bank.ui.text.command;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import bank.business.AccountManagementService;
import bank.business.AccountOperationService;
import bank.business.domain.CurrentAccount;
import bank.business.domain.Transfer;
import bank.ui.text.BankTextInterface;


public class PendingTransfersCommand extends Command {
	
	private final AccountManagementService accountManagementService;
	private final AccountOperationService accountOperationService;
	
	public PendingTransfersCommand(BankTextInterface bankInterface,
			AccountManagementService accountManagementService, AccountOperationService accountOperationService) {
		super(bankInterface);
		this.accountManagementService = accountManagementService;
		this.accountOperationService = accountOperationService;
	}


	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		Collection<CurrentAccount> allAccounts = accountManagementService.getAllCurrentAccounts();
		
		List<Transfer> listTransfer = accountOperationService.listAllPending(allAccounts);
		
		int numTransfer = accountOperationService.selectPendingTransfer();
		
		Transfer selectedTransfer = accountOperationService.getSelectedTransfer(numTransfer, listTransfer);
		
		accountOperationService.transferAuthorization(selectedTransfer);
	
		
	}

}