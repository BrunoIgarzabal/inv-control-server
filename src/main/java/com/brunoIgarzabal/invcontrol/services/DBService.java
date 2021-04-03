package com.brunoIgarzabal.invcontrol.services;

import com.brunoIgarzabal.invcontrol.domain.address.Address;
import com.brunoIgarzabal.invcontrol.domain.brands.Brand;
import com.brunoIgarzabal.invcontrol.domain.categories.Category;
import com.brunoIgarzabal.invcontrol.domain.contacts.Contact;
import com.brunoIgarzabal.invcontrol.domain.formsOfPayment.FormOfPayment;
import com.brunoIgarzabal.invcontrol.domain.orders.Order;
import com.brunoIgarzabal.invcontrol.domain.providers.Provider;
import com.brunoIgarzabal.invcontrol.domain.sellers.Seller;
import com.brunoIgarzabal.invcontrol.domain.users.User;
import com.brunoIgarzabal.invcontrol.domain.users.enums.UserType;
import com.brunoIgarzabal.invcontrol.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

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
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private FormOfPaymentRepository formOfPaymentRepository;

    public void instantiateTestDatabase() {
        Contact contact = new Contact(null, "1158120980", "11958175954", "brunoigar@live.com");
        Contact contact2 = new Contact(null, "1153247984", "11965443264", "joao@gmail.com");
        contactRepository.saveAll(Arrays.asList(contact, contact2));

        Address address = new Address(
                null, "2169", "05775200", "Rua Professor Leitão da Cunha", "Parque Regina", "Casa 06", "São Paulo", "SP");
        Address address2 = new Address(
                null, "33", "05731430", "Rua São João do Pernambuco", "Vila Ernesto", null, "São Paulo", "SP");
        addressRepository.saveAll(Arrays.asList(address, address2));

        Provider provider = new Provider(
                null, "423423", "343290408923", "Razão Social", "Nome Fantasia", contact, address);
        providerRepository.saveAll(Arrays.asList(provider));

        User user = new User(
                null, "brunoigar@live.com", "brunoIgarzabal", "Bruno Igarzabal", UserType.ADMIN, passwordEncoder.encode("12345678"));
        User user1 = new User(
                null, "brunoigar@gmail.com", "brunoOliveira", "Bruno Igarzabal", UserType.SELLER, passwordEncoder.encode("12345678"));
        userRepository.saveAll(Arrays.asList(user, user1));

        Category category = new Category(null, "Eletrônicos");
        Category category2 = new Category(null, "Ferramentas");
        Category category3 = new Category(null, "Jogos");
        categoryRepository.saveAll(Arrays.asList(category, category2, category3));

        Brand brand = new Brand(null, "Samsung");
        Brand brand2 = new Brand(null, "Sony");
        Brand brand3 = new Brand(null, "Positivo");
        brandRepository.saveAll(Arrays.asList(brand, brand2, brand3));

        Order order = new Order(null, "Limpeza Geral", "300.00", true);
        Order order2 = new Order(null, "Restauração de Componentes", "120.00", true);
        orderRepository.saveAll(Arrays.asList(order, order2));

        FormOfPayment formOfPayment = new FormOfPayment(null, "Boleto Bancário", false);
        FormOfPayment formOfPayment2 = new FormOfPayment(null, "Cartão de Crédito", true);
        FormOfPayment formOfPayment3 = new FormOfPayment(null, "Cartão de Débito", false);
        formOfPaymentRepository.saveAll(Arrays.asList(formOfPayment, formOfPayment2, formOfPayment3));

        Seller seller = new Seller(null, "João dos Santos", "41035801515", contact2, address2);
        sellerRepository.saveAll(Arrays.asList(seller));
    }
}
