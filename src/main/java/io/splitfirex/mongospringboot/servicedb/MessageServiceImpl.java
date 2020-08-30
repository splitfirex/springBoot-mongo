package io.splitfirex.mongospringboot.servicedb;

import io.splitfirex.mongospringboot.model.Mensaje;
import io.splitfirex.mongospringboot.service.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Override
    public Boolean existenMensajes(String usuario) {
        Mensaje msj = new Mensaje();
        msj.setRevisado(false);
        msj.setReceptor(usuario);
        Example<Mensaje> mensajeExample = Example.of(msj);
        return messageRepository.exists(mensajeExample);
    }

    @Override
    public String setMensaje(String usuarioEmisor, String usuarioReceptor, String mensaje) {

        Mensaje mnj = new Mensaje();
        mnj.setId(UUID.randomUUID().toString());
        mnj.setReceptor(usuarioReceptor);
        mnj.setEmisor(usuarioEmisor);
        mnj.setRevisado(false);
        mnj.setFechaEmision(new Date());
        mnj.setMensaje(mensaje);
        messageRepository.save(mnj);
        return mnj.getId();
    }

    @Override
    public Boolean setMensajeRevisado(String idMensaje) {
        Mensaje mnj = messageRepository.findById(idMensaje).orElseThrow();
        mnj.setRevisado(true);
        messageRepository.save(mnj);
        return true;
    }

    @Override
    public List<Mensaje> getMensajesPendientes(String usuario) {
        Mensaje mnj = new Mensaje();
        mnj.setReceptor(usuario);
        mnj.setRevisado(false);
        return messageRepository.findAll(Example.of(mnj));
    }
}
