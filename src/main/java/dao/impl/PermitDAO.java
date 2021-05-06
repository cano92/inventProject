package dao.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import dao.IPermitDAO;
import entities.Permit;

@Repository
@Transactional
public class PermitDAO extends GenericDAO<Permit> implements IPermitDAO{

	public PermitDAO() {
		super(Permit.class);
	}

}
