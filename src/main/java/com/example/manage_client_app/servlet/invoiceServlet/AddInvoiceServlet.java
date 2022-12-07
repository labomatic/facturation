package com.example.manage_client_app.servlet.invoiceServlet;

import com.example.manage_client_app.dao.CustomerDao;
import com.example.manage_client_app.dao.AssociationDao;
import com.example.manage_client_app.dao.InvoiceDao;
import com.example.manage_client_app.dao.ProductDao;
import com.example.manage_client_app.model.Customer;
import com.example.manage_client_app.model.Invoice;
import com.example.manage_client_app.model.InvoiceProductAssociation;
import com.example.manage_client_app.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@WebServlet(urlPatterns = "/invoices/add")
public class AddInvoiceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerDao customerDao = new CustomerDao();
        List<Customer> customerList = customerDao.getAll();
        ProductDao productDao = new ProductDao();
        List<Product> productList = productDao.getAll();
        req.setAttribute("customers", customerList);
        req.setAttribute("products", productList);
        req.getRequestDispatcher("/WEB-INF/add-invoice.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDao productDao = new ProductDao();
        CustomerDao customerDao = new CustomerDao();
        AssociationDao associationDao = new AssociationDao();

        LocalDate date = LocalDate.parse(req.getParameter("invoiceDate"));
        Long customerId = Long.parseLong(req.getParameter("invoiceCustomer"));
        Float total = 0F;

        String[] quantitiesStr = req.getParameterValues("productQuantity");
        List<Integer> quantities = new ArrayList<>();
        for(int i=0; i<quantitiesStr.length; i++) {
            if(quantitiesStr[i].equals(""))  {

            } else {
                quantities.add(Integer.parseInt(quantitiesStr[i]));
            }
        }

        String[] productIdListStr = req.getParameterValues("product");
        Long[] productIdList = new Long[productIdListStr.length];
        for(int i =0; i<productIdListStr.length; i++) {
            productIdList[i] = Long.parseLong(productIdListStr[i]);
            Float price = productDao.get(productIdList[i]).get().getPrice();
            total += price*quantities.get(i);
        }

        Optional<Customer> customer = customerDao.get(customerId);

        if(customer.isPresent()) {
            Invoice invoice = new Invoice(date, total, customer.get());
            InvoiceDao invoiceDao = new InvoiceDao();
            invoiceDao.save(invoice);

            for(int i=0; i< productIdList.length; i++) {
                Optional<Product> product = productDao.get(productIdList[i]);
                if(product.isPresent()) {
                    InvoiceProductAssociation invoiceProductAssociation = new InvoiceProductAssociation(product.get(), invoice, quantities.get(i));
                    associationDao.save(invoiceProductAssociation);
                }
            }
            resp.sendRedirect(req.getContextPath() + "/invoices");
        } else {
            System.out.println("Customer not found");
        }

    }
}
