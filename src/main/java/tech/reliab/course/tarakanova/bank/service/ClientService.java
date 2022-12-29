package tech.reliab.course.tarakanova.bank.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.reliab.course.tarakanova.bank.entity.Client;
import tech.reliab.course.tarakanova.bank.repository.ClientRepository;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Client createClient(String name) {
        var client = new Client();
        client.setFirstName(name);
        client.setPlaceWork("placeWork");
        return clientRepository.save(client);
    }

    public void save(Client client) {
        clientRepository.save(client);
    }
}
