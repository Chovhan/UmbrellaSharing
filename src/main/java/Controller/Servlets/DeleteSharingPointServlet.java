package Controller.Servlets;

import Model.DataBase.DeleteSharingPointTransaction;
import Model.DataBase.SharePointInformation;
import Model.Objects.SharePointInformationDataTransfer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

@WebServlet(name = "DeleteSharingPointServlet", urlPatterns = "/DeleteSharingPoint")
public class DeleteSharingPointServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SharePointInformation sharePointInformation = new SharePointInformation();
        ArrayList<SharePointInformationDataTransfer> sharePointInformationList = sharePointInformation.getSharePointInformation();
        System.out.println(sharePointInformationList);
        req.setAttribute("sharePointInformationList", sharePointInformationList);
        req.getRequestDispatcher("/jsp/delete_sharing_point_settings_page.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sharePointNumber = req.getParameter("number");
        DeleteSharingPointTransaction deleteSharingPointTransaction = new DeleteSharingPointTransaction();
        deleteSharingPointTransaction.deleteSharePoint(parseInt(sharePointNumber));
    }
}
