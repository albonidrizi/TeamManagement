package repository;

import java.sql.SQLException;
import java.util.List;

public interface GenericRepository<M, ID> {

    List<M> getAll() throws SQLException, ClassNotFoundException;

    M getById(ID id) throws SQLException, ClassNotFoundException;

    void add(M model) throws SQLException, ClassNotFoundException;

    void update(M model) throws SQLException, ClassNotFoundException;

    void delete(M model);

}
