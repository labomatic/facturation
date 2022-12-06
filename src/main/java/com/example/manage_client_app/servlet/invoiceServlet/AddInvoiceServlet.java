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
import java.util.Optional;

@WebServlet(urlPatterns = "/invoices/add")
public class AddInvoiceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerDao customerDao = new CustomerDao();
        List<Customer> customerList = customerDao.getAll();
        req.setAttribute("customers", customerList);
        req.getRequestDispatcher("/WEB-INF/add-invoice.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDate date = LocalDate.parse(req.getParameter("invoiceDate"));
        Float total = Float.parseFloat(req.getParameter("invoiceTotal"));
        Long customerId = Long.parseLong(req.getParameter("invoiceCustomer"));

        CustomerDao customerDao = new CustomerDao();
        Optional<Customer> customer = customerDao.get(customerId);

        if(customer.isPresent()) {
            Invoice invoice = new Invoice(date, total, customer.get());
            InvoiceDao invoiceDao = new InvoiceDao();
            invoiceDao.save(invoice);

            resp.sendRedirect(req.getContextPath() + "/invoices");
        } else {
            System.out.println("Customer not found");
        }

    }
}
