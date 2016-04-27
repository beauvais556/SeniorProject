package com.seniorproject.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seniorproject.web.dao.WithdrawalDAO;
import com.seniorproject.web.pojo.Withdrawal;

@Service("withdrawalService")
public class WithdrawalService extends ParentService {

	@Autowired
	WithdrawalDAO withdrawalDAO;

	public List<Withdrawal> listWithdrawals(Integer userId) {

		List<Withdrawal> withdrawals = withdrawalDAO.listWithdrawals(userId);

		return withdrawals;
	}

	public int submitWithdrawal(Integer userId, Withdrawal withdrawal) {
		withdrawal.setApprovedBy("NONE");
		withdrawal.setApprovalStatus("PENDING");
		withdrawal.setUserId(userId);
		withdrawalDAO.saveWithdrawal(withdrawal);

		return 0;
	}
}
