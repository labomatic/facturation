package com.example.manage_client_app.servlet.invoiceServlet;

import com.example.manage_client_app.dao.InvoiceDao;
import com.example.manage_client_app.model.Invoice;
import com.example.manage_client_app.model.InvoiceProductAssociation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = "/invoices/details")
public class InvoiceDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InvoiceDao invoiceDao = new InvoiceDao();
        Long id = Long.parseLong(req.getParameter("id"));
        Optional<Invoice> invoice = invoiceDao.get(id);

        if(invoice.isPresent()) {
            req.setAttribute("invoice", invoice.get());
        }

        req.getRequestDispatcher("/WEB-INF/invoice-details.jsp").forward(req, resp);
    }
}
