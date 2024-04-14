package com.example.demoexporttable;

import jakarta.faces.context.FacesContext;
import org.apache.commons.collections4.ComparatorUtils;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LazyCustomerDataModel extends LazyDataModel<Customer> {

    private static final long serialVersionUID = 1L;

    private List<Customer> datasource;

    public LazyCustomerDataModel(List<Customer> datasource) {
        this.datasource = datasource;
    }

    @Override
    public Customer getRowData(String rowKey) {
        return getWrappedData().stream().filter(e -> String.valueOf(e.getId()).equals(rowKey))
                .findAny()
                .orElse(null);
    }

    @Override
    public String getRowKey(Customer customer) {
        return String.valueOf(customer.getId());
    }

    @Override
    public int count(Map<String, FilterMeta> filterBy) {
        return datasource.size();
    }

    @Override
    public List<Customer> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
        return datasource;
    }


}
