package dao.impl;

import org.springframework.stereotype.Repository;

import dao.IPermitDAO;
import entities.Permit;

@Repository
public class PermitDAO extends GenericDAO<Permit> implements IPermitDAO{

	public PermitDAO() {
		super(Permit.class);
	}

}
