package api.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

@WebServlet("/wallet")
public class WalletServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {

        User user = new User();
        user.setId("001");
        user.setName("Aj.Tew");

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(), user);

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

class User {
    private String id;
    private String name;
    private double money;

    public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

class Product {
	private String productId;
	private String productName;
	private double productPrice;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
}
