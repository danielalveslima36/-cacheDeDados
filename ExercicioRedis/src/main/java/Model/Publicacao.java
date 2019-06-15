package Model;

import java.sql.Timestamp;
import java.time.ZonedDateTime;

public class Publicacao {
    private String id;
    private String texto;
    private Timestamp dataHora;
    private int codigoUser;

    public Publicacao(String id, String texto, Timestamp dataHora, int codigoUser) {
        this.id = String.valueOf(ZonedDateTime.now().toInstant().getEpochSecond());
        this.texto = texto;
        this.dataHora = dataHora;
        this.codigoUser = codigoUser;
    }

    public String getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Timestamp getDataHora() {
        return dataHora;
    }

    public void setDataHora(Timestamp dataHora) {
        this.dataHora = dataHora;
    }

    public int getCodigoUser() {
        return codigoUser;
    }

    public void setCodigoUser(int codigoUser) {
        this.codigoUser = codigoUser;
    }
}
