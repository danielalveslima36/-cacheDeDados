package Model.Dao.Implementacao;

import Model.Conexao.ConFactory;
import Model.Dao.Interfaces.DaoPostegre;
import Model.Publicacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoPostgreImpl implements DaoPostegre {

    private ConFactory factory;

    public DaoPostgreImpl() {
        factory = new ConFactory();
    }

    @Override
    public Publicacao buscar(String id) {

        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM publicacao WHERE id = ?"
            );

            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                Publicacao publicacao = new Publicacao(
                        id,
                        resultSet.getString("texto"),
                        resultSet.getTimestamp("dataHora"),
                        resultSet.getInt("codigoUser")
                );
                return  publicacao;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void salvar(Publicacao publicacao) {

        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO publicacao(id, texto, datahora, codigouser)" +
                            "VALUES(?, ?, ?, ?)"
            );

            statement.setString(1, publicacao.getId());
            statement.setString(2, publicacao.getTexto());
            statement.setTimestamp(3, publicacao.getDataHora());
            statement.setInt(4, publicacao.getCodigoUser());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
