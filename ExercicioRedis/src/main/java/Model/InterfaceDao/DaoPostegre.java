package Model.InterfaceDao;

import Model.Publicacao;

public interface DaoPostegre {

    Publicacao buscar(String id);

    void salvar(Publicacao publicacao);
}
