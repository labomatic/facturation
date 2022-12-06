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

@WebServlet(urlPatterns = "/customers/update")
public class UpdateCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long customerId = Long.parseLong(req.getParameter("id"));
        CustomerDao customerDao = new CustomerDao();
        Optional<Customer> customerToEdit = customerDao.get(customerId);
        Customer customer;
        if(customerToEdit.isPresent()) {
            customer = customerToEdit.get();
            req.setAttribute("customer", customer);
        } else {
            req.setAttribute("customerNotFound", true);
        }

        req.getRequestDispatcher("/WEB-INF/update-customer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long customerId = Long.parseLong(req.getParameter("id"));
        String nameToEdit = req.getParameter("customerName");
        String addressToEdit = req.getParameter("customerAddress");
        Integer postcodeToEdit = Integer.parseInt(req.getParameter("customerPostcode"));
        String cityToEdit = req.getParameter("customerCity");
        String phoneNumberToEdit = req.getParameter("customerPhoneNumber");
        String emailToEdit = req.getParameter("customerEmail");
        Customer customerToEdit = new Customer(customerId, nameToEdit, addressToEdit,postcodeToEdit, cityToEdit, phoneNumberToEdit, emailToEdit);
        CustomerDao customerDao = new CustomerDao();

        try{
            Optional<Customer> customerOptional = customerDao.get(customerId);
            if(customerOptional.isPresent()) {
                customerDao.update(customerToEdit);
                resp.sendRedirect(req.getContextPath()+ "/customers");
            } else {
                System.err.println("Cannot update game with id = " + customerId);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


    }
}
