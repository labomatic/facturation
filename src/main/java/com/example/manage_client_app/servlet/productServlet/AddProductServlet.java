package com.example.manage_client_app.servlet.productServlet;

import com.example.manage_client_app.dao.CustomerDao;
import com.example.manage_client_app.dao.InvoiceDao;
import com.example.manage_client_app.dao.ProductDao;
import com.example.manage_client_app.model.Customer;
import com.example.manage_client_app.model.Invoice;
import com.example.manage_client_app.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = "/products/add")
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/add-product.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("productName");
        String description = req.getParameter("productDesc");
        Float price = Float.parseFloat(req.getParameter("productPrice"));
        Float vat = Float.parseFloat(req.getParameter("productVat"));

        Product product = new Product(name, description, price, vat);
        ProductDao productDao = new ProductDao();
        productDao.save(product);

        resp.sendRedirect(req.getContextPath() + "/products");

    }
}
