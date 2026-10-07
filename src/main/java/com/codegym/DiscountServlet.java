package com.codegym;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "DiscountServlet", urlPatterns = {"/display-discount"})
public class DiscountServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String description = request.getParameter("description");
        String priceStr = request.getParameter("price");
        String percentStr = request.getParameter("discount_percent");

        try (PrintWriter out = response.getWriter()) {
            try {
                double price = Double.parseDouble(priceStr);
                double discountPercent = Double.parseDouble(percentStr);

                // Tính toán theo công thức đề bài
                double discountAmount = price * discountPercent * 0.01;
                double discountPrice = price - discountAmount;

                out.println("<!DOCTYPE html>");
                out.println("<html lang='vi'>");
                out.println("<head>");
                out.println("    <meta charset='UTF-8'>");
                out.println("    <title>Discount Calculation Result</title>");
                out.println("    <style>");
                out.println("        body { font-family: Arial, sans-serif; display: flex; justify-content: center; margin-top: 80px; background-color: #f8fafc; }");
                out.println("        .result-container { background: white; padding: 35px; border-radius: 8px; box-shadow: 0 4px 10px rgba(0,0,0,0.1); width: 400px; }");
                out.println("        h2 { color: #1b2a7a; text-align: center; }");
                out.println("        p { font-size: 16px; margin: 10px 0; color: #333; }");
                out.println("        strong { color: #111; }");
                out.println("        .highlight { color: #27ae60; font-weight: bold; font-size: 18px; }");
                out.println("        a { display: inline-block; margin-top: 20px; text-decoration: none; padding: 10px 20px; background-color: #1b2a7a; color: white; border-radius: 4px; font-weight: bold; }");
                out.println("    </style>");
                out.println("</head>");
                out.println("<body>");
                out.println("    <div class='result-container'>");
                out.println("        <h2>Product Discount Result</h2>");
                out.println("        <p>Product Description: <strong>" + description + "</strong></p>");
                out.println("        <p>List Price: <strong>$" + price + "</strong></p>");
                out.println("        <p>Discount Percent: <strong>" + discountPercent + "%</strong></p>");
                out.println("        <hr style='border: none; border-top: 1px solid #e2e8f0; margin: 15px 0;'/>");
                out.println("        <p>Discount Amount: <span class='highlight'>$" + discountAmount + "</span></p>");
                out.println("        <p>Discount Price: <span class='highlight'>$" + discountPrice + "</span></p>");
                out.println("        <div style='text-align: center;'><a href='index.jsp'>Back to Calculator</a></div>");
                out.println("    </div>");
                out.println("</body>");
                out.println("</html>");

            } catch (NumberFormatException e) {
                out.println("<!DOCTYPE html>");
                out.println("<html><body>");
                out.println("<h2 style='color: red; text-align: center; margin-top: 100px;'>Lỗi: Vui lòng nhập đúng định dạng số!</h2>");
                out.println("<div style='text-align: center;'><a href='index.jsp'>Quay lại</a></div>");
                out.println("</body></html>");
            }
        }
    }
}