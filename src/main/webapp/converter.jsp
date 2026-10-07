<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kết quả chuyển đổi</title>
</head>
<body>
    <h2>KẾT QUẢ CHUYỂN ĐỔI</h2>
    <%
        try {
            float rate = Float.parseFloat(request.getParameter("rate"));
            float usd = Float.parseFloat(request.getParameter("usd"));
            float vnd = rate * usd;
    %>
    <p>Tỉ giá: <%= rate %> VND/USD</p>
    <p>Lượng USD: $<%= usd %></p>
    <h3>Thành tiền: <%= vnd %> VNĐ</h3>
    <%
        } catch (Exception e) {
    %>
    <h3>Dữ liệu không hợp lệ!</h3>
    <%
        }
    %>
    <br/>
    <a href="index.jsp">Quay lại trang chủ</a>
</body>
</html>
