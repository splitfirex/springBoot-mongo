package io.splitfirex.mongospringboot.servicedb;

import io.splitfirex.mongospringboot.model.Mensaje;

import java.util.List;

public interface MessageService {

    Boolean existenMensajes(String usuario);

    String setMensaje(String usuarioEmisor, String usuario, String mensaje);

    Boolean setMensajeRevisado(String idMensaje);

    List<Mensaje> getMensajesPendientes(String usuario);

}
