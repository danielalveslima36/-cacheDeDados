package Model.Dao.Implementacao;

import Model.Conexao.ConFactory;
import Model.Dao.Interfaces.DaoPostegre;
import Model.Publicacao;

import java.sql.Connection;
import java.sql.SQLException;

public class DaoPostgreImpl implements DaoPostegre {

    private ConFactory factory;

    public DaoPostgreImpl() {
        factory = new ConFactory();
    }

    @Override
    public Publicacao buscar(String id) {
        return null;
    }

    @Override
    public void salvar(Publicacao publicacao) {

        try(Connection connection = factory.getConnection()){

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
