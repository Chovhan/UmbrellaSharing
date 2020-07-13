package Controller.Servlets;

import Model.DataBase.SharePointInformation;
import Model.Objects.SharePoint;
import Model.Objects.SharePointInformationDataTransfer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/SharingPointInformation")
public class SharingPointInformationPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SharePointInformation sharePointInformation = new SharePointInformation();
        ArrayList<SharePointInformationDataTransfer> sharePointInformationList = sharePointInformation.getSharePointInformation();
        System.out.println(sharePointInformationList);
        req.setAttribute("sharePointInformationList", sharePointInformationList);
        req.getRequestDispatcher("/jsp/sharing_point_information_page.jsp").forward(req, resp);
    }
}
