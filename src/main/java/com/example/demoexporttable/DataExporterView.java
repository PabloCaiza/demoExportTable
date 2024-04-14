package com.example.demoexporttable;

import jakarta.annotation.PostConstruct;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.export.Exporter;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ViewScoped
public class DataExporterView implements Serializable {

    public LazyDataModel<Product> getProducts() {
        return products;
    }

    public void setProducts(LazyDataModel<Product> products) {
        this.products = products;
    }

    private LazyDataModel<Product> products;
    private List<Product> products2;

    private Exporter<DataTable> textExporter;
    private String nombre="pablo caiza";
    @Inject
    private ProductService service;

    @PostConstruct
    public void init() {
        products = new LazyDataModel<>() {
            private static final long serialVersionUID = 1L;
            @Override
            public int count(Map<String, FilterMeta> map) {
                return getRowCount();
            }

            public List<Product> load(int startIndex, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
                ArrayList<Product> products1 = new ArrayList<>();
                return products1;
            }

            @Override
            public String getRowKey(Product entidad) {
                return entidad.getCode();
            }

            @Override
            public Product getRowData(String rowKey) {
                return getWrappedData().stream().filter(e -> e.getCode().equals(rowKey))
                        .findAny()
                        .orElse(null);
            }
        };
        products2 = service.getProducts();
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<Product> getProducts2() {
        return products2;
    }

    public void setProducts2(List<Product> products2) {
        this.products2 = products2;
    }
}
