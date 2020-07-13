package Controller.Servlets;

import Model.DataBase.ChangeSharePointAvailabilityTransaction;
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

import static java.lang.Integer.parseInt;

@WebServlet(name = "ChangeSharingPointAvailabilityServlet", urlPatterns = "/ChangeSharingPointAvailability")
public class ChangeSharePointAvailabilityServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SharePointInformation sharePointInformation = new SharePointInformation();
        ArrayList<SharePointInformationDataTransfer> sharePointInformationList = sharePointInformation.getSharePointInformation();
        System.out.println(sharePointInformationList);
        req.setAttribute("sharePointInformationList", sharePointInformationList);
        req.getRequestDispatcher("/jsp/change_availability_sharing_point_settings_page.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ChangeSharePointAvailabilityTransaction changeSharePointAvailabilityTransaction = new ChangeSharePointAvailabilityTransaction();
        SharePoint sharePoint;
        String sequenceNumber = req.getParameter("number");
        String method = req.getParameter("id");
        System.out.println(sequenceNumber);
        System.out.println(method.indexOf("close"));
        if (method.contains("open")) {
            sharePoint = new SharePoint(parseInt(sequenceNumber), 1);
        } else {
            sharePoint = new SharePoint(parseInt(sequenceNumber), 0);
        }
        changeSharePointAvailabilityTransaction.changeAvailability(sharePoint);

//        resp.setContentType("application/json");
//        resp.setCharacterEncoding("utf-8");
//        try (PrintWriter printer = resp.getWriter()) {
//            SharePoint responceSharePoint = new SharePoint(parseInt(sequenceNumber), 1);
//            printer.print(createResponceToAjax(responceSharePoint));
//        }
    }
//
//    protected JSONObject createResponceToAjax(SharePoint sharePoint){
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("availability", sharePoint.getAvailability());
//        return jsonObject;
//    }

}
