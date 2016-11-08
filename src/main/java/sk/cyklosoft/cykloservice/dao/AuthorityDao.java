package sk.cyklosoft.cykloservice.dao;

import sk.cyklosoft.cykloservice.model.Authority;



public interface AuthorityDao {
    
    public void remove(String username);

    public void save(Authority authority);

    public void update(Authority authority);

}
