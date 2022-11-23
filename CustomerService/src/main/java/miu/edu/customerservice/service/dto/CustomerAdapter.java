package miu.edu.customerservice.service.dto;

import miu.edu.customerservice.domain.Address;
import miu.edu.customerservice.domain.Contact;
import miu.edu.customerservice.domain.Customer;

public class CustomerAdapter {
    public static CustomerDto toCustomerDto(Customer customer) {
        return new CustomerDto(
                customer.getCustomerNumber(),
                customer.getName(),
                toAddressDto(customer.getAddress()),
                toContactDto(customer.getContact()));
    }

    public static Customer toCustomer(CustomerDto customerDto) {
        return new Customer(
                customerDto.getCustomerNumber(),
                customerDto.getName(),
                toAddress(customerDto.getAddressDto()),
                toContact(customerDto.getContactDto()));
    }

    public static AddressDto toAddressDto(Address address) {
        return new AddressDto(
                address.getStreet(),
                address.getCity(),
                address.getZip());
    }

    public static Address toAddress(AddressDto addressDto) {
        return new Address(
                addressDto.getStreet(),
                addressDto.getCity(),
                addressDto.getZip());
    }

    public static ContactDto toContactDto(Contact contact) {
        return new ContactDto(
                contact.getPhone(),
                contact.getEmail());
    }

    public static Contact toContact(ContactDto contactDto) {
        return new Contact(
                contactDto.getPhone(),
                contactDto.getEmail());
    }
}
