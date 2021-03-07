package edu.escuelaing.arep.app.Spark;

import static spark.Spark.*;

import edu.escuelaing.arep.app.ManageServices.Service;

public class SparkServer {
	public static void main(String[] args) {
		Service service = new Service();
		port(getPort());
		System.out.println("Running in "+ getPort() + " port");
		staticFiles.location("/public");
		post("/send", (req, resp) -> {
			String message = req.body();
			String newMessage = message.replace("\"", "");
			service.insert(newMessage);
			return "{\"message\": \"ACCEPT\" }";
		});
		get("/messages", (req, resp) -> {
			return service.getData();
		});
	}

	static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 4567;
	}
}
