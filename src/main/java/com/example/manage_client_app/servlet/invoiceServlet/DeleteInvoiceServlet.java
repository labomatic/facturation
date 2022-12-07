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
import java.util.Optional;

@WebServlet(urlPatterns = "/invoices/delete")
public class DeleteInvoiceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long id = Long.parseLong(req.getParameter("invoiceId"));
            InvoiceDao dao = new InvoiceDao();
            Optional<Invoice> invoice = dao.get(id);
            if(invoice.isPresent()) {
                dao.delete(invoice.get());
                resp.sendRedirect(req.getContextPath() + "/invoices");
            } else {
                System.out.println("Invoice not found");
            }
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }

    }
}

