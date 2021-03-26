package com.brunoIgarzabal.invcontrol.services;

import com.brunoIgarzabal.invcontrol.domain.address.Address;
import com.brunoIgarzabal.invcontrol.domain.contacts.Contact;
import com.brunoIgarzabal.invcontrol.domain.providers.Provider;
import com.brunoIgarzabal.invcontrol.domain.users.User;
import com.brunoIgarzabal.invcontrol.domain.users.enums.UserType;
import com.brunoIgarzabal.invcontrol.repositories.AddressRepository;
import com.brunoIgarzabal.invcontrol.repositories.ContactRepository;
import com.brunoIgarzabal.invcontrol.repositories.ProviderRepository;
import com.brunoIgarzabal.invcontrol.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ProviderRepository providerRepository;
    @Autowired
    private UserRepository userRepository;

    public void instantiateTestDatabase() {
        Contact contact = new Contact(null, "1158120980", "11958175954", "brunoigar@live.com");
        contactRepository.saveAll(Arrays.asList(contact));

        Address address = new Address(
                null, "2169", "05775200", "Rua Professor Leitão da Cunha", "Parque Regina", null, "São Paulo", "SP");
        addressRepository.saveAll(Arrays.asList(address));

        Provider provider = new Provider(
                null, "423423", "343290408923", "Razão Social", "Nome Fantasia", contact, address);
        providerRepository.saveAll(Arrays.asList(provider));

        User user = new User(
                null, "brunoigar@live.com", "brunoIgarzabal", "Bruno Igarzabal", UserType.ADMIN, passwordEncoder.encode("12345678"));
        userRepository.saveAll(Arrays.asList(user));
    }
}
