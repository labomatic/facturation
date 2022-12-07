package com.example.manage_client_app.servlet.productServlet;

import com.example.manage_client_app.dao.InvoiceDao;
import com.example.manage_client_app.dao.ProductDao;
import com.example.manage_client_app.model.Invoice;
import com.example.manage_client_app.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/products")
public class ProductListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDao productDao = new ProductDao();
        List<Product> productList = productDao.getAll();

        req.setAttribute("products", productList);
        req.getRequestDispatcher("/WEB-INF/product-list.jsp").forward(req, resp);
    }
}
