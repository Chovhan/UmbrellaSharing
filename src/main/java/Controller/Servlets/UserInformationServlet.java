package Controller.Servlets;

import Model.DataBase.SharePointInformation;
import Model.DataBase.UserInformation;
import Model.Objects.SharePointInformationDataTransfer;
import Model.Objects.User;
import Model.Objects.UserInformationDataTransfer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/UserInformation")
public class UserInformationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserInformation userInformation = new UserInformation();
        ArrayList<UserInformationDataTransfer> userInformationList = userInformation.getInformationAboutUser();
        System.out.println(userInformationList);
        req.setAttribute("userInformationList", userInformationList);
        req.getRequestDispatcher("/jsp/user_information_page_.jsp").forward(req, resp);
    }
}
