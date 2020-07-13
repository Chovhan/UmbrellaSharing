package Controller.Servlets;

import Model.DataBase.ChangeUmbrellaPlaceInformation;
import Model.DataBase.DeleteUmbrellaTransaction;
import Model.Objects.ChangeUmbrellaDataTransfer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

@WebServlet(name = "DeleteUmbrellaServlet", urlPatterns = "/DeleteUmbrella")
public class DeleteUmbrellaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ChangeUmbrellaPlaceInformation changeUmbrellaPlaceInformation = new ChangeUmbrellaPlaceInformation();
        ArrayList<ChangeUmbrellaDataTransfer> umbrellaInfoList = changeUmbrellaPlaceInformation.getInformation();
        req.setAttribute("umbrellaInfo", umbrellaInfoList);
        req.getRequestDispatcher("/jsp/delete_umbrella_settings_page.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String number = req.getParameter("number");
        System.out.println(number);
        DeleteUmbrellaTransaction deleteUmbrellaTransaction = new DeleteUmbrellaTransaction();
        deleteUmbrellaTransaction.deleteUmbrella(parseInt(number));
    }
}
