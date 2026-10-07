<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chuyển đổi tiền tệ</title>
</head>
<body>
    <h2>USD to VND Converter</h2>
    <form action="converter.jsp" method="POST">
        <label>Tỉ giá (VND/USD):</label><br/>
        <input type="number" name="rate" value="25000" required step="any"/><br/><br/>
        <label>Lượng USD cần đổi:</label><br/>
        <input type="number" name="usd" placeholder="Nhập số lượng USD" required step="any"/><br/><br/>
        <button type="submit">Tính toán</button>
    </form>
</body>
</html>
