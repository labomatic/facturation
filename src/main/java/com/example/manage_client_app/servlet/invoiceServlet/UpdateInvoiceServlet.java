package com.example.manage_client_app.servlet.invoiceServlet;

import com.example.manage_client_app.dao.CustomerDao;
import com.example.manage_client_app.dao.InvoiceDao;
import com.example.manage_client_app.model.Customer;
import com.example.manage_client_app.model.Invoice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@WebServlet(urlPatterns = "/invoices/update")
public class UpdateInvoiceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long invoiceId = Long.parseLong(req.getParameter("id"));
        InvoiceDao dao = new InvoiceDao();
        Optional<Invoice> invoiceToEdit = dao.get(invoiceId);
        Invoice invoice;
        if(invoiceToEdit.isPresent()) {
            invoice = invoiceToEdit.get();
            req.setAttribute("invoice", invoice);
        } else {
            req.setAttribute("invoiceNotFound", true);
        }
        CustomerDao customerDao = new CustomerDao();
        List<Customer> customerList = customerDao.getAll();
        req.setAttribute("customers", customerList);

        req.getRequestDispatcher("/WEB-INF/update-invoice.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long invoiceId = Long.parseLong(req.getParameter("id"));
        LocalDate dateToEdit = LocalDate.parse(req.getParameter("invoiceDate"));
        Float totalToEdit = Float.parseFloat(req.getParameter("invoiceTotal"));
        Long customerId = Long.parseLong(req.getParameter("invoiceCustomer"));

        CustomerDao customerDao = new CustomerDao();
        Optional<Customer> customer = customerDao.get(customerId);

        try{
            if(customer.isPresent()) {
                Invoice invoiceToEdit = new Invoice(invoiceId, dateToEdit, totalToEdit, customer.get());

                InvoiceDao dao = new InvoiceDao();
                Optional<Invoice> invoiceOptional = dao.get(invoiceId);
                if (invoiceOptional.isPresent()) {
                    dao.update(invoiceToEdit);
                    resp.sendRedirect(req.getContextPath() + "/invoices");
                } else {
                    System.err.println("Cannot update invoice with id = " + invoiceId);
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


    }
}
