package api.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

@WebServlet("/product")
public class WalletProductService extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {

        
        Product product = new Product();
        product.setProductId("001");
        product.setProductName("coco");
        product.setProductPrice(55);

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(), product);

    }


}