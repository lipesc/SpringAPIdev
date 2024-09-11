package com.github.lipesc.springapidev.service;

import com.github.lipesc.springapidev.entity.Client;
import com.github.lipesc.springapidev.entity.Company;
import com.github.lipesc.springapidev.repository.ClientRepository;
import com.github.lipesc.springapidev.repository.CompanyRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientService {

  @Autowired
  private ClientRepository clientRepository;

  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private RestTemplate restTemplate;

  private static String webHookURL =
    "https://webhook.site/f0e98593-1916-4e9e-baa6-b54a7e7360ac";

  public Client createClient(Client client, Long companyId) {
    client.setCompany(
      companyRepository
        .findById(companyId)
        .orElseThrow(() -> new RuntimeException("id company not found"))
    );
    return clientRepository.save(client);
  }

  public List<Client> getALLClient() {
    return clientRepository.findAll();
  }

  public Optional<Client> getClientById(Long id) {
    return clientRepository.findById(id);
  }

  public Client updateClient(Long id, Client clientDetails) {
    Client client = clientRepository
      .findById(id)
      .orElseThrow(() -> new RuntimeException("Client not found"));
    client.setName(clientDetails.getName());
    client.setCpf(clientDetails.getCpf());
    client.setAmount(clientDetails.getAmount());
    return clientRepository.save(client);
  }

  public void deleteClient(Long id) {
    clientRepository.deleteById(id);
  }

  public void deposit(Long clientId, Long companyId, double amount) {
    Client client = clientRepository
      .findById(clientId)
      .orElseThrow(() -> new RuntimeException("Client not found"));
    Company company = companyRepository
      .findById(companyId)
      .orElseThrow(() -> new RuntimeException("Company not found"));
    if (amount <= 0) {
      throw new RuntimeException("Insufficient deposit");
    }

    // Update the client's balance
    client.setAmount(client.getAmount() + amount);
    clientRepository.save(client);

    // Update the company's balance with the interest
    company.setAmount(company.getamount() + amount);
    companyRepository.save(company);
    clientRepository.save(client);

    // Send notification to the client
    sendNotification("Deposit of " + amount + " was successful.", client);

    // Send notification to the company
    sendNotification(
      "Deposit of " + amount + " was made by client " + client.getName(),
      company
    );
  }

  public void withdraw(Long clientId, Long companyId, double amount) {
    Client client = clientRepository
      .findById(clientId)
      .orElseThrow(() -> new RuntimeException("Client not found"));
    Company company = companyRepository
      .findById(companyId)
      .orElseThrow(() -> new RuntimeException("Company not found"));
    if (client.getAmount() < amount) {
      throw new RuntimeException("Insufficient balance");
    }
    // Calculate the company interest (2% of the withdrawal amount)
    double interestAmount = amount * 0.02;

    // Update the client's balance
    client.setAmount(client.getAmount() - (amount - interestAmount));
    clientRepository.save(client);

    // Update the company's balance with the interest
    company.setAmount(company.getamount() + interestAmount);
    companyRepository.save(company);

    // Send notification to the client
    sendNotification(
      "Deposit of " +
      amount +
      " was successful, interest on the amount was " +
      interestAmount,
      client
    );

    // Send notification to the company
    sendNotification(
      "Deposit of " + amount + " was made by client " + client.getName(),
      company
    );
  }

  private void sendNotification(String message, Object recipient) {
    if (recipient instanceof Client) {
      // Send notification to client
      restTemplate.postForObject(webHookURL, message, String.class);
    } else if (recipient instanceof Company) {
      restTemplate.postForObject(webHookURL, message, String.class);
    }
  }
}
