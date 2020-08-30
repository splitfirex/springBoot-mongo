package io.splitfirex.mongospringboot.controller;

import io.splitfirex.mongospringboot.model.Mensaje;
import io.splitfirex.mongospringboot.servicedb.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MensajeController {

    @Autowired
    private MessageService messageService;

    @GetMapping(value = "/exists/{username}")
    public Boolean getExists(@PathVariable("username") String username) {
        return messageService.existenMensajes(username);
    }

    @PostMapping(value = "/message")
    public String setMessage(@RequestParam("username") String username,
                             @RequestParam("receptor") String receptor,
                             @RequestParam("mensaje") String mensaje) {
        return messageService.setMensaje(username, receptor, mensaje);
    }

    @PostMapping(value = "/messageACK")
    public Boolean setMessageACK(@RequestParam("idMensaje") String idMensaje) {
        return messageService.setMensajeRevisado(idMensaje);
    }

    @GetMapping(value = "/message")
    public List<Mensaje> getMessage(@RequestParam("username") String username) {
        return messageService.getMensajesPendientes(username);
    }

}
