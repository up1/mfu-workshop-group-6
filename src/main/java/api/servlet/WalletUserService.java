package api.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

@WebServlet("/user")
public class WalletUserService extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {

        User user = new User();
        user.setId("001");
        user.setName("Aj.Tew");
        user.setMoney(1500);

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(), user);
        
        Product product = new Product();
        product.setProductId("001");
        product.setProductName("coco");
        product.setProductPrice(55);

        ObjectMapper mapper1 = new ObjectMapper();
        mapper1.writeValue(response.getOutputStream(), product);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        User sendUser = mapper.readValue(req.getInputStream(), User.class);

        User user = new User();
        user.setId("001");
        user.setName("Response from POST form " + sendUser.getName());

        mapper.writeValue(response.getOutputStream(), user);

    }

}