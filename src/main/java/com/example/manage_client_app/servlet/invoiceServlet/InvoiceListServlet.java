package com.example.manage_client_app.servlet.invoiceServlet;


import com.example.manage_client_app.dao.InvoiceDao;

import com.example.manage_client_app.model.Invoice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/invoices")
public class InvoiceListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            InvoiceDao invoiceDao = new InvoiceDao();
            List<Invoice> invoiceList = invoiceDao.getAll();

            req.setAttribute("invoices", invoiceList);
            req.getRequestDispatcher("/WEB-INF/invoice-list.jsp").forward(req, resp);
        }
}
