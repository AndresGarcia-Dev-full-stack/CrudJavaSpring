package com.usa.retoTres.services;

import com.usa.retoTres.model.Client;
import com.usa.retoTres.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.findAll();
    }
    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }
    public Client save(Client Client) {
        if(Client.getIdClient()==null){
            return clientRepository.save(Client);
        }else{
            Optional<Client> ClientEncontrado= getClient(Client.getIdClient());
            if(ClientEncontrado.isEmpty()){
                return clientRepository.save(Client);
            }else{
                return Client;
            }
        }

    }

    public Client update(Client Client) {
        if(Client.getIdClient()!=null){
            Optional<Client> ClientEncontrado = getClient(Client.getIdClient());
            if(ClientEncontrado.isPresent()){
                if(Client.getEmail()!=null){
                    ClientEncontrado.get().setEmail(Client.getEmail());
                }
                if(Client.getName()!=null){
                    ClientEncontrado.get().setName(Client.getName());
                }
                if(Client.getAge()!=null){
                    ClientEncontrado.get().setAge(Client.getAge());
                }
                if (Client.getPassword()!=null) {
                    ClientEncontrado.get().setPassword(Client.getPassword());
                }
                return clientRepository.save(ClientEncontrado.get());
            }else{
                return Client;
            }
        }else{
            return Client;
        }

    }

    public boolean deleteClient(int id) {
        boolean respuesta = getClient(id).map(Client ->{
            clientRepository.delete(Client);
            return true;
        }).orElse(false);
        return respuesta;

    }
}
