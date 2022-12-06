package com.example.manage_client_app.servlet.customerServlet;

import com.example.manage_client_app.dao.CustomerDao;
import com.example.manage_client_app.model.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/customers/delete")
public class DeleteCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long id = Long.parseLong(req.getParameter("customerId"));
            CustomerDao dao = new CustomerDao();
            Optional<Customer> customer = dao.get(id);
            if(customer.isPresent()) {
                dao.delete(customer.get());
                resp.sendRedirect(req.getContextPath() + "/customers");
            } else {
                System.out.println("customer not found");
            }
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }

    }
}
