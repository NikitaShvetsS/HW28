package org.example;

import static spark.Spark.*;
import com.google.gson.Gson;

import java.util.List;

public class Controller {
    private OrderRepository orderRepository;

    public Controller(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
        public void initRoutes() {

            port(4567);

            // create new order in system
            post("/orders", (request, response) -> {
                response.type("application/json");

                Order order = new Gson().fromJson(request.body(), Order.class);
                orderRepository.addOrder(order);

                return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS));
            });

            get("/orders/:id", (request, response) -> {
                response.type("application/json");

                String orderId = request.params(":id");
                Order order = orderRepository.getOrderById(orderId);

                if (order != null) {
                    return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS));
                } else {
                    return new Gson().toJson(new StandardResponse(StatusResponse.ERROR));
                }
            });

            // get all orders
            get("/orders", (request, response) -> {
                response.type("application/json");

                List<Order> orders = orderRepository.getAllOrders();
                ApiResponse apiResponse = new ApiResponse(StatusResponse.SUCCESS, orders);

                return new Gson().toJson(apiResponse);
            });

    }
}
