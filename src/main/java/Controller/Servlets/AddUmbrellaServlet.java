package Controller.Servlets;

import Model.DataBase.AddUmbrellaTransaction;
import Model.DataBase.ManufacturingInformation;
import Model.DataBase.SharePointInformation;
import Model.Objects.Manufacturing;
import Model.Objects.NewUmbrellaDataTransfer;
import Model.Objects.SharePointInformationDataTransfer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

@WebServlet(name = "AddUmbrellaServlet", urlPatterns = "/AddUmbrella")
public class AddUmbrellaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ManufacturingInformation manufacturingInformation = new ManufacturingInformation();
        SharePointInformation sharePointInformation = new SharePointInformation();
        ArrayList<Manufacturing> manufacturingList = manufacturingInformation.getManufacturingInformation();
        ArrayList<SharePointInformationDataTransfer> sharePointList = sharePointInformation.getSharePointInformation();
        req.setAttribute("manufacturerList", manufacturingList);
        req.setAttribute("sharePointInformationList", sharePointList);
        req.getRequestDispatcher("/jsp/add_umbrella_settings_page.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewUmbrellaDataTransfer newUmbrellaDataTransfer;
        AddUmbrellaTransaction addUmbrellaTransaction = new AddUmbrellaTransaction();
        String manufacturer = req.getParameter("manufacturer");
        String umbrellaModel = req.getParameter("model");
        String sharePoint = req.getParameter("sharePoint");
        String availability = req.getParameter("availability");

        if (availability.equals("Yes")){
             newUmbrellaDataTransfer = new NewUmbrellaDataTransfer(manufacturer, umbrellaModel, 1, parseInt(sharePoint));
        } else {
            newUmbrellaDataTransfer = new NewUmbrellaDataTransfer(manufacturer, umbrellaModel, 0, parseInt(sharePoint));
        }
        System.out.println(newUmbrellaDataTransfer);
        addUmbrellaTransaction.addUmbrella(newUmbrellaDataTransfer);
    }
}
