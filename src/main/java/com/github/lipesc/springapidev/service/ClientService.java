package com.github.lipesc.springapidev.service;

import com.github.lipesc.springapidev.entity.Client;
import com.github.lipesc.springapidev.entity.Company;
import com.github.lipesc.springapidev.entity.DepositRequest;
import com.github.lipesc.springapidev.entity.WithdrawRequest;
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
    "https://webhook.site/d3095a92-e5d4-4c42-aa8e-c44f9ac3e5a7";

  public Client createClient(
    Long cpf,
    String name,
    double amount,
    Long companyId,
    Company company
  ) {
    Client newClient = new Client(); // create a new Client object
    newClient.setCpf(cpf);
    newClient.setName(name);
    newClient.setAmount(amount);

    if (company == null) {
      Company companys = companyRepository
        .findById(companyId)
        .orElseThrow(() -> new RuntimeException("Company not found"));

      newClient.setCompany(companys);
    } else {
      newClient.setCompany(company);
    }
    return clientRepository.save(newClient);
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

  public void deposit(DepositRequest request) {
    request.getClientId();
    request.getCompanyId();
    request.getAmount();

    Client client = clientRepository
      .findById(request.getClientId())
      .orElseThrow(() -> new RuntimeException("Client not found"));
    Company company = companyRepository
      .findById(request.getCompanyId())
      .orElseThrow(() -> new RuntimeException("Company not found"));
    if (request.getAmount() <= 0) {
      throw new RuntimeException("Insufficient deposit");
    }

    // Update the client's balance
    client.setAmount(client.getAmount() + request.getAmount());
    clientRepository.save(client);

    // Update the company's balance with the interest
    company.setAmount(company.getamount() + request.getAmount());
    companyRepository.save(company);
    clientRepository.save(client);

    // Send notification to the client
    sendNotification(
      "Deposit of " + request.getAmount() + " was successful.",
      client
    );

    // Send notification to the company
    sendNotification(
      "Deposit of " +
      request.getAmount() +
      " was made by client " +
      client.getName(),
      company
    );
  }

  public void withdraw(WithdrawRequest request) {
    request.getClientId();
    request.getCompanyId();
    request.getAmount();

    Client client = clientRepository
      .findById(request.getClientId())
      .orElseThrow(() -> new RuntimeException("Client not found"));
    Company company = companyRepository
      .findById(request.getCompanyId())
      .orElseThrow(() -> new RuntimeException("Company not found"));
    if (client.getAmount() < request.getAmount()) {
      throw new RuntimeException("Insufficient balance");
    }
    // Calculate the company interest (2% of the withdrawal amount)
    double interestAmount = request.getAmount() * 0.02;

    // Update the client's balance
    client.setAmount(
      client.getAmount() - (request.getAmount() - interestAmount)
    );
    clientRepository.save(client);

    // Update the company's balance with the interest
    company.setAmount(
      company.getamount() - request.getAmount() + interestAmount
    );
    companyRepository.save(company);

    // Send notification to the client
    sendNotification(
      "withdraw of " +
      request.getAmount() +
      " was successful, interest on the amount was " +
      interestAmount,
      client
    );

    // Send notification to the company
    sendNotification(
      "withdraw of " +
      request.getAmount() +
      " was made by client " +
      client.getName(),
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
