package Controller.Servlets;

import Model.DataBase.AddSharePointTransaction;
import Model.Objects.NewSharePointDataTransfer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.Integer.parseInt;

@WebServlet(name = "SharingSettingsServlet", urlPatterns = "/AddSharingPoint")
public class AddSharingSettingsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/add_sharing_point_settings_page.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String country = req.getParameter("country");
        String city = req.getParameter("city");
        String street = req.getParameter("street");
        String houseNumber = req.getParameter("house");
        String availability = req.getParameter("availability");
        NewSharePointDataTransfer newSharePointDataTransfer;
        if (availability.equals("Yes")){
            newSharePointDataTransfer = new NewSharePointDataTransfer(country, city, street, parseInt(houseNumber), 1);
        } else {
            newSharePointDataTransfer = new NewSharePointDataTransfer(country, city, street, parseInt(houseNumber), 0);
        }
        System.out.println(newSharePointDataTransfer);
        AddSharePointTransaction addSharePointTransaction = new AddSharePointTransaction();
        addSharePointTransaction.addSharePoint(newSharePointDataTransfer);
    }
}
