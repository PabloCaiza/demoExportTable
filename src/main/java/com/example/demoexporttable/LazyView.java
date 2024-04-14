package com.example.demoexporttable;

import jakarta.annotation.PostConstruct;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.model.LazyDataModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class LazyView implements Serializable {

    private LazyDataModel<Customer> lazyModel;
    private List<Customer> customers;

    private Customer selectedCustomer;


    @PostConstruct
    public void init() {
        ArrayList<Customer> datasource = new ArrayList<>();
        datasource.add(new Customer(1,"pablo"));
        lazyModel = new LazyCustomerDataModel(datasource);
        customers = new ArrayList<>(datasource);
    }

    public LazyDataModel<Customer> getLazyModel() {
        return lazyModel;
    }

    public Customer getSelectedCustomer() {
        return selectedCustomer;
    }

    public void setSelectedCustomer(Customer selectedCustomer) {
        this.selectedCustomer = selectedCustomer;
    }

    public List<Customer> getCustomers() {
        throw  new RuntimeException("a un manjar");
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
