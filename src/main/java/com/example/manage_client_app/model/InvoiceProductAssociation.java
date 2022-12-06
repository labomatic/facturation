package com.example.manage_client_app.model;

import jakarta.persistence.*;

@Entity
public class InvoiceProductAssociation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_product_association_id", nullable = false)
    private Long InvoiceProductAssociationId;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer productQuantity;

    public InvoiceProductAssociation () {}


    //getters/setters
    public Long getInvoiceProductAssociationId() {
        return InvoiceProductAssociationId;
    }

    public void setInvoiceProductAssociationId(Long invoiceProductAssociationId) {
        InvoiceProductAssociationId = invoiceProductAssociationId;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }
}
